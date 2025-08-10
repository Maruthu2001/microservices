package com.auth.check.json_check.utils;

public class CommonUtils {

    private class RunnableImpl implements Runnable {
        // Overriding the run Method
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", executing run() method!");
        }
    }

    // Main Method
    public static void main(String[] args) {
        System.out.println("Main thread is: " + Thread.currentThread().getName());

        // Creating Thread
        Thread t1 = new Thread(new CommonUtils().new RunnableImpl());

        // Executing the Thread
        t1.start();
        int j = Integer.MAX_VALUE;
        System.out.println(j);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0; // Slow pointer (tracks last unique element)

        for (int j = 1; j < nums.length; j++) { // Fast pointer (scans array)
            if (nums[j] != nums[i]) { // New unique element found
                i++; // Move slow pointer
                nums[i] = nums[j]; // Overwrite duplicate with new unique
            }
        }

        return i + 1; // Number of unique elements
    }
    
    public void addTwoNumber(int []l1, int[] l2) {
        StringBuilder subString = new StringBuilder().reverse();
        subString.reverse().toString();
        
    }

}
