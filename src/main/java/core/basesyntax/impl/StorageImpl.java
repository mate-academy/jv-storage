package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private MyBox<K, V>[] myBoxArray = new MyBox[20];

    private int counter = 0;

    @Override
    public void put(K key, V value) {
        MyBox<K, V> temp = getMyBox(key);
        if (temp != null) {
            temp.setValue(value);
        } else {
            temp = new MyBox<>(key, value);
            myBoxArray[counter++] = temp;
        }
    }

    @Override
    public V get(K key) {
        MyBox<K, V> temp = getMyBox(key);
        return temp != null ? temp.getValue() : null;
    }

    private MyBox<K, V> getMyBox(K key) {
        for (MyBox<K, V> myBox : myBoxArray) {
            if (myBox != null && isEquals(key, myBox.getKey())) {
                return myBox;
            }
        }
        return null;
    }

    private boolean isEquals(K key, K keyFromBox) {
        if (keyFromBox == null) {
            return keyFromBox == key;
        }
        return keyFromBox.equals(key);
    }

    private class MyBox<K, V> {
        private K key;
        private V value;

        public MyBox(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
