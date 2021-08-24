#!/bin/bash

rm ./*.class ./*.interp

export CLASSPATH=".:./antlr-4.8-complete.jar:$CLASSPATH"
alias antlr4='java -Xmx500M org.antlr.v4.Tool'
alias grun='java org.antlr.v4.runtime.misc.TestRig'

# FIXME: Get alias to work
# antlr4 LoopNest.g4
java -Xmx500M org.antlr.v4.Tool LoopNest.g4

javac LoopNest*.java

# Use this to visualize the parse tree and learn the rules you should implement
# grun LoopNest tests -gui < TestCase.java

javac Driver.java
java Driver "$1"
