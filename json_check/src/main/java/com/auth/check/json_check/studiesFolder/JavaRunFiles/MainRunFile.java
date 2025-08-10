package com.auth.check.json_check.studiesFolder.JavaRunFiles;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainRunFile {
    public static void main(String[] args) {

        fun();
        String str = "ABBCCC";
        String str1 = "A1B2C3";
        printFirstNonRepeatedCharacter("rmr");
        printFrequencyOfWords(Arrays.asList("appgen", "framework", "component", "appgen"));
        removeVal();
        printFrequency(str);
        printCharacter(str1);
    }

    static void fun() {
        double a = 6 / 4;
        int b = 6 / 4;
        double c = a + b;
        System.out.println(c);
    }
    static void printFrequency(String str) {
        String returnString = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .map(map -> map.getKey() + map.getValue()).collect(Collectors.joining());
        System.out.println(returnString);
    }

    static void printFrequencyOfWords(List<String> demoList) {
        Map<String, Long> demoMap = demoList.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(demoMap);
    }

    static void printFirstNonRepeatedCharacter(String str) {
        Optional<Character> demo = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(map -> map.getValue() <= 1).map(Map.Entry::getKey).findFirst();
        System.out.println(demo.get());
    }

    static void printCharacter(String str1) {
        String returnString = "";
        for (int i = 0; i < str1.length() - 1; i = i + 2) {
            String returnSubString = "";
            int sub = Integer.parseInt("" + str1.charAt(i + 1));
            while (sub > 0) {
                returnSubString = returnSubString + Objects.toString(str1.charAt(i));
                sub--;
            }
            returnString += returnSubString;
        }
        System.out.println(returnString);
    }

    static void removeVal() {
//        Input: nums = [0,1,2,2,3,0,4,2], val = 2
//        Output: 5, nums = [0,1,4,0,3,_,_,_]

        int[] arr = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[i] == val && arr[j] != val) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    count++;
                }
            }
        }
        System.out.println("count -> " + count);
        System.out.println("Array -> " + Arrays.toString(arr));
    }

}
