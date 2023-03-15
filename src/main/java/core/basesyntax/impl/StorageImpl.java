package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private int size;
    private K[] arrayKey;
    private V[] arrayValue;

    public StorageImpl() {
        arrayKey = (K[]) new Object[MAX_SIZE];
        arrayValue = (V[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < arrayKey.length; i++) {
            if (key == arrayKey[i] || key != null && key.equals(arrayKey[i])) {
               if (key == null && arrayKey[i] == null && arrayValue[i] == null) {
                size++;
               }
               arrayValue[i] = value;
               break;
            }
           if (arrayKey[i] == null && arrayValue[i] == null) {
               arrayKey[i] = key;
               arrayValue[i] = value;
               size++;
               break;
           }
      }
    }

    @Override
    public V get(K key) {
       for (int i = 0; i < arrayKey.length; i++) {
           if (key == arrayKey[i] || key != null && key.equals(arrayKey[i])) {
               return arrayValue[i];
           }
       }
       return null;
    }

    @Override
    public int size() {
       if (size > MAX_SIZE) {
           return MAX_SIZE;
       }
       return size;
    }
}
