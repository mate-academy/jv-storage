package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 5;

    private static final int SOLUTION_WAY = 0;

    private Pair<K,V>[] pair = new Pair[MAX_ELEMENTS_NUMBER];

    private K[] key1 = (K[]) new Object[MAX_ELEMENTS_NUMBER];
    private V[] value1 = (V[]) new Object[MAX_ELEMENTS_NUMBER];

    @Override
    public void put(K key, V value) {
        switch (SOLUTION_WAY) {
            case 0:
                for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
                    if (value1[i] != null) {
                        if (key1[i] == null && key == null) {
                            value1[i] = value;
                            return;
                        } else if (key1[i] != null && key1[i].equals(key)) {
                            value1[i] = value;
                            return;
                        }
                    }
                }
                for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
                    if (value1[i] == null) {
                        key1[i] = key;
                        value1[i] = value;
                        return;
                    }
                }
                break;
            case 1:
            default:
                for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
                    if (pair[i] == null) {
                        pair[i] = new Pair<K,V>(key, value);
                        return;
                    }

                    if (pair[i].getValue() != null
                            && key == null
                            && pair[i].getKey() == null) {
                        pair[i] = new Pair<K,V>(key, value);
                        return;
                    } else if (key != null
                            && pair[i].getKey() != null
                            && pair[i].getKey().equals(key)) {
                        pair[i] = new Pair<K,V>(key, value);
                        return;
                    }
                }
                break;
        }

    }

    @Override
    public V get(K key) {
        V foundValue = null;
        switch (SOLUTION_WAY) {
            case 0:
                for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
                    if (key == null) {
                        if (value1[i] != null && key1[i] == null) {
                            foundValue = value1[i];
                            break;
                        } else if (i == MAX_ELEMENTS_NUMBER - 1) {
                            //not found logic
                        }
                    } else {
                        if (key1[i] != null && key.equals(key1[i])) {
                            foundValue = value1[i];
                            break;
                        } else if (i == MAX_ELEMENTS_NUMBER - 1) {
                            //not found logic
                        }
                    }
                }
                break;
            case 1:
            default:
                for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
                    if (pair[i] == null) {
                        return null; //or not found logic
                    }
                    if (key == null && pair[i].getKey() == null && pair[i].getValue() != null) {
                        return pair[i].getValue();
                    } else if (key != null
                            && pair[i].getKey() != null
                            && key.equals(pair[i].getKey())) {
                        return pair[i].getValue();
                    }
                }
                break;
        }
        return foundValue;
    }

    @Override
    public int size() {
        int sizeOfStorage = 0;
        switch (SOLUTION_WAY) {
            case 0:
                for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
                    if (key1[i] != null || value1[i] != null) {
                        sizeOfStorage++;
                    }
                }
                break;
            case 1:
            default:
                while (pair[sizeOfStorage] != null) {
                    sizeOfStorage++;
                }
                break;
        }
        return sizeOfStorage;
    }
}
