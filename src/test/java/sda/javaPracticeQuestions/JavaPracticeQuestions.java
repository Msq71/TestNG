package sda.javaPracticeQuestions;

public class JavaPracticeQuestions {
    public static void main(String[] args) {
        System.out.println("reverseString = " + reverseString("Hello"));
        System.out.println("-----------------------------------------");
        swapNumbers(3, 9);
        System.out.println("-----------------------------------------");
        System.out.println("fibonacciNumber(5) = " + fibonacciNumber(5));
    }

    // 1.Write a java program to reverse a string.
    public static String reverseString(String String) {
        String result = "";
        for (int i = String.length() - 1; i >= 0; i--) {
            result += String.charAt(i);
        }
        return result;
    }

    // 2.Write a java program to swap two numbers.
    public static void swapNumbers(int a, int b) {
        System.out.println("before swap");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("after swap");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    // 3.Write a Java Program that prints fibonacci number due to given integer (11235811...).
    public static String fibonacciNumber(int digit) {
        if (digit > 100) {
            System.out.println("please enter a number less than a 100");
            return "";
        }
        if (digit < 1) {
            System.out.println("please enter a positive digit");
            return "";
        }

        int first = 1;
        int second = 1;
        int temp = 0;
        String result = first + "" + second;
        for (int i = 2; i < digit; i++) {
            temp = first + second;
            result += temp;
            first = second;
            second = temp;
        }

        return result;
    }

    //4. Write a Java Program that checks whether given integer is Prime or not
    public static boolean isPrime(int a){
        if (a <= 1)
            return false;
        if (a % 2 == 0)
            return false;
        return true;
    }


    //5. Write a Java Program that takes an array and returns the difference between the biggest and the smallest numbers.
}
