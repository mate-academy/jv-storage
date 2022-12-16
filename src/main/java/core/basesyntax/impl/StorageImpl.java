package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private final int storageSize = 10;
    @SuppressWarnings("unchecked")
    private final K[] keyStorage = (K[]) new Object[storageSize];
    @SuppressWarnings("unchecked")
    private final V[] valueStorage = (V[]) new Object[storageSize];
    private int counter = 0;

    @Override
    public void put(K key, V value) {
        keyStorage[counter] = key;
        valueStorage[counter] = value;
        checkSimilarity(value);
        counter++;
    }

    private void checkSimilarity(V value) {
        for (int i = 0; i < keyStorage.length; i++) {
            for (int j = i + 1; j < keyStorage.length; j++) {
                if (Objects.equals(keyStorage[i], keyStorage[j])) {
                    if (!Objects.equals(valueStorage[j],null)
                            || !Objects.equals(keyStorage[j],null)) {
                        Arrays.asList(valueStorage)
                                .set(Arrays.asList(keyStorage).indexOf(keyStorage[j]), value);
                        Arrays.asList(valueStorage).set(counter, null);
                    }
                }
            }
        }
    }

    @Override
    public V get(K key) {
        int index;
        for (K keyValue : keyStorage) {
            if (Objects.equals(keyValue, key)) {
                index = Arrays.asList(keyStorage).indexOf(keyValue);
                return valueStorage[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (V valueOfArray : valueStorage) {
            if (valueOfArray != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StorageImpl<?, ?> storage = (StorageImpl<?, ?>) o;
        return Arrays.equals(keyStorage, storage.keyStorage)
                && Arrays.equals(valueStorage, storage.valueStorage);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(keyStorage);
        result = 31 * result + Arrays.hashCode(valueStorage);
        return result;
    }
}
