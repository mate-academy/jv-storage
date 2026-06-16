package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private final Element<K, V>[] elements;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.elements = (Element<K, V>[]) new Element[MAX_CAPACITY];
    }

    private static class Element<K, V> {
        private final K key;
        private V value;

        public Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i].key, key)) {
                elements[i].value = value;
                return;
            }
        }

        if (size < MAX_CAPACITY) {
            elements[size] = new Element<>(key, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            // Використовуємо Objects.equals, щоб коректно обробляти ключ null
            if (Objects.equals(elements[i].key, key)) {
                return elements[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
