JFLAGS =
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Piquet.java \
		Game.java	\
		Deck.java	\
		Card.java	\
		Table.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class
