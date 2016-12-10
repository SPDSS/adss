/*******************************************************************************
 * Copyright (c) 2016 Politecnico di Torino.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Politecnico di Torino - initial API and implementation
 *******************************************************************************/
package eu.aspire_fp7.adss.akb.ui.nattables;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.resize.command.RowResizeCommand;
import org.eclipse.nebula.widgets.nattable.style.CellStyleUtil;
import org.eclipse.nebula.widgets.nattable.style.IStyle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import eu.aspire_fp7.adss.akb.ui.Activator;
import eu.aspire_fp7.adss.util.Eclipse;

/**
 * The ADSS custom painter.
 * @author Daniele Canavese
 **/
public class ADSSPainter extends TextPainter
{
	/** The image map. **/
	static Map<String, Image> imageMap = new HashMap<>();

	/**
	 * Creates the painter.
	 **/
	public ADSSPainter()
	{
		super(false, true, false, true);
	}

	/**
	 * Paints a cell.
	 * @param cell
	 *            The cell.
	 * @param gc
	 *            The cell's gc.
	 * @param rectangle
	 *            The cell's rectangle.
	 * @param configRegistry
	 *            The configuration registry.
	 **/
	@Override
	public void paintCell(ILayerCell cell, GC gc, Rectangle rectangle, IConfigRegistry configRegistry)
	{
		// if (paintBg)
		// super.paintCell(cell, gc, rectangle, configRegistry);

		if (paintFg)
		{
			Rectangle originalClipping = gc.getClipping();
			gc.setClipping(rectangle.intersection(originalClipping));

			IStyle cellStyle = CellStyleUtil.getCellStyle(cell, configRegistry);
			setupGCFromConfig(gc, cellStyle);

			int fontHeight = gc.getFontMetrics().getHeight();
			String text = convertDataType(cell, configRegistry);

			text = getTextToDisplay(cell, gc, rectangle.width, text);

			int numberOfNewLines = getNumberOfNewLines(text);

			int contentHeight = (fontHeight * numberOfNewLines) + (spacing * 2);
			int contentToCellDiff = (cell.getBounds().height - rectangle.height);

			if (performRowResize(contentHeight, rectangle))
			{
				ILayer layer = cell.getLayer();
				layer.doCommand(new RowResizeCommand(layer, cell.getRowPosition(), contentHeight + contentToCellDiff));
			}

			if (numberOfNewLines == 1)
			{
				int contentWidth = Math.min(getLengthFromCache(gc, text), rectangle.width);

				render(gc, text, rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, contentWidth) + spacing,
						rectangle.y + CellStyleUtil.getVerticalAlignmentPadding(cellStyle, rectangle, contentHeight) + spacing);

				int x = rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, contentWidth) + spacing;
				int y = rectangle.y + CellStyleUtil.getVerticalAlignmentPadding(cellStyle, rectangle, contentHeight) + spacing;
				int length = gc.textExtent(text).x;
				paintDecoration(cellStyle, gc, x, y, length, fontHeight);
			}
			else
			{
				int yStartPos = rectangle.y + CellStyleUtil.getVerticalAlignmentPadding(cellStyle, rectangle, contentHeight);
				String[] lines = text.split("\n");
				for (String line : lines)
				{
					int lineContentWidth = Math.min(getLengthFromCache(gc, line), rectangle.width);

					render(gc, line,
							rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, lineContentWidth) + spacing,
							yStartPos + spacing);

					int x = rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, lineContentWidth) + spacing;
					int y = yStartPos + spacing;
					int length = gc.textExtent(line).x;
					paintDecoration(cellStyle, gc, x, y, length, fontHeight);

					yStartPos += fontHeight;
				}
			}

			gc.setClipping(originalClipping);
			resetGC(gc);
		}
	}

	/**
	 * Renders a text without new lines.
	 * @param gc
	 *            The GC to use.
	 * @param text
	 *            The text to render.
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 **/
	private void render(GC gc, String text, int x, int y)
	{
		for (String i : split(text))
		{
			Image image = getImage(i);
			if (image == null)
			{
				if (!i.startsWith("<"))
				{
					Point point = gc.stringExtent(i);
					gc.drawText(i, x, y, SWT.DRAW_TRANSPARENT | SWT.DRAW_DELIMITER);
					x += point.x;
				}
			}
			else
			{
				int offset = (gc.getFontMetrics().getHeight() - image.getBounds().height) / 2;
				gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, x, y + offset, image.getBounds().width,
						image.getBounds().height);
				x += image.getBounds().width;
			}
		}
	}

	/**
	 * Splits a text into its tokens.
	 * @param text
	 *            The text to split.
	 * @return The text tokens.
	 **/
	private List<String> split(String text)
	{
		ArrayList<String> tokens = new ArrayList<>();
		String token = new String();

		for (int i = 0; i < text.length(); ++i)
		{
			char c = text.charAt(i);
			if (c == '<')
			{
				tokens.add(token);
				token = new String();
				token = token + c;
			}
			else if (i == text.length() - 1 || c == '>')
			{
				token = token + c;
				tokens.add(token);
				token = new String();
			}
			else
				token = token + c;
		}

		return tokens;
	}

	/**
	 * Retrieves the image of a token.
	 * @param token
	 *            The token.
	 * @return The image or <code>null</code> if no image is associated.
	 */
	private Image getImage(String token)
	{
		try
		{
			if (imageMap.containsKey(token))
				return imageMap.get(token);
			else if (token.equals("<asset/>"))
				imageMap.put(token, Eclipse.getImage(Activator.PLUGIN_ID, "icons/assetBadge.png"));
			else if (token.equals("<low/>"))
				imageMap.put(token, Eclipse.getImage(Activator.PLUGIN_ID, "icons/lowBadge.png"));
			else if (token.equals("<medium/>"))
				imageMap.put(token, Eclipse.getImage(Activator.PLUGIN_ID, "icons/mediumBadge.png"));
			else if (token.equals("<high/>"))
				imageMap.put(token, Eclipse.getImage(Activator.PLUGIN_ID, "icons/highBadge.png"));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
