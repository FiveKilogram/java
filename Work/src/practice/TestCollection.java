package practice;

import java.util.*;
import java.util.function.Predicate;

public class TestCollection {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        //int a[] = set.toArray();
       // System.out.println(set.size());
        LinkedList a =null;
        ArrayList b =null;
        Vector v = null;

        Exception e =null;

        Map map = new HashMap();
        Set s = new HashSet();

        Map map1 = new LinkedHashMap();
        Set set1 = new LinkedHashSet();

        Map map2 = new TreeMap();
        Set set2 = new TreeSet();

        set.add(4);
        set.add(8);

        //Set<Integer,map.entrySet()> set4 =
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string.isEmpty();
            }
        };

        Predicate<String> predicate1 = (String str)->{return true;};

        set.stream().filter((Integer name)->name==4).forEach(name->System.out.println(name));
    }
}