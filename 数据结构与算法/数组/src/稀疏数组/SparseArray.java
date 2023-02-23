package 稀疏数组;

public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr1 =new int[11][11];
        int sum=0;
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
                if (anInt!=0) sum++;
            }
            System.out.println();
        }
        int[][] sparseArray =new int[sum+1][3];
        sparseArray[0][0]=chessArr1.length;
        sparseArray[0][1]=chessArr1[0].length;
        sparseArray[0][2]=sum;
        int count=0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArr1[i][j];
                }
            }
        }

        int[][] chessArr2=new int[sparseArray[0][0]][sparseArray[0][1]];
        System.out.println("=======================================");
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }

        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
                if (anInt!=0) sum++;
            }
            System.out.println();
        }


    }
}
