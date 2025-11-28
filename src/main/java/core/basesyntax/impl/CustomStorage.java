package core.basesyntax.impl;

@SuppressWarnings("unchecked")
public class CustomStorage<K, V> {
    private static final int INIT_CAPACITY = 10;
    private int size;
    private final Entry<K, V>[] table;

    static class Entry<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

    public CustomStorage() {
        this.size = 0;
        table = (Entry<K, V>[]) new Entry[INIT_CAPACITY];
    }

    public V get(K key) {
        int index = keyIndex(key);

        if (index >= 0) {
            return table[index].getValue();
        }

        return null;
    }

    public void put(K key, V value) {
        int keyIndex = keyIndex(key);

        if (this.size >= INIT_CAPACITY && keyIndex == -1) {
            throw new RuntimeException("Storage is full");
        }

        Entry<K, V> entry = new Entry<>();
        entry.setKey(key);
        entry.setValue(value);

        if (keyIndex >= 0) {
            table[keyIndex] = entry;
        } else {
            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    table[i] = entry;
                    break;
                }
            }
            this.size++;
        }

    }

    public int size() {
        return size;
    }

    private int keyIndex(K key) {
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            K entryKey = entry != null ? entry.getKey() : null;
            if (entry != null
                    && (entryKey == key || entryKey != null
                    && entryKey.equals(key))) {
                return i;
            }
        }
        return -1;
    }

}
