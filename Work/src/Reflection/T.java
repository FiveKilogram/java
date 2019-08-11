package Reflection;

import java.io.UnsupportedEncodingException;

public class T {
//    static {
//        System.out.println("class load");
//    }


    public T(int a) throws UnsupportedEncodingException {
        System.out.println(new String("有参数构造方法".getBytes("gbk")));
    }

    public T() throws UnsupportedEncodingException {
        System.out.println(new String("无参构造函数".getBytes("gbk")));
    }

    @Override
    public String toString() {
        return "T{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    private int a = 0;
    private int b = 9;

    public void c(){
        System.out.println("method c");
    }

    private void d(){
        System.out.println("method d");
    }
}
