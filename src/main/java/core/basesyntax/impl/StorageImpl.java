package core.basesyntax.impl;

public class StorageImpl<K, V> implements core.basesyntax.Storage<K, V> {
    private static final int MAX_NUMBER = 10;
    private int size = 0;
    @SuppressWarnings("unchecked")
    private final K[] keyArray = (K[]) new Object[MAX_NUMBER];
    @SuppressWarnings("unchecked")
    private final V[] valueArray = (V[]) new Object[MAX_NUMBER];

    @Override
    public void put(K key, V value) {
        if (size == MAX_NUMBER) {
            throw new RuntimeException("The size of storage reached MAX_NUMBER.");
        }
        int keyCheck = checkKey(key);
        if (keyCheck == -1) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        } else {
            valueArray[keyCheck] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyCheck = checkKey(key);
        if (keyCheck == -1) {
            return null;
        }
        return valueArray[keyCheck];
    }

    @Override
    public int size() {
        return size;
    }

    public int checkKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((keyArray[i] == null) ? (key == null) : keyArray[i].equals(key)) {
                return i; // index of existed key in storage
            }
        }
        return -1; // if given key doesn't exist in storage
    }
}
