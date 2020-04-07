package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

/*Создайте хранилище типа КЛЮЧ - ЗНАЧЕНИЕ, которое параметризируется 2-умя типами данных,
и в этом хранилище можо класть значение по ключу и доставать значение по ключу.
Пример: Storage<Integer, Box> storage = new Storage<>(); storage.put(22, box);
storage.get(22) // вернёт коробку.
Реализовать на основе двух массивов (или одного массива в зависимости от реализации).
При реализации с помощью массива (массивов) ожидаем что количество елементов в
нашем Storage не превышает 10*/

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] masKeys = new Object[10];
    private Object[] masValues = new Object[10];
    private int indexForMasKey = 0;
    private int indexForMasValue = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < indexForMasKey; i++) {
            if (Objects.equals(key, masKeys[i])) {
                masValues[i] = value;
                return;
            }
        }
        masKeys[indexForMasKey] = key;
        masValues[indexForMasValue] = value;
        indexForMasValue++;
        indexForMasKey++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < indexForMasKey; i++) {
            if (key == masKeys[i] || (key != null && key.equals(masKeys[i]))) {
                return (V) masValues[i];
            }
        }
        return null;
    }
}
