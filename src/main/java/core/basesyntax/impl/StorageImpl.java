package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ROW = 10;
    private static final int MAX_COLUMN = 2;
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private Object[][] pairs;
    private int usedSpace;

    public StorageImpl() {
        this.pairs = new Object[MAX_ROW][MAX_COLUMN];
    }

    @Override
    public void put(K key, V value) {
        boolean newKey = true;
        for (int i = 0; i < this.usedSpace; i++) {
            if (Objects.equals(this.pairs[i][KEY_INDEX], key)) {
                this.pairs[i][VALUE_INDEX] = value;
                newKey = false;
                break;
            }
        }
        if (newKey) {
            this.pairs[this.usedSpace][KEY_INDEX] = key;
            this.pairs[this.usedSpace][VALUE_INDEX] = value;
            this.usedSpace++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.usedSpace; i++) {
            if (Objects.equals(this.pairs[i][KEY_INDEX], key)) {
                return (V) this.pairs[i][VALUE_INDEX];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.usedSpace;
    }
}
