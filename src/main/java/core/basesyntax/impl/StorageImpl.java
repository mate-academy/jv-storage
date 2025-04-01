package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys = (K[]) new Object[10];
    private V[] values = (V[]) new Object[10];

    private int sizer = 0;
    private int count = 0;

    @Override
    public void put(K key, V value) {

        for (int j = 0; j < count; j++) {

            if (Objects.equals(key, keys[j]) && values[j] != null) {
                values[j] = value;
                sizer--;
                break;
            }
        }

        keys[count] = key;
        values[count] = value;
        count++;
        sizer++;
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(key, keys[i])) {
                result = values[i];

                if (key == null) {
                    result = values[i];
                    break;
                }

            }
        }
        return result;
    }

    @Override
    public int size() {
        return sizer;
    }
}


