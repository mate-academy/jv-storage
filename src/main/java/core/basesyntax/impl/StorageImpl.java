package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[MAX_SIZE];
        values = new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key) || keys[i] == key) {
                values[i] = value;
                return;
            }
            /*Шукає вільний слот для значення коли ключ не збігається з жодним іншим,
            перевіряємо values[i]
            перевіряємо values[i], тому що може бути значення з ключем null*/
            if (values[i] == null) {
                values[i] = value;
                keys[i] = key;
                return;
            }

        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return (V) values[i];
            }
            if (keys[i] == key) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                size++;
            }
        }
        return size;
    }

}
