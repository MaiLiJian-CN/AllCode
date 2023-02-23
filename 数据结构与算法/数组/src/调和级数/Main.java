package 调和级数;

public class Main {
    public static void main(String[] args) {
        int i=1;
        double rs=0;
        while (true){
            for (int j = 1; j <=i; j++) {
                rs+=1.0/j;
            }
            System.out.println(rs);
            if (rs>12){
                break;
            }else {
                i++;
                rs=0;
            }

        }
        System.out.println(i);

    }
}
