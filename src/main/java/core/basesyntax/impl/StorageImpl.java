package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;

    private final Container<K, V>[] containers;
    private int queueCounter;

    public StorageImpl() {
        containers = new Container[ARRAY_SIZE];
        queueCounter = 0;
    }

    @Override
    public void put(K key, V value) {
        if (queueCounter >= ARRAY_SIZE) {
            throw new RuntimeException("Out of bound of array. Limit is " + ARRAY_SIZE);
        }
        if (get(key) != null) {
            rewriteValueByKey(key, value);
        } else {
            containers[queueCounter] = new Container<>(key, value, queueCounter);
            queueCounter++;
        }
    }

    private void rewriteValueByKey(K key, V value) {
        Container<K, V> lookingContainer = getContainerByKey(key);
        lookingContainer.setValue(value);
    }

    private Container<K, V> getContainerByKey(K key) {
        Container<K, V> existingContainer = null;
        for (Container<K, V> container : containers) {
            if (container != null
                    && (key == null ? key == container.getKey() : key.equals(container.getKey()))) {
                existingContainer = container;
            }
        }
        return existingContainer;
    }

    @Override
    public V get(K key) {
        Container<K, V> lookingContainer = getContainerByKey(key);
        return lookingContainer == null ? null : lookingContainer.getValue();
    }

    @Override
    public int size() {
        return queueCounter;
    }

    private static class Container<K, V> {
        private V value;
        private final K key;
        private final int number;

        private Container(K key, V value, int counter) {
            this.key = key;
            this.value = value;
            this.number = counter;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public int getNumber() {
            return number;
        }
    }
}
