package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private K valueKey;
    private V value;
    private int storageIndex = 0;
    private final StorageImpl<K, V>[] storageArray = new StorageImpl[10];

    public StorageImpl() {
    }

    private StorageImpl(K valueKey, V value) {
        this.valueKey = valueKey;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        StorageImpl<K, V> newObject = new StorageImpl<>(key, value);
        int maxElementNumber = 10;
        if (storageIndex == maxElementNumber) {
            System.out.println("Can't add new element. There is no free space");
            return;
        }
        for (int i = 0; i < size(); i++) {
            if ((storageArray[i] != null) && ((storageArray[i].valueKey == key)
                    || (storageArray[i].valueKey != null
                    && storageArray[i].valueKey.equals(key)))) {
                System.out.println("kArray["
                        + i + "] is " + storageArray[i].valueKey
                        + " and is equals with key " + key);
                storageArray[i].value = value;
                return;
            }
        }
        storageArray[storageIndex] = newObject;
        storageIndex++;
    }

    @Override
    public V get(K key) {
        for (StorageImpl<K, V> si : storageArray) {
            if ((si != null) && ((si.valueKey == key) || (si.valueKey != null
                    && si.valueKey.equals(key)))) {
                System.out.println("with key \""
                        + key + "\" value is \"" + si.value + "\"");
                return si.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int arraySize = 0;
        for (StorageImpl<K, V> si : storageArray) {
            if (si != null) {
                arraySize++;
            }
        }
        return arraySize;
    }

    @Override
    public String toString() {
        for (int i = 0; i < storageArray.length; i++) {
            if (storageArray[i] != null) {
                System.out.println("kArray [" + i + "] = "
                        + storageArray[i].valueKey + " " + storageArray[i].value);
            }
        }
        return "";
    }
}
