package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int AMOUNT_OF_STORAGE = 10;
    private static final int ZERO_ELEMENT_FIND = -1;
    private static final int START_FIND_KEY = -1;
    private static final int START_FIND_FIRST_EMPTY_KEY_VALUE = -1;
    private Object[] objKey;
    private int len;
    private Object[] objValue;

    public StorageImpl() {
        this.objKey = new Object[AMOUNT_OF_STORAGE];
        this.objValue = new Object[AMOUNT_OF_STORAGE];
        this.len = AMOUNT_OF_STORAGE;
    }

    @Override
    public void put(K key, V value) {
        int numFindKey = START_FIND_KEY;
        int firstEmptyKeyValue = START_FIND_FIRST_EMPTY_KEY_VALUE;
        boolean findFirstEmptyKey = false;
        boolean findElement = false;
        for (int i = 0; i < this.len; i++) {
            if (this.objKey[i] == null && this.objValue[i] == null && !findFirstEmptyKey) {
                findFirstEmptyKey = true;
                firstEmptyKeyValue = i;
            }
            if (this.objKey[i] != null && this.objKey[i].equals(key)) {
                if (this.objValue[i] != null) {
                    findElement = true;
                    numFindKey = i;
                    break;
                }
            }
            if (key == null && this.objKey[i] == null) {
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
            this.objKey[firstEmptyKeyValue] = (K) key;
            this.objValue[firstEmptyKeyValue] = (V) value;
        }
    }

    @Override
    public V get(K key) {
        int searchKey = ZERO_ELEMENT_FIND;
        for (int i = 0; i < this.len; i++) {
            if (key == null && this.objKey[i] == null) {
                searchKey = i;
                break;
            }
            if (this.objKey[i] == null) {
                continue;
            }
            if (this.objKey[i].equals(key)) {
                searchKey = i;
                break;
            }
        }
        return (searchKey == ZERO_ELEMENT_FIND ? null : (V) this.objValue[searchKey]);
    }

    @Override
    public int size() {
        int realLengthStorage = 0;
        for (int i = 0; i < this.len; i++) {
            if (this.objKey[i] == null && this.objValue[i] == null) {
                continue;
            }
            realLengthStorage++;
        }
        return realLengthStorage;
    }
}
