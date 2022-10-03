package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, S> implements Storage<K, S> {
    private final StorageData<K, S> data = new StorageData<>();

    @Override
    public void put(K key, S value) {
        data.setKeysAndValue(key,value);
    }

    @Override
    public S get(K key) {
        return data.getByKeys(key);
    }

    @Override
    public int size() {
        return data.getSizeOfArray();
    }
}
