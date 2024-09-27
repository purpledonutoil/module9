import java.util.Arrays;

public class MyArrayList {
    private Object[] array;

    public MyArrayList() {
        array = new Object[0];
    }

    public void add(Object value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length-1] = value;
    }

    public void remove(int index) {
        for (; index < array.length-1; index++) {
            array[index] = array[index+1];
        }
        array = Arrays.copyOf(array, array.length-1);
    }

    public void clear() {
        array = new Object[0];
    }

    public int size(){
        return array.length;
    }

    public Object get(int index) {
        return array[index];
    }
}