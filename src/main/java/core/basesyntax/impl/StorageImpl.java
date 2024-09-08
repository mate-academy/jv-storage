package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
          if (this == obj) {
              return true;
          }
          if (obj == null || getClass() != obj.getClass()) {
              return false;
          }
          Entry<?, ?> current = (Entry<?, ?>)obj;
          return (key == null && current.key == null) || (key != null && key.equals(current.key));
        }

        @Override
        public int hashCode() {
            int result = 17;
            result += 31 * (key != null ? key.hashCode() : 0);
            result += 31 * (value != null ? value.hashCode() : 0);
            return result;
        }
    }

    private int entrySize = 0;
    private Entry[] box = new Entry[10];

    @Override
    public void put(K key, V value) {
        Entry entry = new Entry(key, value);
        for (int i = 0; i < entrySize; i++) {
            if (box[i].equals(entry)) {
                box[i].value = value;
                return;
            }
        }
        box[entrySize] = entry;
        entrySize++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < entrySize; i++) {
            if ((box[i] != null && box[i].key == null && key == null)
            || (box[i] != null && key != null && key.equals(box[i].key))) {
                return (V) box[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return entrySize;
    }
}
