import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl<>();

        storage.put(22, "sss");
        String value = storage.get(22); // returns the "sss"
        int size = storage.size(); // returns storage size
    }
}
