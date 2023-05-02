#!/bin/sh
# qqwing - Sudoku solver and generator
# Copyright (C) 2014 Stephen Ostermiller
#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; either version 2 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License along
# with this program; if not, write to the Free Software Foundation, Inc.,
# 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
set -e

if [ -e target/javacompile ]
then
	newer=`find src/java/ -type f -newer target/javacompile`
	if [ "z$newer" = "z" ]
	then
		exit 0
	fi
fi

mkdir -p target/classes
echo "Compiling java sources"
find src/java/ -name *.java -print0 | xargs -0 javac -sourcepath src/java/ -d target/classes/
touch target/javacompile
