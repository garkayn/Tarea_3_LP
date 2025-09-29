JFLAGS = -g
JC = javac

SRCDIR = .

JAVA_SOURCES = $(shell find $(SRCDIR) -name "*.java")
JAVA_CLASSES = $(patsubst %.java,%.class,$(JAVA_SOURCES))

all: compile

compile: $(JAVA_CLASSES)

%.class: %.java
	$(JC) $(JFLAGS) -d $(SRCDIR) $<

run: compile
	jar cfe Juego.jar Main *.class player entorno objetos

clean:
	$(RM) $(shell find $(SRCDIR) -name "*.class")
	rm -f Juego.jar

.PHONY: all compile run clean

