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
#include <stdio.h>

#define SIZE 100

extern int v[SIZE];

extern void fibonacci();

//~ int cooompletelyUselessVariable __attribute__((ASPIRE("requirement(integrity)"))) = 88;

int main()
{
	int i;
	//~ _Pragma("ASPIRE begin requirement(confidentiality)")
	//~ cooompletelyUselessVariable = 0;
	//~ _Pragma("ASPIRE end")
	//~ _Pragma("ASPIRE begin requirement(privacy)")
	fibonacci();
	//~ _Pragma("ASPIRE end")

	for (i = 0; i < SIZE; ++i)
		printf("%d ", v[i]);
	printf("\n");

	return 0;
}
