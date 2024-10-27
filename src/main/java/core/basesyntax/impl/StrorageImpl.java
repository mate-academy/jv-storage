package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StrorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private Object[] keys;
    private Object[] values;
    private int size;

    public StrorageImpl(){
        this.keys = new Object[MAX_CAPACITY];
        this.values = new Object[MAX_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(Object key, Object value) {
        for(int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if(size < MAX_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println("Storage is full. Its impossible to add another element.");
        }
    }

    @Override
    public Object get(Object key) {
        for(int i = 0; i < size; i++){
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
