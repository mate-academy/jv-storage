import core.basesyntax.Storage;
import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        String string = "okey";
        String stringTwo = "bingo";
        String stringThree = "cool";

        Storage<Integer, String> storage = new StorageImpl<>();
        storage.put(1, string);
        storage.put(2, stringTwo);
        storage.put(3, stringThree);

        String value = storage.get(3);
        System.out.println(value);
        int size = storage.size();
        System.out.println(size);

    }
}
