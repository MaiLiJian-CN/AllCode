package 相同字符串;

public class pro10_15_16 {
    public static String getRepeatStr(String str){
        //处理为空情况
        if(str==null || str.length()<1){
            return null;
        }
        //maxi:最长重复子串的起始下标，maxlen:最长重复子串的最大长度，len:当前重复子串的最大长度
        int maxi=0,maxlen=0,len=0;
        //外层循环控制这把尺子（或者说是滑动窗口）的大小，取值从1开始到str.length-1
        for(int i=1;i<str.length();i++){
            //内层循环遍历该字符串
            for(int j=0;j<str.length()-i;j++){
                //每次只比较尺子两端的字符是否相等，相等当前len++，否则len清0
                if(str.charAt(j)==str.charAt(i+j)){
                    len++;
                } else {
                    len=0;
                }
                /*
                 * 每次比较完毕都要进行更新最长重复子串的长度以及最长子串的起始下标
                 * 为什么不放在上面的else内进行处理？
                 * 原因如下：又可以在某一个尺子长度下回一直相等下去直到当前的内层循环结束，而此时len的值已经改变，而在下一次的遍历内层循环时 j 回被重新赋值为 0 ，此时再去比较尺子两边的字符时，如果不相等，那么在计算 maxi 时，由于此时 j 已经为0，因此得到的 maxi 为负数，此时就出现问题了。因此每次进行内层循环都应该对maxlen以及maxi进行更新。
                 */
                if(len>maxlen){
                    maxlen=len;
                    maxi=j-len+1;
                }
            }
        }
        //这里的条件是>0当然，也可以写!=0都是可以的
        if(maxlen>0){
            //输出字符串长度
            System.out.println(maxlen);
            //输出最长重复子串
            return str.substring(maxi,maxlen);
        }
        return null;
    }
    public static void main(String[] args) {
        String str="abcdabcdabcd";
        System.out.println(getRepeatStr(str));
    }
}