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
#define SIZE 100

int v[SIZE] __attribute__((ASPIRE("requirement(confidentiality)")));

void fibonacci()
{
	int first = 0, second = 1, i;
	int next;

	for (i = 0; i < SIZE; ++i)
	{
		if (i <= 1)
			next = i;
		else
		{
			_Pragma("ASPIRE begin requirement(privacy)")
			next = first + second;
			_Pragma("ASPIRE end")
			_Pragma("ASPIRE begin requirement(integrity)")
			first = second;
			_Pragma("ASPIRE end")
			_Pragma("ASPIRE begin requirement(confidentiality)")
			second = next;
			_Pragma("ASPIRE end")
		}
		//~ _Pragma("ASPIRE begin requirement(confidentiality)")
		v[i] = next;
		//~ _Pragma("ASPIRE end")
	}
}
