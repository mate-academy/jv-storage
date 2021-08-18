package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private final Object[][] array = new Object[10][2];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;
        if (check(this.key, this.value)) {
            addNew(this.key, this.value);
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (Object[] objects : array) {
                if (objects[0] == null && objects[1] != null) {
                    return (V) objects[1];
                }
            }
        } else {
            for (Object[] objects : array) {
                if (objects[0] != null) {
                    if (objects[0].equals(key)) {
                        return (V) objects[1];
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void addNew(K key, V value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == null && array[i][1] == null ) {
                array[i][0] = key;
                array[i][1] = value;
                this.size++;
                break;
            }
        }
    }

    private boolean check(K key, V value) {
        if (key == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i][0] == null && array[i][1] != null ){
                    array[i][1] = value;
                    return false;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i][0] != null && array[i][1] != null) {
                    if (array[i][0].equals(key)) {
                        array[i][1] = value;
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
