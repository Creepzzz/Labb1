import edu.princeton.cs.algs4.StdOut;

public class CharStack<T> {

    private static final int CAPACITY = 10;
    private T[] stack;
    private int stackSize;
    private int capacity;

    /**
     * Constructor of charstack with fixed capacity
     */
    public CharStack(){
        capacity = CAPACITY;
        stack = (T[]) new Object[capacity];
    }

    /**
     *
     * @return true if stack is empty
     */
    public boolean isEmpty(){
        if(stackSize == 0){
            return true;
        }
        else return false;
    }

    /**
     *
     * @return size of the stack
     */
    public int size(){
        return this.stackSize;
    }

    /**
     * Pushes element to the top of the stack
     * If the new size of the stack is bigger than half of the
     * original stack the stack is resized to twice the size
     * @param element that is to be pushed to the stack
     */
    public void push (T element){
        stack[stackSize++] = element;
        if(stackSize > stack.length/2){
            resizeStack(stack.length*2);
        }
    }

    /**
     * Pops an element at the top of the stack and dereferences the pointer to that element
     * If the new size is smaller than the original divided with 4 the stack is
     * resized to half the size.
     * @return element that was popped
     */
    public T pop(){
        if(isEmpty()){
            return null;
        }
        T element = stack[--stackSize];
        stack[stackSize] = null;
        if(stackSize < stack.length/4){
            resizeStack(stack.length/2);
        }
        return element;
    }

    /**
     * Copies the stack to a stack with the new size
     * @param newSize is size of the new stack
     */
    private void resizeStack(int newSize){
        T[] newStack = (T[]) new Object[newSize];
        //Copies elements from source to destination from position 0 with the size of stack
        System.arraycopy(stack, 0, newStack, 0, stackSize);
        stack = newStack;
    }

    /**
     * Builds a string representation of the stack
     * @return the string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size()-1; i++){
            String stackString = stack[i].toString();
            sb.append('\'');
            sb.append(stackString);
            sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Main works as a test function (needs more)
     */
    public static void main (String[] args){
        CharStack<Character> testStack = new CharStack<Character>();
        StdOut.println("Expected size: 0 \nActual size: " + testStack.size());
        testStack.push('1');
        StdOut.println("Expected size: 1 \nActual size: " + testStack.size());
        char testPop = testStack.pop();
        StdOut.println("Expected size: 0 \nActual size: " + testStack.size());
        StdOut.println("Expected element: 1 \nActual element: " + testPop);

    }
}
