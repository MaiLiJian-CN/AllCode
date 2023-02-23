package 异或;

public class Main {
    public static void main(String[] args) {
        two();
    }
    public static void one(){
        int[] arr={1,2,3,2,3,2,1};
        int ero=0;
        for (int i : arr) {
            ero=ero^i;
        }
        System.out.println(ero);
    }
    public static void two(){
        int[] arr={11,22,33,44,55,11,22,33};
        int ero=0;
        int onlyOne=0;
        for (int i : arr) {
            ero=ero^i;
        }
        int rightOne=ero^(-ero+1);
        for (int i : arr) {
            if ((i&rightOne)==0){
                onlyOne^=i;
            }
        }
        System.out.println(onlyOne+" "+(ero^onlyOne));
    }
}
