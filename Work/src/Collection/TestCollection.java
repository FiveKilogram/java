package Collection;

import java.util.*;

public class TestCollection {


    public static void main(String[] args) {

        Set set = new HashSet();
        List list = new LinkedList();
        List list1 = new ArrayList();

        Stack stack = new Stack();



        Collection collection = new LinkedList();
        HashMap<Integer,Integer> hashMap = new LinkedHashMap(5,(float) 0.75,true);
        hashMap.put(3,3);
        hashMap.put(4,4);
        hashMap.put(5,5);
        hashMap.put(7,5);
        hashMap.put(1,5);
        hashMap.put(8,5);
        hashMap.put(0,5);

        hashMap.get(1);
        hashMap.get(5);
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
    }
}
