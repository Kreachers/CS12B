# Bradley Bernard, bmbernar@ucsc.edu
# CS 101: PA1

#------------------------------------------------------------------------------
#
#  Makefile for CMPS 101 pa1 
#  Compiles all .java files in the current directory and creates an executable
#  jar file called Lex.  See the following for a short description of makefiles
#
#       https://classes.soe.ucsc.edu/cmps012b/Summer15/lab1.pdf
#
#------------------------------------------------------------------------------ 

MAINCLASS  = Lex
JAVAC      = javac 
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) Makefile README
CLASSES    = $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES = $(patsubst %.class, %*.class, $(CLASSES))
JARFILE    = $(MAINCLASS) 

all: $(JARFILE)
	
$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	- checksource $<
	- cid + $<
	$(JAVAC) $<

ci : $(SOURCES)
	- checksource $(SOURCES)
	cid + $(SOURCES)

submit : $(SOURCES)
	submit cmps101-pt.u15 pa1 $(SOURCES)

clean:
	rm -f *.class $(JARFILE)

