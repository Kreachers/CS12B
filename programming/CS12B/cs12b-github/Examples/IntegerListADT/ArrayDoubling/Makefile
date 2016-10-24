#------------------------------------------------------------------------------
# makefile for IntegerList ADT
#------------------------------------------------------------------------------

JAVASRC    = IntegerList.java IntegerListInterface.java IntegerListTest.java\
             ListIndexOutOfBoundsException.java
MAINCLASS  = IntegerListTest
CLASSES    = IntegerList.class IntegerListInterface.class IntegerListTest.class\
             ListIndexOutOfBoundsException.class
JARFILE    = IntegerListTest
JARCLASSES = $(CLASSES)

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(JAVASRC)
	javac $(JAVASRC)  
# Note: no -Xlint option

clean:
	rm -f $(CLASSES) $(JARFILE)

