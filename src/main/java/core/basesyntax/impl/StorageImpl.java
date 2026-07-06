package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_CAPACITY];
        this.values = new Object[MAX_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        // Шукаємо, чи є вже такий ключ
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value; // Оновлюємо значення
                return;
            }
        }

        // Якщо ключа немає, додаємо новий
        if (size < MAX_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        // Шукаємо значення за ключем
        for (int i = 0; i < size; i++) {
            if (Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
