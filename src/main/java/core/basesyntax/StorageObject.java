package core.basesyntax;

public class StorageObject<K, V> {
    private final K key;
    private final V value;

    public StorageObject(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object storageObject) {
        if (storageObject == this) {
            return true;
        }
        if (storageObject == null) {
            return false;
        }
        if (storageObject.getClass().equals(StorageObject.class)) {
            StorageObject current = (StorageObject) storageObject;
            boolean keyEquals = (this.key == null && current.key == null)
                    || (this.key != null && this.key.equals(current.key));
            boolean valueEquals = (this.value == null && current.value == null)
                    || (this.value != null && this.value.equals(current.value));
            return keyEquals && valueEquals;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (key == null ? 0 : key.hashCode());
        result = 31 * result + (value == null ? 0 : value.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "{" + "key="
                + key + ", value="
                + value + '}';
    }
}
