package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys;
    private Object[] values;

    public StorageImpl() {
        keys = new Object[]{};
        values = new Object[]{};
    }

    @Override
    public void put(K key, V value) {
        int index = getKeyIndex(key);
        if (index == -1) {
            int lastElement;
            keys = incrementArrayLength(keys);
            lastElement = keys.length - 1;
            keys[lastElement] = key;
    
            values = incrementArrayLength(values);
            lastElement = values.length - 1;
            values[lastElement] = value;
        } else {
            values[index] = value;
        }   
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        return (index == -1) ? null : (V)values[index];
    }

    @Override
    public int size() {
        return keys.length;
    }

    private Object[] incrementArrayLength(Object[] array) {
        final int requiredLength = array.length + 1;
        Object[] changedArray = new Object[requiredLength];
        for (int i = 0; i < array.length; i++) {
            changedArray[i] = array[i];
        }
        return changedArray;
    }  

    private int getKeyIndex(Object key) {
        for (int i = 0; i < this.keys.length; i++) {
            if ((this.keys[i] == null && key == null) || (this.keys[i] != null 
                    && this.keys[i].equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
