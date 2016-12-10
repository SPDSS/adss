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
package eu.aspire_fp7.adss.util;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

/**
 * Styles utilities.
 * @author Daniele Canavese
 **/
public class Styles
{
	/**
	 * Formats the textual content of a cell.
	 * @param name
	 *            The name of an object.
	 * @param type
	 *            The type of the object or <code>null</code>/the empty string to disable it.
	 * @param count
	 *            The children count or <code>null</code>/0 to disable it.
	 * @param style
	 *            The style.
	 * @return The styled text.
	 **/
	static public StyledText format(String name, String type, Integer count, StyleType style)
	{
		Collection<StyleRange> styles = new ArrayList<>();
		String text;

		StyleRange range1 = new StyleRange(new TextStyle());
		range1.start = 0;
		range1.length = name.length();
		if (style == StyleType.EMPHASIS)
		{
			range1.fontStyle = SWT.BOLD;
			range1.underline = true;
			range1.underlineColor = Display.getDefault().getSystemColor(SWT.COLOR_BLUE);
			range1.underlineStyle = SWT.UNDERLINE_SINGLE;
		}
		else if (style == StyleType.CANCEL)
		{
			range1.fontStyle = SWT.ITALIC;
			range1.background = new Color(Display.getDefault(), 255, 200, 200);
			range1.strikeout = true;
			range1.strikeoutColor = Display.getDefault().getSystemColor(SWT.COLOR_RED);
		}
		styles.add(range1);
		text = name;

		if (type != null && !type.isEmpty())
		{
			StyleRange range2 = new StyleRange(new TextStyle());
			range2.start = name.length() + 3;
			range2.length = type.length();
			range2.foreground = Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED);
			styles.add(range2);
			text = text + " : " + type;
		}

		if (count != null && count > 0)
		{
			StyleRange range3 = new StyleRange(new TextStyle());
			if (type != null && !type.isEmpty())
				range3.start = name.length() + 3 + type.length() + 1;
			else
				range3.start = name.length() + 1;
			range3.length = String.valueOf(count).length() + 2;
			range3.foreground = Display.getDefault().getSystemColor(SWT.COLOR_BLUE);
			text = text + " (" + count + ")";
			styles.add(range3);
		}

		return new StyledText(text, styles.toArray(new StyleRange[] {}));
	}

	/**
	 * Private constructor.
	 **/
	private Styles()
	{
	}
}
