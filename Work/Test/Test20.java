import java.util.*;

public class Test20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Map<Character,Integer> map = new HashMap();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(c==' ')
                continue;
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }

        int max = 0;
        for (Map.Entry<Character,Integer> me:map.entrySet()) {
            if(me.getValue()>max){
                max = me.getValue();
            }
        }

        List list = new LinkedList();
        //list.

        //System.out.println(max);

    }
}
