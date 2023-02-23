package 单词分析;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.next();
        HashMap<String, Integer> map = getChar(line);
        PrintMsg(map);
        scan.close();
    }
    public static HashMap<String, Integer> getChar(String str){
        HashMap<String , Integer> map=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(String.valueOf(str.charAt(i)))){
                Integer value = map.get(String.valueOf(str.charAt(i)));
                map.put(String.valueOf(str.charAt(i)),value+1);
            }else {
                map.put(String.valueOf(str.charAt(i)),1);
            }
        }
        return map;
    }
    public static void PrintMsg(HashMap<String, Integer> map){
        Integer[] array = map.values().toArray(new Integer[0]);
        Arrays.sort(array);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), array[array.length-1])){
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                return;
            }
        }
    }
}
