package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_NUM_OF_ELEMENTS = 10;
    private K[] keyArr;
    private V[] valueArr;
    private int size;

    public StorageImpl() {
        this.keyArr = (K[]) new Object[MAX_NUM_OF_ELEMENTS];
        this.valueArr = (V[]) new Object[MAX_NUM_OF_ELEMENTS];
        this.size = size;
    }

    @Override
    public void put(K key, V value) {
        if ((size == 0) || (contains(keyArr, key) == -1)) {
            keyArr[size] = key;
            valueArr[size] = value;
            size++;
        } else if (size != 0 && (contains(keyArr, key) != -1)) {
            valueArr[contains(keyArr, key)] = value;
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
        return this.size;
    }

    public int contains(Object[] objArr, Object obj) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (isEgual(objArr[i], obj)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public <K> boolean isEgual(K first, K second) {
        return first == second || (first != null && first.equals(second));
    }
}
