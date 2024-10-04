package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] storageKeys;
    private V[] storageValues;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        storageKeys = (K[]) new Object[MAX_SIZE];
        storageValues = (V[]) new Object[MAX_SIZE];
        currentSize = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentSize; i++) {
            if ((storageKeys[i] == null && key == null)
                    || (storageKeys[i] != null && storageKeys[i].equals(key))) {
                storageValues[i] = value;
                return;
            }
        }
        if (currentSize < MAX_SIZE) {
            storageKeys[currentSize] = key;
            storageValues[currentSize] = value;
            currentSize++;
        } else {
            throw new IllegalStateException("Storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentSize; i++) {
            if ((storageKeys[i] == null && key == null)
                    || (storageKeys[i] != null && storageKeys[i].equals(key))) {
                return storageValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
