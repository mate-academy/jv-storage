package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {

    private final List<K> keys = new ArrayList<>();
    private final List<V> values = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        boolean isNewKey = true;
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) != null && keys.get(i).equals(key)) {
                values.remove(values.get(i));
                values.add(i, value);
                isNewKey = false;
                break;

            } else if (keys.get(i) == null && keys.get(i) == (key)) {
                values.remove(values.get(i));
                values.add(i, value);
                isNewKey = false;
                break;
            }
        }
        if (isNewKey) {
            keys.add(key);
            values.add(value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == (key)) {
                return values.get(i);
            }
            if (keys.get(i) != null && !(keys.get(i).getClass().isPrimitive())) {
                if (keys.get(i).equals(key)) {
                    return values.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public int size() {

        return keys.size();
    }
}
