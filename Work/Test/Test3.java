import java.io.File;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        File obj = new File("/java/system");
        System.out.println(obj.getParent());
        System.out.println(" " + obj.isFile());

    }
}
