package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 9;
    private K key;
    private V value;
    private int size = 0;
    private StorageImpl[] storArr = new StorageImpl[MAX_SIZE];

    public StorageImpl() {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storArr.length; i++) {
            if ((storArr[i] != null && storArr[i].key == null) && key == null) {
                storArr[i].value = value;
                break;
            } else if (storArr[i] != null && storArr[i].key != null && storArr[i].key.equals(key)) {
                storArr[i].value = value;
                break;
            } else if (storArr[i] == null) {
                StorageImpl newobj = new StorageImpl();
                newobj.setKey(key);
                newobj.setValue(value);
                storArr[i] = newobj;
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        V res = null;
        for (int i = 0; i < storArr.length; i++) {
            if ((key == null
                    && storArr[i] != null
                    && storArr[i].key == null)
                    || (storArr[i] != null
                    && storArr[i].key != null
                    && storArr[i].key.equals(key))) {
                res = (V) storArr[i].value;
                break;
            }
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }
}
