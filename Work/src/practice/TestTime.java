package practice;

import java.util.Date;
import java.util.Objects;

public class TestTime {
    //Objects.hash()
    public static void main(String[] args) {
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Date(new Date().getTime()));
    }
}
