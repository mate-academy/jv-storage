package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEM_NUMBER = 10;
    private Object[] keysRepository;
    private Object[] valuesRepository;
    private int count = 0;

    public StorageImpl() {
        keysRepository = new Object[MAX_ITEM_NUMBER];
        valuesRepository = new Object[MAX_ITEM_NUMBER];
    }

    @Override
    public void put(K key, V value) {
       if (size() == MAX_ITEM_NUMBER) {
           return;
       }

       for (int i = 0; i < size(); i++) {
           K currentKey = (K) keysRepository[i];

           if (key == currentKey || (key != null && key.equals(currentKey))) {
               valuesRepository[i] = value;
               return;
           }
       }

       int index = size();

       keysRepository[index] = key;
       valuesRepository[index] = value;

       count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size(); i++) {
            K currentKey = (K) keysRepository[i];

            if (key == currentKey || (key != null && key.equals(currentKey))) {
                V value = (V) valuesRepository[i];
                return value;
            }
        };

        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
