package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final ArrayList<KeyValueObject<K, V>> listKeyValue = new ArrayList<>();

    @Override
    public void put(K key, V value) {

        for (KeyValueObject<K, V> object : listKeyValue) {
            if (object.getKey() == null ? key == null : object.getKey().equals(key)) {
                object.setValue(value);
                return;
            }
        }

        if (listKeyValue.size() < 10) {
            listKeyValue.add(new KeyValueObject<>(key, value));
        }
    }

    @Override
    public V get(K key) {

        for (KeyValueObject<K, V> object : listKeyValue) {
            if (object.getKey() == null ? key == null : object.getKey().equals(key)) {
                return object.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return listKeyValue.size();
    }
}
