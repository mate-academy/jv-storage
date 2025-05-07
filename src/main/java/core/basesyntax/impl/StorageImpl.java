package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int DONT_HAVE_INDEX = -1;
    private static final int ACCURACY_OF_ONE = 1;
    private static final int GROWTH_FACTOR = 1;
    private static final int INITIAL_POSITION = 0;
    private K[] keys;
    private V[] values;
    private int usedSpace;

    public StorageImpl() {
        keys = (K[])new Object[MAX_ITEMS_NUMBER];
        values = (V[])new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != DONT_HAVE_INDEX) {
            values[index] = value;
            return;
        }
        keys[usedSpace] = key;
        values[usedSpace] = value;
        usedSpace++;
        growIfArrayFull();
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index == DONT_HAVE_INDEX ? null : values[index];
    }

    @Override
    public int size() {
        return usedSpace;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < usedSpace; i++) {
            if (key == keys[i] || (keys[i] != null && keys[i].equals(key))) {
                return i;
            }
        }
        return DONT_HAVE_INDEX;
    }

    private void growIfArrayFull() {
        if (usedSpace == values.length - ACCURACY_OF_ONE) {
            int oldCapacity = values.length;
            int newCapacity = oldCapacity + (oldCapacity >> GROWTH_FACTOR);
            Object[] tempValues = new Object[newCapacity];
            Object[] tempKeys = new Object[newCapacity];
            System.arraycopy(values, INITIAL_POSITION, tempValues, INITIAL_POSITION, usedSpace);
            System.arraycopy(keys, INITIAL_POSITION, tempKeys, INITIAL_POSITION, usedSpace);
            values = (V[])new Object[newCapacity];
            values = (V[]) tempValues;
            keys = (K[])new Object[newCapacity];
            keys = (K[]) tempKeys;
        }
    }
}
