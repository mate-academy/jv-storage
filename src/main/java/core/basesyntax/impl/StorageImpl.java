package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int ARRAY_MAX_LENGTH = 20;
    private Object[] keys = new Object[ARRAY_MAX_LENGTH];
    private Object[] values = new Object[ARRAY_MAX_LENGTH];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        if (this.contain(key) == -1) {
            keys[count] = key;
            values[count] = value;
            count++;
        } else {
            values[contain(key)] = value;
        }
    }

    @Override
    public V get(K key) {

        return this.contain(key) == -1 ? null : (V) values[this.contain(key)];
    }

    private int contain(K key) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(keys[i], key)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl<>();
        storage.put(0, "0");
        storage.put(123, "123");
        storage.put(null, "null");
        System.out.println(storage.get(null));
    }
}
