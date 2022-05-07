package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private int count = 0;
    private K[] keyBox = (K[]) new Object[SIZE];
    private V[] keyValue = (V[]) new Object[SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyBox.length; i++) {
            if (keyValue[i] == null) {
                keyBox[i] = key;
                keyValue[i] = value;
                break;
            }
            if (keyValue[i] != null && key == (K) keyBox[i]) {
                keyValue[i] = value;
                break;
            }
            if (key != null && key.equals((K) (keyBox[i]))) {
                keyValue[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (int i = 0; i < keyBox.length; i++) {
            if (key != null && key.equals((K) keyBox[i])) {
                result = keyValue[i];
                break;
            }
            if (key == (K) keyBox[i]) {
                result = keyValue[i];
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        for (int i = 0; i < keyBox.length; i++) {
            if (keyValue[i] != null) {
                count++;
            }
        }
        return count;
    }
}
