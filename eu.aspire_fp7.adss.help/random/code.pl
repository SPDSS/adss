#!/usr/bin/perl
#*******************************************************************************
# Copyright (c) 2016 Politecnico di Torino.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     Politecnico di Torino - initial API and implementation
#*******************************************************************************

use strict;
use warnings;

use constant MAX_CALL_DEPTH => 4;
use constant MAX_CALLS_PER_FUNCTION => 4;
use constant MAX_VARIABLES_PER_FUNCTION => 5;
use constant MAX_NESTING => 4;
use constant MAX_INSTRUCTIONS_PER_LEVEL => 10;

my $functionCounter = 0;

sub generateInstructions
{
	my $instructionCount = 1 + int(rand(MAX_INSTRUCTIONS_PER_LEVEL));
	my $indent = $_[0];
	my $variables = $_[1];
	my $code = "";

	for (my $i = 0; $i < $instructionCount; $i++)
	{
		$code .= generateInstruction($indent, $variables);
	}

	return $code;
}

sub generateInstruction
{
	my $indent = $_[0];
	my $variables = $_[1];
	my @operators = ("+=", "-=", "*=", "/=", "%=", "<<=", ">>=", "&=", "|=", "^=", "if", "if-else", "while");
	@operators = ("+=", "-=", "*=", "/=", "%=", "<<=", ">>=", "&=", "|=", "^=") if $indent == MAX_NESTING;
	my $operator = $operators[int(rand($#operators + 1))];
	my $input = "v" . int(rand($variables));

	if ($operator eq "if")
	{
		return "\t" x $indent . "scanf(\"%d\", &" . $input . ");\n" . "\t" x $indent . "if (" . $input . " > 0)\n" . "\t" x $indent . "{\n" . generateInstructions($indent + 1, $variables) . "\t" x $indent . "}\n";
	}
	elsif ($operator eq "if-else")
	{
		return "\t" x $indent . "scanf(\"%d\", &" . $input . ");\n" . "\t" x $indent . "if (" . $input . " > 0)\n" . "\t" x $indent . "{\n" . generateInstructions($indent + 1, $variables) . "\t" x $indent . "}\n" .
			"\t" x $indent . "else\n". "\t" x $indent . "{\n" . generateInstructions($indent + 1, $variables) . "\t" x $indent . "}\n";
	}
	elsif ($operator eq "while")
	{
		return "\t" x $indent . "scanf(\"%d\", &" . $input . ");\n" . "\t" x $indent . "while (--" . $input . " > 0)\n" . "\t" x $indent . "{\n" . generateInstructions($indent + 1, $variables) . "\t" x $indent . "}\n";
	}
	
	if (int(rand(2)) == 0)
	{
		if (int(rand(2)) == 0)
		{
			return "\t" x $indent . "scanf(\"%d\", &" . $input . ");\n" . "\t" x $indent . "r " . $operator . " " . $input . ";\n"
		}
		else
		{
			return "\t" x $indent . "r " . $operator . " " . $input . ";\n"
		}
	}
	else
	{
		return "\t" x $indent . "r " . $operator . " " . int(rand(0x1000)) . ";\n"
	}
}

sub generateCall
{
	my $indent = $_[0];
	my $variable = $_[1];
	my $call = $_[2];
	my @operators = ("+=", "-=", "*=", "/=", "%=", "<<=", ">>=", "&=", "|=", "^=");
	my $operator = $operators[int(rand($#operators + 1))];
	
	return "\t" x $indent . $variable . " " . $operator . " " . $call . "(" . int(rand(0x10000)) . ");\n";
}

sub generateFunction
{
	my $code = "";
	my $name = "function" . $functionCounter++;
	my $depth = $_[0];
	my $functionCount = 1 + int(rand(MAX_CALLS_PER_FUNCTION));
	my $variableCount = 1 + int(rand(MAX_VARIABLES_PER_FUNCTION));
	$functionCount = 0 if $depth == MAX_CALL_DEPTH;
	my @names = ();

	for (my $i = 0; $i < $functionCount; $i++)
	{
		my ($n, $c) = generateFunction($depth + 1);
		$code .= $c;
		push(@names, $n);
	}
	
	$code .= "int " . $name . "(int p)\n";
	$code .= "{\n";
	$code .= "\t_Pragma(\"ASPIRE begin requirement(confidentiality, integrity)\")\n";
	$code .= "\tint r = " . int(rand(0x1000)) . ";\n";
	for (my $i = 0; $i < $variableCount; $i++)
	{
		$code .= "\tint v" . $i . " = " . int(rand(0x1000)) . ";\n";
	}
	$code .= "\n";
	for (my $i = 0; $i < $variableCount; $i++)
	{
		$code .= "\tscanf(\"%d\", &v" . $i . ");\n" if (int(rand(2)) == 0);
	}
	$code .= generateInstructions(1, $variableCount);
	for my $i (@names)
	{
		$code .= generateCall(1, "r", $i);
	}
	$code .= "\n";
	$code .= "\treturn r;\n";
	$code .= "\t_Pragma(\"ASPIRE end\")\n";
	$code .= "}\n";
	$code .= "\n";
	
	return ($name, $code);
}

sub generateMain
{
	my $code = "";
	my $functionCount = 1 + int(rand(MAX_CALLS_PER_FUNCTION));
	my @names = ();

	$code .= "#include <stdio.h>\n";
	$code .= "\n";
	for (my $i = 0; $i < $functionCount; $i++)
	{
		my ($n, $c) = generateFunction(1);
		$code .= $c;
		push(@names, $n);
	}
	$code .= "int main()\n";
	$code .= "{\n";
	$code .= "\tint r = " . int(rand(0x1000)) . ";\n";
	$code .= "\n";
	for my $i (@names)
	{
		$code .= generateCall(1, "r", $i);
	}
	$code .= "\n";
	$code .= "\tprintf(\"%d\", r);\n";
	$code .= "\n";
	$code .= "\treturn 0;\n";
	$code .= "}\n";
}

print generateMain();
