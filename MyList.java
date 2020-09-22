import java.util.Arrays;
import java.util.Objects;

public class MyList<E>  {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    private void ensureCapacity(int min) {
        elements = Arrays.copyOf(elements, min);
    }
    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
        return true;
    }

    public void add(int index, E element){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }else {
            if (size == elements.length){
                ensureCapa();
            }
            for (int i = size-1; i >= index; i-- ){
                elements[i+1] = elements[i];
            }
            elements[index] = element;
            size++;
        }
    }

    public E remove(int index){
        E e = (E) elements[index];
        if (index >= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }else {
            for (int i = index; i < size-1; i++ ){
                elements[i] = elements[i++];
            }
        }
        size--;
        return e;
    }

    public int size(){
        return size;
    }

    public Object[] clone(){
        Object elementsClone[] = new Object[elements.length];
        return elementsClone;
    }

    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    public boolean contains(Object o){
        for (int i = 0; i < size;i++){
            if (Objects.equals(o, elements[i])){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }

    public void clear(){
        elements = new Object[elements.length];
    }

}