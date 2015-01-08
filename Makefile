JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
	
CLASSES = \
	DisjointSet.java \
	Edge.java \
	Graph.java \
	randmst.java
default: classes
classes: $(CLASSES:.java=.class)
clean:
	$(RM) *.class