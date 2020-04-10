import java.io.File;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        File obj = new File("/java/system");
        System.out.println(obj.getParent());
        System.out.println(" " + obj.isFile());

        String str = "ttttt";
        String str2 = new String("ttttt");
        String str3 = new String(str2);

        System.out.println(str.equals(str2));
        System.out.println(str2==str3);
    }
}
