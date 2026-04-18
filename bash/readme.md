<!-- prettier-ignore-start -->
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents** _generated with
[DocToc](https://github.com/thlorenz/doctoc)_

- [Bash Quickref](#bash-quickref)
  - [Variables](#variables)
  - [Strings](#strings)
  - [Arithmetic](#arithmetic)
  - [Arrays](#arrays)
  - [Control Flow](#control-flow)
  - [Loops](#loops)
  - [Functions](#functions)
  - [Input / Output](#input--output)
  - [Exit Codes](#exit-codes)
  - [Useful Patterns](#useful-patterns)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->
<!-- prettier-ignore-end -->

# Bash Quickref

```bash
#!/usr/bin/env bash
set -euo pipefail
```

## Variables

```bash
name="Alice"       # no spaces around =
echo "$name"       # always quote variables
echo "${name}!"    # braces for disambiguation

readonly PI=3.14   # constant
unset name         # delete variable

# Default values
echo "${var:-default}"   # use default if unset/empty
echo "${var:=default}"   # assign and use default if unset/empty
echo "${var:?error msg}" # error and exit if unset/empty
```

## Strings

```bash
s="hello world"
echo "${#s}"              # length: 11
echo "${s:0:5}"           # substring: hello
echo "${s/world/bash}"    # replace first: hello bash
echo "${s//l/L}"          # replace all: heLLo worLd
echo "${s^^}"             # uppercase: HELLO WORLD
echo "${s,,}"             # lowercase

# Trim prefix/suffix
f="file.tar.gz"
echo "${f%.gz}"           # file.tar   (shortest suffix match)
echo "${f%%.tar*}"        # file       (longest suffix match using ##)
echo "${f#*.}"            # tar.gz     (shortest prefix match)
echo "${f##*.}"           # gz         (longest prefix match)
```

## Arithmetic

```bash
x=5
echo $((x + 3))     # 8
echo $((x ** 2))    # 25
echo $((x % 3))     # 2
(( x++ ))           # increment
(( x += 10 ))

# No floats — use bc or awk
echo "scale=2; 10/3" | bc   # 3.33
```

## Arrays

```bash
arr=(a b c)
echo "${arr[0]}"         # a
echo "${arr[-1]}"        # c (last element)
echo "${#arr[@]}"        # length: 3
echo "${arr[@]}"         # all elements
echo "${!arr[@]}"        # all indices: 0 1 2

arr+=(d)                 # append
unset 'arr[1]'           # delete element

# Iterate
for item in "${arr[@]}"; do
  echo "$item"
done

# Associative array (bash 4+)
declare -A map
map[key]="value"
echo "${map[key]}"
```

## Control Flow

```bash
if [[ "$x" -gt 5 ]]; then
  foo
elif [[ "$x" -eq 0 ]]; then
  bar
else
  baz
fi

# String tests
[[ -z "$s" ]]   # empty
[[ -n "$s" ]]   # non-empty
[[ "$a" == "$b" ]]
[[ "$a" != "$b" ]]
[[ "$s" =~ ^[0-9]+$ ]]  # regex match

# File tests
[[ -f "$path" ]]   # is a regular file
[[ -d "$path" ]]   # is a directory
[[ -e "$path" ]]   # exists

case "$var" in
  foo)   echo "foo" ;;
  bar|baz) echo "bar or baz" ;;
  *)     echo "other" ;;
esac
```

## Loops

```bash
for i in 1 2 3; do echo "$i"; done
for i in {1..5}; do echo "$i"; done
for (( i=0; i<5; i++ )); do echo "$i"; done
for f in *.txt; do echo "$f"; done

while [[ "$x" -gt 0 ]]; do
  (( x-- ))
done

# Loop over lines
while IFS= read -r line; do
  echo "$line"
done < file.txt
```

## Functions

```bash
greet() {
  local name="$1"         # local variable
  local greeting="${2:-Hello}"
  echo "$greeting, $name!"
  return 0                # exit code (0=success)
}

greet "Alice"
greet "Bob" "Hi"

result=$(greet "Alice")   # capture output
```

## Input / Output

```bash
read -r line              # read stdin into $line
read -rp "Name: " name    # with prompt
read -ra arr              # read into array

echo "stdout"
echo "stderr" >&2

cmd > out.txt             # redirect stdout
cmd 2> err.txt            # redirect stderr
cmd &> all.txt            # redirect both
cmd >> out.txt            # append stdout
cmd1 | cmd2               # pipe
```

## Exit Codes

```bash
cmd && echo "success"     # run if cmd succeeded (exit 0)
cmd || echo "failed"      # run if cmd failed (exit non-0)

exit 0   # success
exit 1   # failure
echo $?  # exit code of last command
```

## Useful Patterns

```bash
# Script directory
dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Temp file (auto-cleaned)
tmp=$(mktemp)
trap 'rm -f "$tmp"' EXIT

# Check command exists
if ! command -v git &>/dev/null; then
  echo "git not found" >&2
  exit 1
fi

# Argument parsing
while [[ $# -gt 0 ]]; do
  case "$1" in
    -v|--verbose) verbose=1; shift ;;
    -o|--output)  output="$2"; shift 2 ;;
    *) echo "unknown: $1" >&2; exit 1 ;;
  esac
done
```
