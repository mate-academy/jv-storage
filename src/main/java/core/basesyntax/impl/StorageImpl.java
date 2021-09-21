package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    int maxEl = 10;
    private Object[] elements = new Object[maxEl];
    private Object[] values = new Object[maxEl];
    private int index = 0;

    public class Ka<N,C extends StorageImpl<K, V>> {
        private N name;
        private C color;

        public N getName() {
            return name;
        }

        public C getColor() {
            return color;
        }
    }

    public int getSize() {
        return index;
    }

    public void setSize(int size) {
        this.index = size;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private Ka obj = new Ka();
    Object nameOfCat = obj.getName();
    Object colorOfCat = obj.getColor();

    @Override
    public void put(K key, V value) {
        index = getSize() + 1;
        StorageImpl<K, V> instance = new StorageImpl<>();
        elements[index - 1] = key;
        values[index - 1] = value;
        instance.setKey(key);
        instance.setValue(value);
        setSize(index);
    }

    @Override
    public V get(K key) {
        V result = null;
        int sameKeys = 0;
        int nullKeys = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null && values[i] != null) {
                nullKeys += 1;
            }
        }

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (elements[i] != null && elements[j] != null) {
                    if (elements[i].equals(elements[j]) && !(values[j].equals(values[i]))) {
                        sameKeys += 1;
                    }
                }
            }
        }
        for (int i = 0; i < elements.length; i++) {
            if (sameKeys > 1) {
                setSize(getSize() - sameKeys + 1);
                for (int j = 0; j < elements.length; j++) {
                    if (elements[j] != null) {
                        if (elements[j].equals(key)) {
                            result = (V) values[j];
                        }
                    }
                }
            } else if (elements[i] != null && key != null) {
                if (elements[i].hashCode() == key.hashCode()) {
                    result = (V) values[i];
                    break;
                }
            } else if (nullKeys > 1) {
                setSize(getSize() - nullKeys + 1);
                for (int j = elements.length - 1; j >= 0; j--) {
                    if ((K) elements[j] == key && values[j] != null) {
                        result = (V) values[j];
                        break;
                    }
                }
            } else if (key == null && elements[i] == null) {
                result = (V) values[i];
                break;
            } else if ((K) elements[i] == key) {
                result = (V) values[i];
                break;
            }
            nullKeys = 1;
            sameKeys = 1;
        }
        return result;
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(StorageImpl.class)) {
            Ka objD = new Ka();
            return Objects.equals(this.nameOfCat,objD.getName())
                    && Objects.equals(this.colorOfCat,objD.getColor());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (nameOfCat == null ? 0 : nameOfCat.hashCode());
        result = 31 * result + (colorOfCat == null ? 0 : colorOfCat.hashCode());
        return result;
    }
}
