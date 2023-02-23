package 栈;

import sun.util.resources.LocaleData;

import java.util.*;

public class PoLangStack {
    public static void main(String[] args) {
        String str="1+((2+3)*4)-5";
        List<String> stringList = toInfixExpressionList(str);
        System.out.println("中缀:"+stringList);
        List<String> list = parseSuffixExpressionList(stringList);
        System.out.println("后缀:"+list);
        int calculate = calculate(list);
        System.out.println(calculate);
    }

    private static List<String> parseSuffixExpressionList(List<String> stringList) {
        Stack<String> str=new Stack<>();
        List<String> list=new ArrayList<>();

        for (String s : stringList) {
            if (s.matches("\\d+")){
                list.add(s);
            }else if (s.equals("(")){
                str.push(s);
            }else if (s.equals(")")){
                while (!str.peek().equals("(")){
                    list.add(str.pop());
                }
                str.pop();
            }else {
                while (str.size()!=0&&(!str.peek().equals("("))&&thanOperation(str.peek())>=thanOperation(s)){
                     list.add(str.pop());
                }
                str.push(s);
            }
        }
        while (str.size()!=0) list.add(str.pop());
        return list;
    }

    private static Integer thanOperation(String s){
        switch (s){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:throw new RuntimeException("符号出错：ERROR"+s);
        }
    }

    private static List<String> toInfixExpressionList(String s) {
        List<String> list=new ArrayList<>();
        StringBuilder str;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c=s.charAt(i);
            if (!Character.isDigit(c)){
                list.add(String.valueOf(c));
            }else {
                int j=i;
                str=new StringBuilder();
                while ((c=s.charAt(j))>=48&&(c=s.charAt(j))<=57){
                    str.append(c);
                    if (j==s.length()-1) break;
                    j++;
                }
                list.add(String.valueOf(str));
            }
        }
        return list;
    }

    private static int calculate(List<String> list) {
        Stack<String> stack=new Stack<>();
        int num1=0;
        int num2=0;
        int res=0;
        for (String s : list) {
            if (s.matches("\\d+")){
                stack.push(s);
            }else {
                num1=Integer.parseInt(stack.pop());
                num2=Integer.parseInt(stack.pop());
                if (s.equals("+")){
                    res=num1+num2;
                }else if (s.equals("-")){
                    res=num2-num1;
                }else if (s.equals("*")){
                    res=num1*num2;
                }else if (s.equals("/")){
                    res=num2/num1;
                }else {
                    throw new RuntimeException("error");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static List<String> StrOfList(String str) {
        String[] split = str.split(" ");
        return new ArrayList<>(Arrays.asList(split));
    }
}
