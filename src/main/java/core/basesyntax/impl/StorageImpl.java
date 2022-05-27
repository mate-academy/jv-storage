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
        int numFindKey = NOT_FIND;
        boolean findElement = false;
        for (int i = 0; i < realLengthStorage; i++) {
            if ((this.objKey[i] != null && this.objKey[i].equals(key))
                    || (key == null && this.objKey[i] == null)) {
                if (this.objValue[i] != null) {
                    findElement = true;
                    numFindKey = i;
                    break;
                }
            }
        }
        if (findElement) {
            this.objValue[numFindKey] = (V) value;
        }
        if (!findElement) {
            this.objKey[realLengthStorage] = (K) key;
            this.objValue[realLengthStorage] = (V) value;
            realLengthStorage++;
        }
    }

    @Override
    public V get(K key) {
        int searchKey = NOT_FIND;
        for (int i = 0; i < realLengthStorage; i++) {
            if ((key == null && this.objKey[i] == null)
                    || ((this.objKey[i] != null) && (this.objKey[i].equals(key)))) {
                searchKey = i;
                break;
            }
        }
        return (searchKey == NOT_FIND ? null : (V) this.objValue[searchKey]);
    }

    @Override
    public int size() {
        return realLengthStorage;
    }
}
