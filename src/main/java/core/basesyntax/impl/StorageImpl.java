package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) (new Object[10]);
        values = (V[]) (new Object[10]);
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            int index = getIndexWithNullKey();
            if (index != -1) {
                values[index] = value;
                return;
            }
        }
        int index = getIndexByKey(key);
        if (index != -1) {
            keys[index] = key;
            values[index] = value;
            return;
        }
        if (size() == 10) {
            System.out.println("storage overloaded");
            return;
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            int index = getIndexWithNullKey();
            if (index != -1) {
                return values[index];
            }
            return null;
        }
        int index = getIndexByKey(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        int index = getIndexWithNullKey();
        if (index != -1) {
            count++;
        }
        for (K key : keys) {
            if (key != null) {
                count++;
            }
        }
        return count;
    }

    private int getIndexWithNullKey() {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] != null) {
                return i;
            }
        }
        return -1;
    }

    private int getIndexByKey(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }
}
