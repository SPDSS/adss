/*******************************************************************************
 * Copyright (c) 2014, 2016 Politecnico di Torino. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Politecnico di Torino - initial API and implementation
 ******************************************************************************/
package it.polito.security.ontologies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.derivo.sparqldlapi.QueryToken;
import de.derivo.sparqldlapi.QueryTokenizer;

/**
 * A custom query tokenizer for SPARQL-DL.
 * @author Luca Moretto, Daniele Canavese
 **/
class CustomQueryTokenizer implements QueryTokenizer
{
	/**
	 * The constructor.
	 **/
	public CustomQueryTokenizer()
	{
		skip = new HashSet<>();
		skip.add(' ');
		skip.add('\n');
		skip.add('\r');
		skip.add('\t');

		delims = new HashSet<>();
		delims.add(',');
		delims.add('(');
		delims.add(')');
		delims.add('{');
		delims.add('}');
	}

	/**
	 * Consumes a token.
	 **/
	private void consumeToken()
	{
		if (sb.length() > 0)
		{
			tokens.add(new QueryToken(sb.toString(), startPos, startCol, startRow));
			sb = new StringBuilder();
		}
		startPos = pos;
		startCol = col;
		startRow = row;
	}

	/**
	 * Reads a new char updating the position, row and column numbers.
	 * @return The read char.
	 **/
	private char readChar()
	{
		char ch = buffer.charAt(pos);
		pos++;
		col++;
		if (ch == '\n')
		{
			row++;
			col = 0;
		}

		return ch;
	}

	/**
	 * Reads an IRI.
	 **/
	private void readIRI()
	{
		sb.append('<');
		while (pos < buffer.length())
		{
			char ch = readChar();
			sb.append(ch);
			if (ch == '>')
				break;
		}
		consumeToken();

	}

	/**
	 * Reads a literal.
	 **/
	private void readLiteral()
	{
		sb.append('\"');
		while (pos < buffer.length())
		{
			char ch = readChar();
			if (ch == '\\')
			{
				if (pos + 1 < buffer.length())
				{
					char escapedChar = readChar();
					if (escapedChar == '"' || escapedChar == '\\')
						sb.append(escapedChar);
					else
					{
						sb.append(ch);
						sb.append(escapedChar);
					}
				}
				else
					sb.append(ch);
			}
			else if (ch == '\"')
			{
				sb.append(ch);
				break;
			}
			else
				sb.append(ch);
		}
		consumeToken();
	}

	/**
	 * Resets the tokenizer.
	 **/
	private void reset()
	{
		sb = new StringBuilder();
		tokens.clear();
		pos = 0;
		col = 1;
		row = 1;
		startPos = 0;
		startCol = 1;
		startRow = 1;
		buffer = null;
	}

	/**
	 * Splits a string into a set of tokens.
	 * @param string
	 *            The string to split.
	 * @return The list of tokens.
	 **/
	@Override
	public List<QueryToken> tokenize(final String string)
	{
		reset();

		this.buffer = string;

		while (pos < buffer.length())
		{
			char ch = readChar();

			if (ch == '<')
				readIRI();
			else if (ch == '\"')
				readLiteral();
			else if (skip.contains(ch))
				consumeToken();
			else if (delims.contains(ch))
			{
				consumeToken();
				sb.append(ch);
				consumeToken();
			}
			else
				sb.append(ch);
		}
		consumeToken();
		tokens.add(new QueryToken("<EOF>", pos, col, row));

		return tokens;
	}

	/** The current string to analyze. **/
	private String buffer;
	/** The current column of the tokenizer. **/
	private int col;
	/** The set of delimitators. **/
	private Set<Character> delims;
	/** The current position of the tokenizer. **/
	private int pos;
	/** The current row of the tokenizer. **/
	private int row;
	/** A temporary string for the tokenizer. **/
	private StringBuilder sb;
	/** The set of characters to skip. **/
	private Set<Character> skip;
	/** The starting column number. **/
	private int startCol;
	/** The starting position number. **/
	private int startPos;
	/** The starting row number. **/
	private int startRow;
	/** The list of detected tokens. **/
	private List<QueryToken> tokens = new ArrayList<>();

}
