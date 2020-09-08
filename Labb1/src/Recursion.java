/* Author: Matilda Qvick 001105-0606
   Generated: 26/8 - 2020
   Last updated: 8/9 - 2020
   Solves: Pushes characters from standard input to the stack and
           then pops and prints them out in reverse order using a
           recursive function. Class uses the CharStack.
   How to use: Put any chars into input, including space, when
               pressing enter, the chars are printed out in
               reverse order.
 */

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
