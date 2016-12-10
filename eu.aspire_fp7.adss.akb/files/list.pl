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
use JSON;
use File::Slurp;
use File::Basename;
use Cwd "abs_path";

my $text = read_file($ARGV[0]);
$text =~ s/\/\/.*//g;

my $json = decode_json($text);
my $frontend = $json->{"tools"}->{"frontend"};
my @sources = @{ $json->{"src2src"}->{"SLP01"}->{"source"} };
my @preprocessFlags = @{ $json->{"src2bin"}->{"PREPROCESS"}->{"options"} };
my @compilationFlags = @{ $json->{"src2bin"}->{"COMPILE"}->{"options"} };
my @cCompilationFlags = @{ $json->{"src2bin"}->{"COMPILE"}->{"options_c"} };
my @cppCompilationFlags = @{ $json->{"src2bin"}->{"COMPILE"}->{"options_cpp"} };
my @linkFlags = @{ $json->{"src2bin"}->{"LINK"}->{"options"} };
my $name = $json->{"src2bin"}->{"LINK"}->{"binary"};

my @files = ();

foreach my $i (@sources)
{
	foreach my $j (glob($i))
	{
		push(@files, "true " . abs_path($j));
		if ($j =~ /\.(c|C|cpp|cxx|cc)/ and $ARGV[1] eq "true")
		{
			my $command = "$frontend @preprocessFlags -M -E $j";
			foreach my $k (split(/\s*\n\s*/, `$command`))
			{
				$k =~ s/^\s+//;
				$k =~ s/\s*\\$//;
				$k = abs_path($k);
				push(@files, "false " . $k) if (defined $k and $k =~ /^.*\.(h|H)$/);
			}
		}
	}
}

my %hash = map { $_, 1 } @files;
foreach my $i (keys %hash)
{
	print $i . "\n";
}
