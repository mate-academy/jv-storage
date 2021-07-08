package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private int currentLength;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        currentLength = 0;
    }

    @Override
    public void put(K key, V value) {
        initializeArraysIfNeeded(key, value);
        if (addedValueNoNullArray(value)) {
            return;
        }
        if (replacedValueByExistingKey(key, value)) {
            return;
        }
        if (currentLength == MAX_LENGTH) {
            throw new RuntimeException("Storage is full, can't add any more objects");
        }
        addNewRowToStorage(key, value);
    }

    private void initializeArraysIfNeeded(K key, V value) {
        if (keys == null && key != null) {
            keys = (K[]) Array.newInstance(key.getClass(), MAX_LENGTH);
        }
        if (values == null && value != null) {
            values = (V[]) Array.newInstance(value.getClass(), MAX_LENGTH);
        }
    }

    private boolean addedValueNoNullArray(V value) {
        //if keys aren't initialized yet but we need to add a value,
        //we are writing or rewriting value to [0] cell
        if (keys == null && values != null) {
            values[0] = value;
            if (currentLength == 0) {
                currentLength++;
            }
            return true;
        }
        return false;
    }

    private boolean replacedValueByExistingKey(K key, V value) {
        for (int i = 0; i < currentLength; i++) {
            if (!(keys[i] == null && key != null)
                    && ((keys[i] == null && key == null) || keys[i].equals(key))) {
                values[i] = value;
                return true;
            }
        }
        return false;
    }

    private void addNewRowToStorage(K key, V value) {
        if (keys != null) {
            keys[currentLength] = key;
        }
        if (values != null) {
            values[currentLength] = value;
        }
        currentLength++;
    }

    @Override
    public V get(K key) {
        if (keys == null) {
            return values == null ? null : values[0];
        }
        for (int i = 0; i < currentLength; i++) {
            if ((keys[i] == null) == (key == null)
                    && (key == null || keys[i].equals(key))) {
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
