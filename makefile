default: Sequences.java
	javac Sequences.java

run: Sequences.java
	java Sequences

clean:
	rm -f *.class