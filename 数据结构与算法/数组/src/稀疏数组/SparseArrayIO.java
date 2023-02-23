package 稀疏数组;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SparseArrayIO {
    public static void main(String[] args) {
        try {
            /*创建原数组
            * 创建稀疏数组*/
            int[][] chessArr1=new int[10][10];
            chessArr1[1][2]=5;
            chessArr1[2][3]=10;
            chessArr1[3][4]=15;
            for (int[] ints : chessArr1) {
                for (int anInt : ints) {
                    System.out.printf("%d\t",anInt);
                }
                System.out.println();
            }

            int sum=0;
            int count=1;
            for (int[] arr : chessArr1) {
                for (int num : arr) {
                    if (num!=0){
                        sum++;
                    }
                }
            }
            int[][] sparseArray=new int[sum+1][3];
            sparseArray[0][0]=chessArr1.length;
            sparseArray[0][1]=chessArr1[0].length;
            sparseArray[0][2]=sum;
            for (int i = 0; i < chessArr1.length; i++) {
                for (int j = 0; j < chessArr1[i].length; j++) {
                    if (chessArr1[i][j]!=0){
                        sparseArray[count][0]=i;
                        sparseArray[count][1]=j;
                        sparseArray[count][2]=chessArr1[i][j];
                        count++;
                    }
                }
            }
            /*创建文件
             * 构造输入流
             * 构建输入对象*/
            File file=new File("data.txt");
            FileOutputStream outputStream=new FileOutputStream(file);
            OutputStreamWriter writer=new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            for (int[] arr : sparseArray) {
                for (int num : arr) {
                    writer.append(String.valueOf(num));
                    writer.append("\t");
                }
                writer.append("\n");
            }
            writer.close();
            outputStream.close();

            /*读取文件
             * 构造输成流
             * 构建输出对象*/
            FileInputStream inputStream=new FileInputStream(file);
            InputStreamReader input=new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            StringBuilder stringBuilder=new StringBuilder();
            while (input.ready()){
                stringBuilder.append((char) input.read());
            }
            input.close();
            inputStream.close();
            System.out.println(stringBuilder);
            int[][] sparseArray2=new int[sum+1][3];
            String[] strings = stringBuilder.toString().trim().split("\n");

            for (int i = 0; i < strings.length; i++) {
                String[] split1 = strings[i].split("\t");
                for (int j = 0; j < sparseArray2[i].length; j++) {
                    sparseArray2[i][j]= Integer.parseInt(split1[j]);
                }
            }

            /*通过稀疏数组还原数组*/
            int[][] chessArr2=new int[sparseArray2[0][0]][sparseArray2[0][1]];
            for (int i = 1; i < sparseArray2.length; i++) {
                chessArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
            }
            for (int[] ints : chessArr2) {
                for (int anInt : ints) {
                    System.out.printf("%d\t",anInt);
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
