JFLAGS = -g
JC = javac
SRCDIR = .
BINDIR = ./bin
JAVA_SOURCES = $(shell find $(SRCDIR) -name "*.java")
JAVA_CLASSES = $(patsubst $(SRCDIR)/%.java, $(BINDIR)/%.class, $(JAVA_SOURCES))

all: compile

compile: $(BINDIR) $(JAVA_CLASSES)

$(BINDIR):
	mkdir -p $(BINDIR)

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JC) $(JFLAGS) -d $(BINDIR) $<

compile:
	jar cfe Juego.jar Main -C $(BINDIR) .

run: compile
	java -jar Juego.jar

clean:
	$(RM) -r $(BINDIR)
	$(RM) -f Juego.jar

.PHONY: all compile run clean
