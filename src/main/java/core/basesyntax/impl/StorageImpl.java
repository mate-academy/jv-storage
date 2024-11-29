package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] storageK = (K[]) new Object[10];
    private V[] storageV = (V[]) new Object[10];
    private int x = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0;i < x;i++) {
            if (storageK[i].equals(key)) {
                storageV[i] = value;
                return;
            }
        }
        if (x < 10) {
            storageK[x] = key;
            storageV[x] = value;
            x++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageK.length; i++) {
            if (storageK[i].equals(key)) {
                return storageV[i];  // Повертаємо значення за знайденим індексом
            }
        }
        return null;  // Якщо ключ не знайдено, повертаємо null
    }

    @Override
    public int size() {
        return x;
    }
}
