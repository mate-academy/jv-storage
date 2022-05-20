package core.basesyntax.impl;

import core.basesyntax.Pair;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] pair;
    private int size = 0;

    public StorageImpl() {
        pair = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (this.size == 10) {
            System.out.println("Can't put new pair. Array is overloaded");
            return;
        }
        for (int i = 0; i < this.size; i++) {
            if (pair[i].isEqualKeys(key)) {
                pair[i].setValue(value);
                return;
            }
        }
        this.pair[this.size] = new Pair<>(key, value);
        this.size++;
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> e : this.pair) {
            if (e != null && e.isEqualKeys(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
