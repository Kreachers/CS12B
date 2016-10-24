# -----------------------------------------------------
# Makefile
# 12b pa1
# 4/5/16
# A makefile with macros, compiles Recursion class
# ------------------------------------------------------

JAVASRC = Recursion.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = Recursion
CLASSES = Recursion.class
JARFILE = Recursion
SUBMIT = submit cmps012b-pt.s16 pa1
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/pa1/
all: $(JARFILE)
$(JARFILE): $(CLASSES)
  echo Main-class: $(MAINCLASS) > Manifest
  jar cvfm $(JARFILE) Manifest $(CLASSES)
  rm Manifest
  chmod +x $(JARFILE)
$(CLASSES): $(JAVASRC)
  javac -Xlint $(JAVASRC)
clean:
  rm $(CLASSES) $(JARFILE)
submit: $(SOURCES)
  $(SUBMIT) $(SOURCES)
check:
  $(CHECK)
