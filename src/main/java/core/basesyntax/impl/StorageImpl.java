package core.basesyntax.impl;

import core.basesyntax.Storage;

/*
   Создайте хранилище типа КЛЮЧ - ЗНАЧЕНИЕ,
   которое параметризируется 2-умя типами данных,
    и в этом хранилище можо класть значение по ключу
    и доставать значение по ключу.
    Пример: Storage<Integer, Box> storage = new Storage<>();
      storage.put(22, box); storage.get(22) // вернёт коробку.
 */
public class StorageImpl<K, V> implements Storage<K, V> {
    private Element[] storage;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    public StorageImpl() {
        this.storage = new Element[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (storage[0] == null) {
            storage[size++] = new Element<>(key, value);
            return;
        }
        for (int i = 0; i < size; i++) {
            if (key == null && storage[i].getKey() == null
                    || storage[i].getKey().equals(key)) {
                storage[i].setValue(value);
                return;
            }
        }
        storage[size++] = new Element<>(key, value);
    }

    @Override
    public V get(K key) {
        if (storage[0] == null) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (key == null && storage[i].getKey() == null
                    || storage[i].getKey().equals(key)) {
                return (V) storage[i].getValue();
            }
        }
        return null;
    }

    private static class Element<K, V> {
        private K key;
        private V value;

        private Element(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Element<K, V> element = (Element<K, V>) o;
            return this.key.equals(element.key)
                    && this.value.equals(element.value);
        }
    }
}
