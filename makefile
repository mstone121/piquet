JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Piquet.java \
		Game.java	\
		Deck.java	\
		Card.java	\
		Table.java	\
		Player.java \
		Human.java	\
		Robot.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class
