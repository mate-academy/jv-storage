package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int DEFAULT_SIZE = 10;
    private final K[] keysArray;
    private final V[] valuesArray;
    private int size = 0;

    public StorageImpl() {
        // Unchecked cast warning !
        keysArray = (K[]) new Object[DEFAULT_SIZE];
        valuesArray = (V[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findElement(keysArray, key);
        if (index != -1) {
            valuesArray[index] = value;
        } else {
            addElem(keysArray, key);
            addElem(valuesArray, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findElement(keysArray, key);
        return (index != -1) ? valuesArray[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    // Using new generic, because function must work independently in class with its own generic
    private <T> int findElement(T[] array, T elementToSearch) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elementToSearch, array[i])) {
                return index; // Element found in the array
            }
            index++;
        }
        return -1; // Element not found in the array
    }

    public <T> void addElem(T[] arr, T element) {
        arr[size] = element;
    }
}
