package org.example;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private String[] storage;
    private int size;

    public StringListImpl(int intSize) {
        storage = new String[intSize];
        size = 0;
    }

    public StringListImpl(String... args) {
        storage = new String[args.length];
        System.arraycopy(args, 0, storage, 0, args.length);
        size = storage.length;
    }

    @Override
    public String add(String item) {
        if (size == storage.length) {
            resize(size + 1);
        }
        storage[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {

        if (size == storage.length) {  // Проверяем если фиксовая длинна равна длине массива то
            resize(size+1);    //  вызываем метод resize который увеличивает размер массива в 2х раза, выделяя новую область памяти и копирую туда
        }                             // предыдущий заполенный массив Пример oldArray[1,2,3,4,5] newArray[1,2,3,4,5,null,null,null,null,null]
        for (int i = size; i > index; i--) {    // бежим по длинне массива до указанного индекса с конца, начинаем перезаписывать ячейки
            storage[i] = storage[i - 1];        // Пример oldArray[1,2,3,4,5,null] newArray[1,2,3,4,5,5]
        }
        storage[index] = item;                  // По индексу перезаписываем получившиеся массив newArray[1,2,3,4,6,5]
        size++;
        return item;
    }


    @Override
    public String set(int index, String item) {
        checkBox(index);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFindException();
        }
      return remove(index);
    }

    @Override
    public String remove(int index) {
        checkBox(index);
        String result = storage[index];
        for (int i = index; i < size ; i++) {
            storage[i - 1] = storage[i];
        }
        size--;
        return result;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkBox(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(otherList == null){
            throw  new ElementNotFindException();
        }
        if(size != otherList.size()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if(!Objects.equals(storage[i],otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(storage,0,size,null);
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[size];
        return Arrays.copyOf(storage, size);
    }

    private void resize(int newSize) {
    int reSize = size * 2;
    reSize = Math.max(reSize,newSize);
    String[] newData = new String[reSize];
    System.arraycopy(storage,0,newData,0,size);
    storage = newData;
    }

    public void checkBox(int index){
        if(index < 0 || index >= size){
            throw  new NullItemException();
        }
    }
}
