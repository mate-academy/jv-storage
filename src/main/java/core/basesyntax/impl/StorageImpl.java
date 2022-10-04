package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;

    private final Container<K, V>[] containers;
    private int counter;

    public StorageImpl() {
        containers = new Container[ARRAY_SIZE];
        counter = 0;

    }

    @Override
    public void put(K key, V value) {
        if (counter > ARRAY_SIZE) {
            counter = 0;
        }
        if (get(key) != null) {
            rewriteValueByKey(key, value);
        } else {
            containers[counter] = new Container<>(key, value, counter);
            counter++;
        }
    }

    private void rewriteValueByKey(K key, V value) {
        Container<K, V> lookingContainer = getContainerByKey(key);
        lookingContainer.setValue(value);
    }

    private Container<K, V> getContainerByKey(K key) {
        Container<K, V> lookingContainer = null;
        for (Container<K, V> container : containers) {
            if (container != null
                    && (key == null ? key == container.getKey() : key.equals(container.getKey()))) {
                lookingContainer = container;
            }
        }
        return lookingContainer;
    }

    @Override
    public V get(K key) {
        Container<K, V> lookingContainer = getContainerByKey(key);
        return lookingContainer == null ? null : lookingContainer.getValue();
    }

    @Override
    public int size() {
        return counter;
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
