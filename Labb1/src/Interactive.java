import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Interactive {
    public static void main (String[] args){
           readInteractive();
    }

    /**
     * Method uses iteration to create a flipped version of a number
     * of characters from Stdin. ADT Stack is used.
     */
    public static void readInteractive(){
        CharStack<Character> characterStack = new CharStack<Character>();
        char a = StdIn.readChar();

        while(a != '\n'){
            characterStack.push(a);
            a = StdIn.readChar();
        }

        while(!characterStack.isEmpty()){
            a = characterStack.pop();
            StdOut.print(a);
        }
    }
}
