package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static String[] arraysValue;
    private static String[] arraysKey;
    private static final String SPLIT_INDEX = "___";
    private final StringBuilder keys;
    private final StringBuilder values;
    private int size;

    public StorageImpl() {
        keys = new StringBuilder();
        values = new StringBuilder();
        size = 0;
    }

    @Override
    public void put(K key, V value) {

        keys.append(key).append(SPLIT_INDEX);
        values.append(value).append(SPLIT_INDEX);
        arraysKey = keys.toString().split(SPLIT_INDEX);
        arraysValue = values.toString().split(SPLIT_INDEX);
        size = arraysKey.length;
        for (int i = 0; i < arraysKey.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ((arraysKey[j] != null && arraysKey[j].equals(arraysKey[i]))
                        || (arraysKey[j] == null && arraysKey[i] == null)) {
                    arraysKey[j] = arraysKey[i];
                    arraysValue[j] = arraysValue[i];
                    size--;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < arraysKey.length; i++) {
            if (key != null && arraysKey[i].equals(key.toString())
                    || arraysKey[i].equals("null") && key == null) {
                return (V) arraysValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
