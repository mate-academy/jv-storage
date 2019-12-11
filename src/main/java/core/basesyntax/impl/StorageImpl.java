package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int STORAGE_SIZE = 10;
    private int counter = 0;

    private Object[] key;
    private Object[] value;

    public <K, V> StorageImpl() {
        this.key = new Object[STORAGE_SIZE];
        this.value = new Object[STORAGE_SIZE];
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < counter; i++) {
            //this.key[i] == key || this.key[i] != null && (this.key[i]).equals(key)
            if (Objects.equals(this.key[i], key)) {
                this.value[i] = value;
                return;
            }
        }
        if (counter == STORAGE_SIZE) {
            return;
        } else {
            this.value[counter] = value;
            this.key[counter] = key;
            ++counter;
        }
    }

    @Override
    public V get(K key) {

        for (int i = 0; i < counter; i++) {
            //this.key[i] == key || this.key[i].equals(key)
            if (Objects.equals(this.key[i], key)) {
                return (V) value[i];
            }
        }
        return null;
    }
}
