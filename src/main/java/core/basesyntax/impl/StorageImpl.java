package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K[] keyArray = (K[]) new Object[10];
    private V[] valueArray = (V[]) new Object[10];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        keyArray[count] = key;
        valueArray[count] = value;
        if (key != null) {
            for (int i = 0; i < count; i++) {
                if (keyArray[i] != null && keyArray[i].equals(keyArray[count])) {
                    keyArray[i] = key;
                    valueArray[i] = value;
                    valueArray[count] = null;
                    keyArray[count] = null;
                    count--;
                    break;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (keyArray[i] == keyArray[count]) {
                    keyArray[i] = key;
                    valueArray[i] = value;
                    valueArray[count] = null;
                    keyArray[count] = null;
                    count--;
                    break;
                }
            }
        }
        count++;
    }

    @Override
    public V get(K key) {
        int find = 0;
        if (key != null) {
            for (; find < size(); find++) {
                if (keyArray[find] != null && keyArray[find].equals(key)) {
                    break;
                }
            }
        } else {
            for (; find < size(); find++) {
                if (keyArray[find] == null) {
                    break;
                }
            }
        }
        return valueArray[find];
    }

    @Override
    public int size() {
        return this.count;
    }
}
