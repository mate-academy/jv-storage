package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keysArray;
    private V[] valuesArray;
    private V valueIfKeyIsNull = null;

    public StorageImpl() {
        // Unchecked cast warning !
        keysArray = (K[]) new Object[0];
        valuesArray = (V[]) new Object[0];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            valueIfKeyIsNull = value;
            return;
        }
        int index = findElement(keysArray, key);
        if (index != -1) {
            valuesArray[index] = value;
        } else {
            keysArray = addElem(keysArray, key);
            valuesArray = addElem(valuesArray, value);
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return valueIfKeyIsNull;
        }
        int index = findElement(keysArray, key);
        return (index != -1) ? valuesArray[index] : null;
    }

    @Override
    public int size() {
        int size;
        if (keysArray.length == valuesArray.length) {
            size = keysArray.length;
        } else {
            throw new RuntimeException("Size dont match");
        }

        // We save value for null key in other cell, not to break array structure
        // If cell is not empty (not null), so we have additional value in our array technically
        // So we should increment size
        if (valueIfKeyIsNull != null) {
            size++;
        }
        return size;
    }

    // Using new generic, because function must work independently in class with its own generic
    private <T> int findElement(T[] array, T element) {
        int index = 0;
        for (T item : array) {
            if (item != null && item.equals(element)) {
                return index; // Element found in the array
            }
            index++;
        }
        return -1; // Element not found in the array
    }

    public <T> T[] addElem(T[] arr, T element) {
        T[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = element;
        return newArr;
    }
}
