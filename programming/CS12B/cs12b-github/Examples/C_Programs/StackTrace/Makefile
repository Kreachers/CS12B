#------------------------------------------------------------------------------
# Makefile for QueueTest.c with macros
#------------------------------------------------------------------------------

EXEBIN   =  StackTrace
SOURCES  =  $(EXEBIN).c
OBJECTS  =  $(EXEBIN).o
FLAGS    =  -std=c99 -Wall

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)
