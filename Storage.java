import java.util.HashMap;
import java.util.Map;

public class Storage<Integer, String> {
    Map<Integer, String> storage = new HashMap<>();
    private Integer key;
    private String value;
    public Storage() {
        this.key = key;
        this.value = value;
    }
    public void put(Integer key , String value){
        storage.put(key, value);
    }
    public String get(Integer key){
        return storage.get(key);
    }
    public int size(){
       return storage.size();
    }
    public Integer getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
}
