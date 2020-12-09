package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_LENGTH = 10;
    private Object[] keys = new Object[ARRAY_LENGTH];
    private Object[] values = new Object[ARRAY_LENGTH];
    private int index = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i <= index; i++) {
            if (keys[i] == null && values[i] != null) {
                continue;
            }
            if ((keys[i] == null && values[i] == null)
                    || (keys[i].equals(key) && values[i] != null)) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i <= index; i++) {

            if (keys[i] == null
                    && key == null
                    && values[i] != null
                    || keys[i] == key || Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }
}
