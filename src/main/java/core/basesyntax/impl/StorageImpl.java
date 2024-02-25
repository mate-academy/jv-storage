package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int size = 0;
    private Pair<K, V>[] MAP = new Pair[10];

    public void put(K key, V value) {
        if (key == null && value != null) {
            for (int i = 0; i < size; i++) {
                if (MAP[i].getKey() == null && MAP[i].getValue() != null) {
                    MAP[i].setValue(value);
                    System.out.println(MAP[size] + " return");
                    return;
                }
            }
            MAP[size++] = new Pair<>(key, value);
            System.out.println(MAP[size] + " key == null");
            return;
        }
        Pair<K, V> tempPair = findValue(key);
        if (tempPair == null) {
            MAP[size++] = new Pair<>(key, value);
            System.out.println(MAP[size] + " pair == null");
        }
        else {
            tempPair.setValue(value);
            System.out.println(key + " -key | value -" + value + " else");
        }
    }

    private Pair<K, V> findValue(K key) {
        for (int i = 0; i < size; i++) {
            if (MAP[i].getKey() != null && MAP[i].getKey().equals(key) && MAP[i].getValue() != null) {
                return MAP[i];
            }
            if(MAP[i].getKey() == null) {
                return MAP[i];
            }
        }
        return null;
    }

    @Override
    public V get(K key) {
        return findValue(key).getValue();
    }

    @Override
    public int size() {
        return size;
    }
}
