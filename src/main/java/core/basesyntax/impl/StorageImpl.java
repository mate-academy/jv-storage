package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    List<Entry> list = new ArrayList<>();
    Entry nullEntry = new Entry(null, null);

    @Override
    public void put(K key, V value) {
        if (key == null) {
            nullEntry.setValue(value);
        } else {
            for (Entry entry : list) {
                if (key.equals(entry.getKey())) {
                    entry.setValue(value);
                }
            }
            list.add(new Entry(key, value));
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return nullEntry.getValue();
        } else {
            for (Entry entry : list) {
                if (key.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    private class Entry {
        private K key;
        private V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        String element = "Element";

        storage.put(null, element);

        System.out.println(storage.get(1));
    }
}
