#------------------------------------------------------------------------------
# makefile for IntegerList ADT
#------------------------------------------------------------------------------

JAVASRC    = IntegerList.java IntegerListInterface.java IntegerListTest.java\
             ListFullException.java ListIndexOutOfBoundsException.java
MAINCLASS  = IntegerListTest
CLASSES    = IntegerList.class IntegerListInterface.class IntegerListTest.class\
             ListFullException.class ListIndexOutOfBoundsException.class
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

clean:
	rm -f $(CLASSES) $(JARFILE)


