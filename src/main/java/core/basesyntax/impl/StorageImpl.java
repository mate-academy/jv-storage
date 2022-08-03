package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private Object[] keys = new Object[MAX_ITEMS_NUMBER];
    private Object[] values = new Object[MAX_ITEMS_NUMBER];
    private int amount = 0;

    @Override
    public void put(K key, V value) {
        if (amount == 0) {
            addKeyValue(key, value, 0);
            return;
        }
        for (int i = 0; i < amount; i++) {
            if (isEqualsKeys((K) keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (amount < MAX_ITEMS_NUMBER) {
            addKeyValue(key, value, amount);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_ITEMS_NUMBER; i++) {
            if (isEqualsKeys((K) keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return amount;
    }

    private boolean isEqualsKeys(K firstKey, K secondKey) {
        if (firstKey == null && secondKey == null) {
            return true;
        }
        if (firstKey != null && firstKey.equals(secondKey)) {
            return true;
        }
        return false;
    }

    private void addKeyValue(K key, V value, int index) {
        keys[index] = (Object) key;
        values[index] = (Object) value;
        amount += 1;
    }
}
