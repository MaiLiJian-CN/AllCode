package Tisheng.YinZhang;

import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//印章种类数
        int m=scanner.nextInt();//买了几张印章
        double[][] dp = new double[n+1][m+1];//dp[i][j]表示买j张印章能集齐n种印章里任意i种的概率
        for(int i=1;i<=m;i++)//买了i张印章能集齐任意一种印章的概率是(1/n)^i*n=(1/n)^(i-1)
        {
            dp[1][i]=1.0;
            for(int j=1;j<i;j++)
            {
                dp[1][i]*=1.0/n;
            }
        }
        for(int i=2;i<=n;i++)
        {
            for(int j=2;j<=m;j++)
            {
                if(j<i)
                {
                    dp[i][j]=0;//如果买的数量还没需要集齐的种数多，概率就肯定是0
                }
                else
                {
                    dp[i][j]=dp[i][j-1]*(i*1.0/n)+dp[i-1][j-1]*((n-i+1)/(n*1.0));//前j-1张就集齐了i种印章的概率加上前j-1张集齐了i-1种的概率
                }
            }
        }
        System.out.printf("%.4f",dp[n][m]);
    }
}

