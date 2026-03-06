import core.basesyntax.Storage;
import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String [] args) {
        Storage<Integer, String> storage = new StorageImpl<>();
        storage.put(null, "One");
        storage.put(null, "Three");
        System.out.println(storage.size());
        System.out.println(storage.get(1));
        System.out.println(storage.get(null));

        System.out.println(storage.get(99));

        for (int i = 3; i <= 10; i++) {
            storage.put(i, "Value" + i);
        }

        try {
            storage.put(11, "Overflow");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }
}
