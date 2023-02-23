package 递增序列;

public class Main {

    public static void main(String[] args) {
        String str="LANN\n" + "QIAO";
        String[] split = str.split("\n");
        int i = getFor(split);
        System.out.println(i);
    }

    public static int get(String[] arr,int i,int rs){
        int j=0;
        String str = arr[i];
        for (int k = 0; k < str.length(); k++) {
            for (int l = 0; l < str.length(); l++) {
                if (j!=0&&i!=arr.length-1){
                    if (str.charAt(j)<arr[i+1].charAt(j-1)){
                        rs++;
                    }
                    break;
                }
                if (j!=0&&i!=0){
                    if (str.charAt(j)<arr[i-1].charAt(j-1)){
                        rs++;
                    }
                    break;
                }
                if (j!= arr[arr.length-1].length()-1&&i!= arr.length-1){
                    if (str.charAt(j)<arr[i+1].charAt(j+1)){
                        rs++;
                    }
                    break;
                }
                if (j!= arr[arr.length-1].length()-1&&i!= 0){
                    if (str.charAt(j)<arr[i-1].charAt(j+1)){
                        rs++;}
                    break;
                }
                if (str.charAt(j)<str.charAt(l)){
                    rs++;
                }
            }
            j++;
        }
        return rs;
    }
    public static int getFor(String[] arr){
        int rs=0;
        for (int i = 0; i < arr.length; i++) {
            rs+=get(arr,i,0);
        }
        return rs;
    }
}
