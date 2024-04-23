package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE = 10;
    private static final int NULL_PLACEHOLDER = 99;
    private Object[] valueArr = new Object[MAX_STORAGE];
    private Object[] keyArr = new Object[MAX_STORAGE];
    private int itemsNumber = 0;

    @Override
    public void put(K key, V value) {
        if (key == null && !nullCheck()) {
            keyArr[itemsNumber] = NULL_PLACEHOLDER;
            valueArr[itemsNumber] = value;
            itemsNumber++;
            return;
        }

        if (duplicateCheck(key,value)) {
            return;
        }

        keyArr[itemsNumber] = key;
        valueArr[itemsNumber] = value;
        itemsNumber++;
    }

    private boolean nullCheck() {
        try {
            for (Object o : keyArr) {
                if (o.equals(NULL_PLACEHOLDER)) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean duplicateCheck(K key, V value) {
        try {
            for (int i = 0; i < keyArr.length; i++) {
                if (key == null && keyArr[i].equals(NULL_PLACEHOLDER)) {
                    valueArr[i] = value;
                    return true;
                }
                if (keyArr[i].equals(key)) {
                    valueArr[i] = value;
                    return true;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public V get(K key) {
        try {
            for (int i = 0; i < keyArr.length; i++) {
                if (key == null && keyArr[i].equals(NULL_PLACEHOLDER)) {
                    return (V) valueArr[i];
                }
                if (keyArr[i].equals(key)) {
                    return (V) valueArr[i];
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int size() {
        return itemsNumber;
    }
}
