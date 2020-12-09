package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH_ARRAY = 10;
    private int counter;
    private Object[] keyObject;
    private Object[] valueObject;

    public StorageImpl() {
        this.counter = 0;
        this.keyObject = new Object[LENGTH_ARRAY];
        this.valueObject = new Object[LENGTH_ARRAY];
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < counter; i++) {
            if (this.keyObject[i] == key || key != null && key.equals(this.keyObject[i])) {
                this.valueObject[i] = value;
                return;
            }
        }
        this.keyObject[counter] = key;
        this.valueObject[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (this.keyObject[i] == key || key != null && key.equals(this.keyObject[i])) {
                return (V) this.valueObject[i];
            }
        }
        return null;
    }
}
