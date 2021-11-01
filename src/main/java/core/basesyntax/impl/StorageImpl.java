package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_STORAGE_ELEMENTS = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_NUMBER_STORAGE_ELEMENTS];
        values = (V[]) new Object[MAX_NUMBER_STORAGE_ELEMENTS];
    }

    @Override
    public void put(K key, V value) {
        if (size > MAX_NUMBER_STORAGE_ELEMENTS) {
            throw new SizeExceedsLimitException("Size of storage exceedsmi the limit");
        }
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
        return;
    }
    /*
else краще прибрати і модифікувати if.
    Якщо size > max number то викинути ексепшин, що сторедж заповнений.
    В такому випадку ми будемо мати більш очевидну роботу класу.
    Зараз, коли ми додаємо елемент в заповнений сторедж нічого
    не відбувається і це виглядає так ніби елемент успішно
    був доставлений в сторедж,
    що може викликати труднощі при пошуку проблеми
    */

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
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
