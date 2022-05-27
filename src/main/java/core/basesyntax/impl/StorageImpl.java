package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int AMOUNT_OF_STORAGE = 10;
    private static final int NOT_FIND = -1;
    private Object[] objKey;
    private Object[] objValue;
    private int realLengthStorage;

    public StorageImpl() {
        objKey = new Object[AMOUNT_OF_STORAGE];
        objValue = new Object[AMOUNT_OF_STORAGE];
        realLengthStorage = 0;
    }

    @Override
    public void put(K key, V value) {

        if (get(key) == null) {
            objKey[realLengthStorage] = (K) key;
            objValue[realLengthStorage] = (V) value;
            realLengthStorage++;
            return;
        }

        int numFindKey = NOT_FIND;
        for (int i = 0; i < realLengthStorage; i++) {
            if ((objKey[i] != null && objKey[i].equals(key))
                    || (key == null && objKey[i] == null)) {
                if (objValue[i] != null) {
                    numFindKey = i;
                    break;
                }
            }
        }
        objValue[numFindKey] = (V) value;
    }

    @Override
    public V get(K key) {
        int searchKey = NOT_FIND;
        for (int i = 0; i < realLengthStorage; i++) {
            if ((key == null && objKey[i] == null)
                    || ((objKey[i] != null) && (objKey[i].equals(key)))) {
                searchKey = i;
                break;
            }
        }
        return (searchKey == NOT_FIND ? null : (V) objValue[searchKey]);
    }

    @Override
    public int size() {
        return realLengthStorage;
    }
}
