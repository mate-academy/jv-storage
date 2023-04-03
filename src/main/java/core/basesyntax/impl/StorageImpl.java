package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private int storageIndex = 0;
    private final Pair<K, V>[] storageArray = new Pair[10];

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        Pair<K, V> newObject = new Pair<>(key, value);
        int maxElementNumber = 10;
        if (storageIndex == maxElementNumber) {
            System.out.println("Can't add new element. There is no free space");
            return;
        }
        for (int i = 0; i < storageIndex; i++) {
            if ((storageArray[i] != null) && ((storageArray[i].key == key)
                    || (storageArray[i].key != null
                    && storageArray[i].key.equals(key)))) {
                System.out.println("kArray["
                        + i + "] is " + storageArray[i].key
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
        for (Pair<K, V> si : storageArray) {
            if ((si != null) && ((si.key == key) || (si.key != null
                    && si.key.equals(key)))) {
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
        for (Pair<K, V> si : storageArray) {
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
                        + storageArray[i].key + " " + storageArray[i].value);
            }
        }
        return "";
    }
}
