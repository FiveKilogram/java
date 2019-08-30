import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Collection {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("name","tom");
        map.put("sex","male");
        map.put("address","bejjing");
        System.out.println(map.get("name"));
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry.getKey() + "------" + entry.getValue());
        }

        for (String string:map.keySet()) {
            System.out.println(string);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        System.out.println(arrayList.size());
    }
}
