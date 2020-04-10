import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution extends LinkedHashMap<Integer,Integer>{
    private final int Max;


    public Solution(int capacity) {
        super(capacity,(float)0.75,true);
        Max = capacity;
    }

    public int get(int key) {
        if(super.get(key)==null)
            return -1;
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>Max;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


    public String getMinVersion(String[] list) {
        // 在这里编写代码

        String result = "";

        int maxLen = 0;
        for (int i = 0; i < list.length; i++) {
            if(list[i].split(".").length>maxLen){
                maxLen = list[i].split(".").length;
            }
        }

        String str[][] = new String[list.length][maxLen];
        for (int i = 0; i < list.length; i++) {
            String str2[] = list[i].split(".");
            for (int j = 0; j < maxLen; j++) {
                if(j<str2.length){
                    str[i][j] = str2[j];
                }else {
                    str[i][j] = "";
                }
            }
        }

        List list1 = new LinkedList();



        return result;
    }


    /**
     * 3, 4.3.5.4, 2.10.3, 2.4
     */


}