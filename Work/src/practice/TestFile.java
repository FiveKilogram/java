package practice;

import java.io.*;

public class TestFile {
    public static void main(String[] args) {
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("Work\\src\\test.txt");
            try {
                byte[] b2 = "我的vfdsvfdv".getBytes("gbk");//指定编码
                fileOutputStream.write(b2);
            } catch (IOException e) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }


        try {
            //FileInputStream fileInputStream = new FileInputStream("Work\\src\\test.txt");
            FileReader fileReader = new FileReader("Work\\src\\test.txt");

            char b[] = new char[1024];
            while(true){
                try {
                    int a = fileReader.read(b);
                    if (a<0) break;
                    System.out.print(new String(b));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
