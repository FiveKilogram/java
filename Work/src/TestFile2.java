import practice.TestFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFile2 {
    public static void main(String[] args) {
        System.out.println(TestFile2.class.getResource("").getPath());
        System.out.println(System.getProperty("user.dir"));

        System.out.println(TestFile2.class.getClassLoader().getResource("").getPath());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(TestFile2.class.getResource("test.txt"));

        File directory = new File("");//参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(courseFile);


            try {

                FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
                try {
                    fileOutputStream.write("2cccc33333c444444".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }

}
