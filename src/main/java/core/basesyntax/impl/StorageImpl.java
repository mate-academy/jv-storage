package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private StorageInner<K, V>[] storageImpl = new StorageInner[MAX_STORAGE_LENGTH];
    private int size = 0;

    private class StorageInner<K, V> {
        private K key;
        private V value;

        public StorageInner(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (o == null) {
                return false;
            }

            if (getClass() != o.getClass()) {
                return false;
            }

            StorageInner current = (StorageInner) o;
            return (key == current.key || key != null && key.equals(current.key))
                    && (value == current.value || value != null && value.equals(current.value));
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (key == null ? 0 : key.hashCode());
            result = 31 * result + (value == null ? 0 : value.hashCode());
            return result;
        }
    }

    @Override
    public void put(K key, V value) {
        if (issetKey(key)) {
            setValueByKey(key, value);
        } else {
            storageImpl[size] = new StorageInner<K, V>(key, value);
            size++;
        }
    }

    private void setValueByKey(K key, V value) {
        for (int i = 0; i < storageImpl.length; i++) {
            if (storageImpl[i] == null) {
                continue;
            }
            if (equals(storageImpl[i].getKey(), key)) {
                storageImpl[i].setValue(value);
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageImpl.length; i++) {
            if (storageImpl[i] == null) {
                continue;
            }
            if (equals(storageImpl[i].getKey(), key)) {
                return storageImpl[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean issetKey(K key) {
        for (int i = 0; i < storageImpl.length; i++) {
            if (storageImpl[i] == null) {
                continue;
            }
            if (equals(storageImpl[i].getKey(), key)) {
                return true;
            }
        }
        return false;
    }

    private boolean equals(K firstValue, K secondValue) {
        if (firstValue == secondValue) {
            return true;
        }

        if (firstValue == null || secondValue == null) {
            return false;
        }

        if (firstValue.equals(secondValue)) {
            return true;
        }

        return false;
    }
}
