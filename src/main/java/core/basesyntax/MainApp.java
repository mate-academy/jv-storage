package core.basesyntax;

//import core.basesyntax.Storage;
import core.basesyntax.impl.Box;
import core.basesyntax.impl.StorageImpl;

public class MainApp {

    public static void main(String[] args) {
        Storage<Integer, Box> storage = new StorageImpl<>(); // przed pętlą!
        for (int i = 0; i < 10; i++) {
            Box box = new Box();
            storage.put(22 + i, box);
        }
        Box value = storage.get(23);
        int size = storage.size();
    }
}
