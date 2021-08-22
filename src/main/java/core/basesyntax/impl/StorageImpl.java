package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keysArray;
    private V[] valuesArray;
    private int sizeOfArray;

    public StorageImpl() {
        keysArray = (K[])(new Object[MAX_ITEMS_NUMBER]);
        valuesArray = (V[])(new Object[MAX_ITEMS_NUMBER]);
        sizeOfArray = 0;
    }

    @Override
    public void put(K key, V value) {
        if (sizeOfArray < MAX_ITEMS_NUMBER) {
            for (int i = 0; i < sizeOfArray; i++) {
                if (Objects.equals(key, keysArray[i])) {
                    valuesArray[i] = value;
                    return;
                }
            }
            keysArray[sizeOfArray] = key;
            valuesArray[sizeOfArray] = value;
            sizeOfArray++;
        } else {
            System.out.println("Your storage is full!");
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < sizeOfArray; i++) {
            if (Objects.equals(key, keysArray[i])) {
                result = valuesArray[i];
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return sizeOfArray;
    }
}
