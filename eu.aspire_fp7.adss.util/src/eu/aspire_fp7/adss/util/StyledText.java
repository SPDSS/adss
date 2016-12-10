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

import org.eclipse.swt.custom.StyleRange;

/**
 * A styled text for a viewer.
 * @author Daniele Canavese
 **/
public class StyledText
{
	/**
	 * Creates the styled text with no style.
	 * @param text
	 *            The text.
	 **/
	public StyledText(String text)
	{
		this(text, null);
	}

	/**
	 * Creates the styled text.
	 * @param text
	 *            The text.
	 * @param styleRanges
	 *            The text ranges.
	 **/
	public StyledText(String text, StyleRange styleRanges[])
	{
		this.text = text;
		this.styleRanges = styleRanges;
	}

	/** The text. **/
	private String text;
	/** The style ranges. **/
	private StyleRange styleRanges[];

	/**
	 * Retrieve the text.
	 * @return The text.
	 **/
	public String getText()
	{
		return text;
	}

	/**
	 * Retrieve the style ranges.
	 * @return The style ranges.
	 **/
	public StyleRange[] getStyleRanges()
	{
		return styleRanges;
	}
}
