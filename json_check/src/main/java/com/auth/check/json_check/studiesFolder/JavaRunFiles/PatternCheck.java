package com.auth.check.json_check.studiesFolder.JavaRunFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PatternCheck {

    public static void main(String[] args) {
//        String s = "zoomlazapzo";
//        String p = "oza";
        printPatter(5);
        String s = "timetopractice";
        String p = "toc";
        
        
        int m = s.length();
        int n = p.length();
        List<String> subStringList = new ArrayList<>();
        String smallest = s;
        for (int i = 0; i < m; i++) {
            for (int j = n + i; j < m; j++) {
                String subString = s.substring(i, j + 1);
                if (getCheck(subString, p))
                    subStringList.add(subString);
            }
        }
        for (String sub : subStringList) {
            if (sub.length() < smallest.length()) {
                smallest = sub;
            }
        }

        System.out.println(smallest);
    }

    static boolean getCheck(String subString, String p) {
        Map<String, Long> pMap = Arrays.stream(p.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> subStringMap = Arrays.stream(subString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Entry<String, Long> checkMap : pMap.entrySet()) {
            String key = checkMap.getKey();
            if (!subStringMap.containsKey(key) || subStringMap.get(key) != checkMap.getValue()) {
                return false;
            }
        }

        return true;
    }
    
    static void printPatter(int rows) {
        int currentNumber = 1; // Starts with 1

        for (int i = 1; i <= rows; i++) {
            for (int s = 0; s < (rows - i); s++) {
                System.out.print("   ");
            }
            int startOfRowNumber = currentNumber + i - 1;
            for (int j = 0; j < i; j++) {
                System.out.printf("%3d", startOfRowNumber);
                startOfRowNumber--;
            }
            System.out.println();
            currentNumber += i;
        }
    }

//    while (true) {
//        if (subCounter > s.length()) {
//            counter = 0;
//            subCounter = n + 1;
//            System.out.println("inside");
//        }
//        String subString = s.substring(counter, subCounter);
//        if (getCheck(subString, p)) {
//            subStringList.add(subString);
//        } else {
//            counter++;
//            subCounter++;
//        }
//        System.out.println(subString);
//        if (subString.equals(s))
//            break;
//    }
//    System.out.println(subStringList);
//    String smallest = s;
//    for (String sub : subStringList) {
//        if (sub.length() < smallest.length()) {
//            smallest = sub;
//        }
//    }
}
