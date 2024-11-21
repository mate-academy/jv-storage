import javax.management.StringValueExp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Storage<Integer, String> storage = new Storage<>();
        storage.put(21, "lebratik");
        storage.put(22, "lee");
        String value = storage.get(22);
        int size = storage.size();
        System.out.println(value + size);
    }
    }
