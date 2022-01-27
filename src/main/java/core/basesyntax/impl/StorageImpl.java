package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_NUM_OF_ELEMENTS = 10;
    private K[] keyArr;
    private V[] valueArr;

    public StorageImpl() {
        this.keyArr = (K[]) new Object[MAX_NUM_OF_ELEMENTS];
        this.valueArr = (V[]) new Object[MAX_NUM_OF_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArr.length; i++) {
            if (isEgual(keyArr[i], key)) {
                valueArr[i] = value;
                break;
            } else if (keyArr[i] == null && valueArr[i] == null) {
                keyArr[i] = key;
                valueArr[i] = value;
                break;
            }
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArr.length; i++) {
            if (isEgual(keyArr[i], key)) {
                return valueArr[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 1; i < keyArr.length; i++) {
            if ((keyArr[i] == null && valueArr[i] == null)
                    && (keyArr[i - 1] != null || valueArr[i - 1] != null)) {
                return i;
            }
        }
        return 0;
    }

    public <K> boolean isEgual(K first, K second) {
        return first == second || (first != null && first.equals(second));
    }

}
