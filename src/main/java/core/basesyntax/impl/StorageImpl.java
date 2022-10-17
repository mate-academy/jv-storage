package core.basesyntax.impl;

import core.basesyntax.Storage;


public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private final K[] arrayKey;
    private final V[] arrayValue;
    private  int sizeElementsInArray = 0;

    public StorageImpl() {
        arrayKey = (K[]) new Object[SIZE];
        arrayValue = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < arrayKey.length; i++) {
            if ((key == null && arrayKey[i] == null)) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                break;
            }
            if ((key != null) && key.equals(arrayKey[i])) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                break;
            }
            if (key != null && arrayValue[i] == null) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                sizeElementsInArray++;
                break;
            }
        }
    }


    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < arrayKey.length; i++) {
            if (key == null && arrayKey[i] == null){
                value = arrayValue[i];
                break;
            }
            if(key != null && key.equals(arrayKey[i])){
                value = arrayValue[i];
                break;
            }
        }
        return  value;
    }


    @Override
    public int size(){
        return sizeElementsInArray;
    }

}
