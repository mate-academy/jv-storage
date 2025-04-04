package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int storageMaxSize = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public int getSize() {
        return size;
    }

    public StorageImpl() {
        this.keys = new Object[storageMaxSize];
        this.values = new Object[storageMaxSize];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int k = 0; k <= size; k++) {
            if(keys[k] == null && values[k] == null){
                keys[k] = key;
                values[k] = value;
                size++;
                return;
            } else if((keys[k] != null && keys[k].equals(key))
                    || (keys[k] == null && key == null)) {
                values[k] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
       for (int k = 0; k < storageMaxSize; k++) {
           if((keys[k] != null) && (keys[k].equals(key))) {
               return (V) values[k];
           } else if(keys[k] == null && key == null) {
               return (V) values[k];
           }
       }
       return null;
    }

    @Override
    public int size() {
        return getSize();
    }
}
