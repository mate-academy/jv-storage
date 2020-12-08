package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int STORAGE_CAPACITY = 10;
    private static int ELEMENT_SIZE = 2;
    private static int KEY = 0;
    private static int VALUE = 1;
    private Object[][] array = new Object[STORAGE_CAPACITY][ELEMENT_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if (array[i][VALUE] == null) {
                array[i][KEY] = key;
                array[i][VALUE] = value;
                break;
            } else if (Objects.equals(array[i][KEY], key)) {
                array[i][VALUE] = value;
                break;
            }

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_CAPACITY; i++) {
            if (Objects.equals(array[i][KEY], key)) {
                return (V) array[i][VALUE];
            }
        }
        return null;
    }
}
