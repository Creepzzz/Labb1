import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Recursion {
    public static void main (String[] args) {
        readRecursive();
    }

    /**
     * The method uses recursion to flip the order of characters
     * from stdin by pushing and popping the execution stack.
     */
    public static void readRecursive(){
        CharStack<Character> characterStack = new CharStack<Character>();
        char a = StdIn.readChar();
        if(a !='\n'){
            characterStack.push(a);
            readRecursive();
        }
        StdOut.print(a);
    }
}
