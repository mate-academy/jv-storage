package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int CAPACITY_OF_STORAGE = 10;
    private Container<K, V>[] containers;
    private int size;

    public StorageImpl() {
        containers = new Container[CAPACITY_OF_STORAGE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (containers[i].key == key
                    || containers[i].key != null && containers[i].key.equals(key)) {
                containers[i].value = value;
                return;
            }
        }
        Container<K, V> container = new Container<>(key, value);
        containers[size] = container;
        size++;
    }

    @Override
    public V get(K key) {
        for (Container<K, V> container : containers) {
            if (container == null) {
                return null;
            } else if (container.key == key || container.key != null && container.key.equals(key)) {
                return container.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Container<K, V> {
        private K key;
        private V value;

        public Container(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
