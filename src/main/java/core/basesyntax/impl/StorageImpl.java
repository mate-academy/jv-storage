package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int currentLength;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_LENGTH];
        values = (V[]) new Object[MAX_LENGTH];
        currentLength = 0;
    }

    @Override
    public void put(K key, V value) {
        //try to replace value by existing key
        for (int i = 0; i < currentLength; i++) {
            if (!(keys[i] == null && key != null)
                    && ((keys[i] == null && key == null) || keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        //looking for length collisions
        if (currentLength == MAX_LENGTH) {
            throw new RuntimeException("Storage is full, can't add any more objects");
        }
        keys[currentLength] = key;
        values[currentLength] = value;
        currentLength++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < currentLength; i++) {
            if (keys[i] == key || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentLength;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (int i = 0; i < currentLength; i++) {
            if (keys != null && keys[i] != null) {
                hash *= keys[i].hashCode();
            }
            if (values != null && values[i] != null) {
                hash *= values[i].hashCode();
            }
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Storage comparedStorage = (Storage) obj;
        if (this.size() != comparedStorage.size()) {
            return false;
        }
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (!get(keys[i]).equals(comparedStorage.get(keys[i]))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < currentLength; i++) {
            stringBuilder.append(i).append(": key [").append(keys[i])
                    .append("] (").append(keys[i].getClass())
                    .append("), value [").append(values[i])
                    .append("] (").append(values[i].getClass())
                    .append(")").append(System.lineSeparator());
        }
        if (currentLength < MAX_LENGTH) {
            stringBuilder.append(" * ")
                    .append(MAX_LENGTH - currentLength)
                    .append(" more free cells");
        }
        return stringBuilder.toString().trim();
    }
}
