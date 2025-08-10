package com.auth.check.json_check.studiesFolder.JavaRunFiles;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.core.DefaultParameterNameDiscoverer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BasicJavaFile {

    private static Map<String, Class<?>> primitiveDataMap = new HashMap<>();

    public static void main(String[] args) {
        
        
        printPattern(5);
        ManualStack st = new ManualStack();

        // Push elements onto the stack
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);

        // Print top element of the stack
        System.out.println("Top element is " + st.peek());

        // removing two elemements from the top
        System.out.println("Removing two elements...");
        st.pop();
        st.pop();

        // Print top element of the stack
        System.out.println("Top element is " + st.peek());
        
        
        
        // First linked list: 5 -> 10 -> 15
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);

        // Second linked list: 2 -> 3 -> 20
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        Node newNode = mergeSortList(head1, head2);
        while(newNode != null) {
            System.out.println(newNode.data);
            newNode = newNode.next;
        }
//        commonElements(new int[] { 1, 5, 10, 20, 30 }, new int[] { 5, 13, 15, 20 }, new int[] { 5, 20 });
//        maxWater(new int[] { 3, 0, 1, 0, 4, 0, 2 });
//        String demo = "name";
//        
//        System.out.println(Objects.toString(demo));
//        
//        callThreadMethod();
//        
//        int secondLargest = Arrays.asList(7,8,4,2,1,3).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
//        
//        List<String> stringList = Arrays.asList("");
//        
//        System.out.println(secondLargest);
//
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("packageName", "com.auth.check.json_check.configs.interceptors.HandlerIntercept");
//        paramMap.put("dataType", "int");
//        BasicJavaFile bs = new BasicJavaFile();
//        bs.getSuggestions(paramMap);
//        getObjectData();
//       
//        System.out.println(getSmallestAndLargest("welcometojava", 3));
//
//        Object ss = Optional.ofNullable(null).orElse("dd");
//        System.out.println(ss);
//
//        Map<String, Object> demoMap = new HashMap<>();
//        demoMap.put("demo", "DDDDD");
//
//        List<Map<String, Object>> demoList = new ArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//            demoList.add(demoMap);
//        }
    }

    static Node mergeSortList(Node l1, Node l2) {
        List<Integer> dummyList = new ArrayList<>();
        while (l1 != null) {
            dummyList.add(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            dummyList.add(l2.data);
            l2 = l2.next;
        }
        Collections.sort(dummyList);
        Node dummyNode = new Node(-1);
        Node newNode = dummyNode;
        for(int i: dummyList) {
            dummyNode.next = new Node(i);
            dummyNode = dummyNode.next;
        }
        return newNode;
    }

    private static void commonElements(int[] arr, int[] arr1, int[] arr2) {
        int arrSize = arr.length;
        int arr1Size = arr1.length;
        int arr2Size = arr2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrSize; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr1Size; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < arr2Size; i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }
        List<Integer> arrList = map.entrySet().stream().filter(predicate -> predicate.getValue() == 3)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(arrList);
    }

    static void maxWater(int[] arr) {
        int res = 0;

        // For every element of the array
        for (int i = 1; i < arr.length - 1; i++) {

            // Find the maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++)
                left = Math.max(left, arr[j]);

            // Find the maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < arr.length; j++)
                right = Math.max(right, arr[j]);
            System.out.println("left ->" + left + " Right ->" + right);
            // Update the maximum water
            res += Math.min(left, right) - arr[i];
        }

        System.out.println(res);
    }

    private static void callThreadMethod() {
        AtomicInteger amount = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            amount.getAndIncrement();
        });
        Thread t2 = new Thread(() -> {
            amount.getAndIncrement();
        });
        t1.start();
        t2.start();
        System.out.println(amount);
        t1.stop();
        t2.stop();
    }

    // Without type reference
    public static void getObjectData() {
        ObjectMapper mapper = new ObjectMapper();
        String nameMap = "{\"name\": \"Dinesh\", \"role\": \"Developer\"}";
        try {
            Object obj = mapper.readValue(nameMap, Map.class);
            if (obj instanceof List) {
                System.out.println(new ArrayList<>((List) obj));
            } else if (obj instanceof Map) {
                System.out.println(new HashMap<>((Map) obj));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // With Type reference
    public static void getObjectData1() {
        ObjectMapper mapper = new ObjectMapper();
        String nameMap = "{\"name\": \"Dinesh\", \"role\": \"Developer\"}";
    }

    public List<Map<String, Object>> getSuggestions(Map<String, Object> paramMap) {
        try {
            List<Map<String, Object>> resultList;
            String keyword = paramMap.get("dataType").toString();
            primitiveDataMap = constructPrimitiveDataMap();
            Class<?> className = getCurrentClass(keyword, paramMap);
            List<Map<String, Object>> methodJsonArray = new ArrayList<>();
            Boolean packageFlag = paramMap.containsKey("packageName");
            getMethodNamesAsList(className.getDeclaredMethods(), methodJsonArray, keyword, packageFlag);
            resultList = methodJsonArray.stream().sorted((input1, input2) -> input1.keySet().stream().findFirst().get()
                    .compareTo(input2.keySet().stream().findFirst().get())).collect(Collectors.toList());
            System.out.println(resultList);
            return resultList;
        } catch (Exception exception) {
            return Collections.emptyList();
        }
    }

    private Class<?> getCurrentClass(String keyword, Map<String, Object> paramMap) {
        String packageName = Objects.toString(paramMap.get("packageName"),
                "com.auth.check.json_check.configs.interceptors");
        Class<?> clName = null;
        try {
            clName = Class.forName(packageName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clName;
    }

    private Map<String, Class<?>> constructPrimitiveDataMap() {
        Map<String, Class<?>> dataMap = new HashMap<>();
        dataMap.put("int", int.class);
        dataMap.put("char", char.class);
        dataMap.put("boolean", boolean.class);
        dataMap.put("byte", byte.class);
        dataMap.put("short", short.class);
        dataMap.put("long", long.class);
        dataMap.put("float", float.class);
        dataMap.put("double", double.class);
        return dataMap;
    }

    public List<Map<String, String>> getMethodNamesAsList(Method[] methods, List<Map<String, Object>> methodJsonArray,
            String keyword, Boolean packageFlag) {
        if (Objects.isNull(methods)) {
            return Collections.emptyList();
        }
        return Arrays.stream(methods).filter(predicate -> Modifier.isPublic(predicate.getModifiers())
                || Modifier.isProtected(predicate.getModifiers())).map(method -> {
                    Map<String, Object> methodDetails = new HashMap<>();
                    DefaultParameterNameDiscoverer discover = new DefaultParameterNameDiscoverer();
                    String[] paramNames = discover.getParameterNames(method);
                    String methodSuggestion = new StringBuilder(method.getName()).append("(").append("").append(")")
                            .toString();
                    Map<String, String> detailMap = new HashMap<>();
                    methodDetails.put("methodName", method.getName());
                    methodDetails.put("returnType", method.getReturnType().getSimpleName());
                    methodDetails.put("keyName", methodSuggestion);
//                    methodDetails.put("deprecatedFlag", method.isAnnotationPresent(Deprecated.class));
                    detailMap.put(methodSuggestion, method.getReturnType().getSimpleName());
                    methodJsonArray.add(Collections.singletonMap(method.getName(), methodDetails));
                    return detailMap;
                }).collect(Collectors.toList());
    }

    private static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        for (int i = 1; i <= s.length() - k; i++) {
            String currentSubstring = s.substring(i, i + k);
            if (currentSubstring.compareTo(smallest) < 0) {
                smallest = currentSubstring;
            }
            if (currentSubstring.compareTo(largest) > 0) {
                largest = currentSubstring;
            }
        }
        return smallest + "\n" + largest;
    }
    
    static void printPattern(int num) {
        for(int i =1;i<=num;i++) {
            for(int k = num;k>i;k--) {
                System.out.print(" ");
            }
            for(int j =0 ;j<i;j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
