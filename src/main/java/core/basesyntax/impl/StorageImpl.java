package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static class First {
        private Object key;
        private Object value;

        public First(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private First[] firsts = new First[10];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(firsts[i].key,key)) {
                firsts[i].value = value;
                return;
            }
        }

        if (size <= 10) {
            firsts[size] = new First(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(firsts[i].key,key)) {
                return (V) firsts[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}

