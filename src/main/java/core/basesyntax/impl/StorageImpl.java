/*
   Создайте хранилище типа КЛЮЧ - ЗНАЧЕНИЕ, которое параметризируется 2-умя типами данных,
    и в этом хранилище можо класть значение по ключу и доставать значение по ключу.
     Пример: Storage<Integer, Box> storage = new Storage<>();
      storage.put(22, box); storage.get(22) // вернёт коробку.
 */

package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Entry[] data;
    private int size;
    private int capacity;
    private final int defaultCapacity = 10;

    public StorageImpl(int capacity) {
        if (capacity < defaultCapacity) {
            capacity = defaultCapacity;
        }
        this.data = new Entry[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public StorageImpl() {
        this.data = new Entry[defaultCapacity];
        this.capacity = defaultCapacity;
        this.size = 0;
    }

    @Override
    public V get(K key) {
        if (key != null) {
            for (int i = 0; i < size; i++) {
                Entry entry = data[i];
                if (!entry.getKey().equals(key)) {
                    continue;
                }
                return (V) entry.getValue();
            }
            return null;
        }
        for (int i = 0; i < size; i++) {
            Entry entry = data[i];
            if (entry.getKey() != null) {
                continue;
            }
            return (V) entry.getValue();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        if (size > capacity / 1.2) {
            this.data = Arrays.copyOf(this.data, this.data.length);
        }

        for (int i = 0; i < size; i++) {
            Entry entry = data[i];
            if (!entry.getKey().equals(key)) {
                continue;
            }
            entry.setValue(value);
        }
        data[size++] = new Entry<>(key, value);
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        V getValue() {
            return this.value;
        }

        void setValue(V value) {
            this.value = value;
        }

        K getKey() {
            return this.key;
        }

        void setKey(K key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }

            if (object instanceof Entry) {
                return ((Entry) object).getKey().equals(this.key)
                        && ((Entry) object).getValue().equals(this.value);
            }
            return false;
        }
    }
}
