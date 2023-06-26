package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private StorageImpl<K, V> next;

    public StorageImpl() {
        next = this;
    }

    @Override
    public void put(K key, V value) {
        if (next == this) {
            this.key = key;
            this.value = value;
            next = null;
            return;
        }

        // Overriding the value if the keys match
        if (Objects.equals(this.key, key)) {
            this.value = value;
            return;
        }

        if (next == null) {
            next = new StorageImpl<>();
        }

        next.put(key, value);
    }

    @Override
    public V get(K key) {
        if (next == this) {
            return null;
        }

        if (Objects.equals(this.key, key)) {
            return this.value;
        }

        if (this.next == null) {
            return null;
        } else {
            return this.next.get(key);
        }
    }

    @Override
    public int size() {
        if (next == this) {
            return 0;
        }

        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    @Override
    public int hashCode() {
        if (next != this) {
            return Objects.hash(key, value, next);
        }

        return Objects.hash(key, value);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object == this) {
            return true;
        }

        if (object.getClass().equals(StorageImpl.class)) {
            StorageImpl storage = (StorageImpl) object;

            if (next != this) {
                return Objects.equals(key, storage.key)
                        && Objects.equals(value, storage.value)
                        && Objects.equals(next, storage.next);
            }

            return Objects.equals(key, storage.key)
                    && Objects.equals(value, storage.value);
        }

        return false;
    }
}
