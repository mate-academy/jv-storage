package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_SIZE = 10;
    private K[] keyArray = (K[]) new Object[MAX_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_SIZE];
    @Override
    public void put(K key, V value) {
      for (int i = 0; i < valueArray.length; i++) {
          keyArray[i] = key;
          valueArray[i] = value;
      }
    }

    @Override
    public V get(K key) {
      for (int i = 0; i < 10; i++) {
        if (keyArray[i] != null && keyArray[i].equals(key)) {
            return valueArray[i];
        }
      }
        return null;
    }

    @Override
    public int size() {
        return -1;
    }


}
