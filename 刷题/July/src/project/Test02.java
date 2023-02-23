package project;
/*
* 题目
有效 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是无效 IP 地址。
给定一个字符串 s，非数字的字符可替换为任意不包含在本字符串的数字，同样的字符只能替换为同样的数字，用以表示一个 IP 地址，
* 返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字，你可以按任何顺序返回答案。
* 20212118136
* 11a2b22a037
*/
/*
* 最少4个数
* 最多12位数
* */
public class Test02 {
    public static void main(String[] args) {
        changNm("20212118136");
    }

    public static int changNm(String str){
        if (str.length()>12||str.length()<4) return -1;
        char[] chars=new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i]=str.charAt(i);
        }

        return 0;
    }
}
