package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static StorageImpl [] collection = new StorageImpl[10];

    private K key;
    private V value;

    public StorageImpl() {
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < collection.length; ++i){
            if (collection[i] == null || collection[i].getKey() == key){
                collection[i] = new StorageImpl<>(key,value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        V val = null;

        for (int i = 0; i < collection.length; ++i){
            if (collection[i] != null && collection[i].getKey() == key){
                val = (V) collection[i].value;
            }
        }
        return val;
    }

    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (object != null || object.getClass() != this.getClass()){
            return false;
        }
        StorageImpl storageImpl = (StorageImpl) object;
        return key.equals(storageImpl.key) && value.equals(storageImpl.value);
    }

    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime + result * key.hashCode();
        result = prime + result * value.hashCode();
        return result;
    }
}
