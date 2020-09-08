//Code for part 1 on lab 1
//Code written by Matilda Qvick 001105-0606
//Started 2020-08-26, Last updated 2020-08-31
//This code contains methods that flippes the order of characters from stdin.
//One method uses recursion, the other iteration.
//Use it by putting any characters into standard input followed by an enter key. 
#include<stdio.h>

static void test() {

}

/*
Method gets chars and put them on the stack. For as long as newline isnt pressed
the method calls itself. If newline is pressed, the chars are drawn from the stack.
Since a stack works accorning to FILO, the characters will be put out in reverese.
The function getchar() puts characters on the stack while putchar() pops them.
This is a non-tail recursive function.
*/
void recursive_reverse(void){
    char c;
    if ((c = getchar()) != '\n') { 
        recursive_reverse(); 
    }
    putchar(c);
}

/*
Method uses getchar to fetch char as long as newline isn't pressed. The chars are put into a 
list with increasing index. Then a for-loop is used to put out the chars from the list in reverse order.
For this method, a fixed size list is used in order to reverse the order of the characters. 
*/
void interactive_reverse(void) {
    char c;
    char r[10];
    int count = 0;

    while ((c = getchar()) != '\n') {
        r[count] = c;
        count++;
    }

    for (int i = count - 1; i >= 0; i--) {
        putchar(r[i]);
    }
   
}

int main(void){
    interactive_reverse();
    recursive_reverse();

}

/*
Questions:
1. It is easier to implement the recursive function since the getchar() function could be 
   called several times without using a "copy-array". This is due to the recursive function using 
   the activision record. Pushing and popping the entire activation record takes allows the function
   to "move backwards", using the dynampic link which holds the activation record of the previous state. 
   This allows us to reverse the order without creating an additional array for copying which of course, 
   saves memory. 
*/