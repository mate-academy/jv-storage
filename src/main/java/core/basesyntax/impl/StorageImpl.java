package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_NUMBER_OF_ELEMENTS_IN_STORAGE = 10;
    private K[] key;
    private V[] value;

    public StorageImpl() {
        key = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS_IN_STORAGE];
        value = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS_IN_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_NUMBER_OF_ELEMENTS_IN_STORAGE; i++) {
            if (this.key[i] == null && this.value[i] == null) {
                this.key[i] = key;
                this.value[i] = value;
                break;
            } else if (key != null && key.equals(this.key[i])) {
                this.value[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < MAX_NUMBER_OF_ELEMENTS_IN_STORAGE; i++) {
            if ((key != null && key.equals(this.key[i])) || (key == null && this.key[i] == null)) {
                return this.value[i];
            }
        }
        return null;
    }
}
