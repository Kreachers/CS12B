# ---------------------------
# Makefile
# 12M lab1
# 3/29/16
# ---------------------------

JAVASRC = HelloUser.java HelloUser2.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = HelloUser2
CLASSES = HelloUser.class HelloUser2.class
JARFILE = Hello
SUBMIT = submit cmps012b-pt.s16 lab1
all: $(JARFILE)
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
  ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/lab1/bsherrif
