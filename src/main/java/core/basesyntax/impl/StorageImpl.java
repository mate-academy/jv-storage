package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_SIZE];
        this.values = (V[]) new Object[MAX_SIZE];
        this.size = 0; // Вимога №2: ініціалізація в конструкторі
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key); // Вимога №5: використовуємо допоміжний метод
        if (index != -1) {
            values[index] = value;
            return;
        }

        // Зауваження ментора: перевірка, щоб не перевищити ліміт у 10 елементів
        if (size < MAX_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        return index != -1 ? values[index] : null;
    }

    @Override
    public int size() {
        return size;
    }

    // Вимога №5 та №6: винесена логіка та ручне порівняння без Objects.equals
    private int findKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            // Порівнюємо посилання (для null) або вміст (для об'єктів)
            if (key == keys[i] || (key != null && key.equals(keys[i]))) {
                return i;
            }
        }
        return -1;
    }
}
