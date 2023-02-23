package SbTest;

import java.util.ArrayList;

public class ArrTest {
    public static void main(String[] args) {
        ArrayList<Object> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add(0,0);
        System.out.println(arr);
    }

}
