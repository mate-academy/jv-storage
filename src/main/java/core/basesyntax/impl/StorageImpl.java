package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_NUMBER = 10;
    private String[] valueArray = new String[MAX_ELEMENTS_NUMBER];
    private V value;
    private K key;
    private int objectCounter = 0;

    @Override
    public void put(K key, V value) {
        if (key != null && value != null) {
            for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
                if (valueArray[i] != null
                        && valueArray[i].substring(0, valueArray[i].indexOf(',')).equals(key)) {
                    valueArray[i] = key.toString() + "," + value.toString();
                    objectCounter--;
                    break;
                }
            }
            objectCounter++;
            for (int i = 0; i < MAX_ELEMENTS_NUMBER; i++) {
                if (valueArray[i] == null) {
                    valueArray[i] = key.toString() + "," + value.toString();
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if (key != null && value != null) {
            return null;
        }
        for (String element : valueArray) {
            if (element != null
                    && element.substring(0,element.indexOf(',')).equals(key.toString())) {
                return (V) element.substring(element.indexOf(',') + 1);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return objectCounter;
    }
}
