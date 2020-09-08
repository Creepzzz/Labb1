/* Author: Matilda Qvick 001105-0606
   Generated: 26/8 - 2020
   Last updated: 8/9 - 2020
   Solves: Pushes characters from standard input to the stack and pops
           and prints them in reverse order. The class uses an interactive
           method for printing the characters. Class uses the CharStack.
   How to use: Put any chars into input, including space, when
               pressing enter, the chars are printed out in
               reverse order.
 */
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
