/*
   Создайте хранилище типа КЛЮЧ - ЗНАЧЕНИЕ, которое параметризируется 2-умя типами данных,
    и в этом хранилище можо класть значение по ключу и доставать значение по ключу.
     Пример: Storage<Integer, Box> storage = new Storage<>();
      storage.put(22, box); storage.get(22) // вернёт коробку.
 */

package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Entry[] data;
    private int size;
    private final int defaultCapacity = 16;

    public StorageImpl(int capacity) {
        this.data = new Entry[capacity];
    }

    public StorageImpl() {
        this.data = new Entry[defaultCapacity];
    }

    @Override
    public V get(K key) {
        if (data[0] == null) {
            return null;
        }

        for (int i = 0; i < size; i++) {
            if (key == null || data[i].getKey().equals(key)) {
                return (V) data[i].getValue();
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        if (data[0] == null) {
            data[size++] = new Entry<>(key, value);
            return;
        }

        for (int i = 0; i < size; i++) {
            if ((key == null && data[i].getKey() == null)
                    || data[i].getKey().equals(key)) {
                data[i].setValue(value);
                return;
            }
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

        public V getValue() {
            return this.value;
        }

        void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
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
