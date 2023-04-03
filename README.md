# Encrypt Decrypt - Caesar Cipher Script 
Encodes or decodes input in the style of a caesar cipher. Can I/O directly from command line or from file, and translates text based on cipher mode and shift specified when called.


## Technologies

This program uses:
- Java 17

## Getting Started

This project runs directly from linux(or Unix-like) command line. Requires no installation beyond Java 17.

### Usage

Run the program with no options to run the program interactively, otherwise:

```
Usage: java Main [options]

Options:
-mode=(enc|dec)  Cipher direction [default: enc]
-key=NUMBER      Shift value [default: 0]
-data=TEXT       Text to translate(overwrites -in)
-in=FILE         Text to translate from file 

```

### Examples

Command line I/O:
```
$ java Main -mode enc -key 5 -data "Welcome to hyperskill!"
\jqhtrj%yt%m~ujwxpnqq&
```

## Features

- read text input from command line or from specified file path
- encrypt/decrypt text using user specified alphabet offset(cipher shift)
- output translated text to shell

