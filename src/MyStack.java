import java.util.Arrays;

public class MyStack {
    Object[] elements = new Object[0];

    public void push(Object value){
        elements = Arrays.copyOf(elements, elements.length+1);
        elements[elements.length-1] = value;
    }

    public void remove(int index){
        for (; index+1 < elements.length; index++) {
            elements[index] = elements[index+1];
        }
        elements = Arrays.copyOf(elements, elements.length-1);
    }

    public void clear(){
        elements = new Object[0];
    }

    public int size(){
        return elements.length;
    }

    public Object peek(){
        return elements[0];
    }

    public Object pop(){
        Object temp = elements[0];
        System.arraycopy(elements, 1, elements, 0, elements.length - 1);
        return temp;
    }
}