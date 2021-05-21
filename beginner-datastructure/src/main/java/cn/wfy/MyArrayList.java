package cn.wfy;


import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class MyArrayList<T>  {


    Object[] elementData;

    Object[] growElementData;

    private int default_capacity = 10;

    private int size;

    public MyArrayList() {
        elementData = new Object[default_capacity];
        this.size = 0;
    }

    public MyArrayList(int initalCapacity) {
        elementData = new Object[initalCapacity];
        this.size = 0;

    }

    public void add(T t) {
        if (elementData.length <= size) {
            grow();
        }
        elementData[size++] = t;
    }

    private void grow() {
        growElementData = new Object[elementData.length << 1];
        for (int i = 0; i < elementData.length; i++) {
            growElementData[i] = elementData[i];
        }
        elementData = new Object[size << 1];
        elementData = growElementData;
    }

    public T get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elementData[index];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public T remove(int index) {
        for (int i = index; i < size; i++) {
            elementData[index] = elementData[index + 1];
        }
        return (T) elementData;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elementData[i]);
            if (i != size - 1) {

                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
