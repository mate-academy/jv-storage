import static java.lang.StringLatin1.indexOf;

public interface Storage {
    @Override
    public void put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) {
            values[index] = value; // Replace value if key already exists
        } else {
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                throw new IllegalStateException("Storage is full");
            }
        }
    }
}
