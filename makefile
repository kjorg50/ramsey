# see http://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html for more info

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        AdjMatrixGraph.java \
	Chromosome.java \
        ColorMatrix.java \
        Genetics.java \
	Node.java \
	Population.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
