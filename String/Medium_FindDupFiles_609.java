package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium_FindDupFiles_609 {
    public static void main(String[] args){
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }
    public static List<List<String>> findDuplicate(String[] paths) {
        if(paths == null || paths.length == 0){
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> list;
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String path: paths){

            String[] strs = path.split("\\s+");
            String start = strs[0];
            for(String str: strs){
                if(str.contains("(")){
                    StringBuilder temp = new StringBuilder();
                    temp.append(start);
                    String substr = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
                    temp.append("/");
                    temp.append(str, 0, str.indexOf("("));
                    list = map.getOrDefault(substr, new ArrayList<>());
                    list.add(temp.toString());
                    map.put(substr, list);
                }
            }
        }
        for(String key: map.keySet()){
            if(map.get(key).size() > 1){
                res.add(map.get(key));
            }
        }

        return res;
    }

}
