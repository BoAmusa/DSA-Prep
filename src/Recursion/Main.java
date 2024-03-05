package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] candidates = {2, 5, 2, 1, 2};
       

    }

    static int decimalToBinary(int num) {
        if (num == 0) return num;
        return num % 2 + 10 * decimalToBinary(num / 2);
    }

    static int gcd(int numA, int numB) {
        if (numA < 0 || numB < 0) {
            return -1;
        }
        if (numB == 0) {
            return numA;
        }

        return gcd(numB, numA % numB);
    }

    static int powerIterative(int n, int exp) {
        int count = 0;
        int sum = 1;
        while (count < exp) {
            sum *= n;
            count++;
        }

        return sum;
    }

    static int toNthPower(int base, int exp) {
        if (exp < 0 || base < 0) return -1;
        if (exp == 0) return 1;

        return base * toNthPower(base, exp - 1);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) return 0;

        return n % 10 + sumOfDigits(n / 10);
    }

    public static int factorial(int n) {
        if (n == 1) return 1;

        return factorial(n - 1) * n;
    }

    public static int fibonacci(int n) {
        if (n < 0) return -1;

        if (n <= 2) {
            return 1;
        }

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    static void recursiveMethod(int n) {
        if (n == 0) {
            System.out.println("Finished");
        } else {
            recursiveMethod(n - 1);
            System.out.println("Num " + n);
        }
    }

    public static String reverse(String str) {
        if (str.isEmpty())
            return str;
        String s = reverse(str.substring(1)) + str.charAt(0);
        //Calling Function Recursively
        return s;
    }

    static char first(String str) {
        if (str.isEmpty()) return ' ';
        char letter = str.charAt(0);
        if (Character.isUpperCase(letter)) {
            return letter;
        }

        return first(str.substring(1));
    }

    public static String capitalizeWord(String str) {
        int len = str.length();
        StringBuilder captilizedStr = new StringBuilder();

        if (len == 0) return str;
        if (len == 1) return "" + Character.toUpperCase(str.charAt(0));

        String[] wordArr = str.split(" ");
        int count = 0;
        while (count < wordArr.length) {
            String temp = wordArr[count];
            if (count == wordArr.length - 1) {
                captilizedStr.append(Character.toUpperCase(temp.charAt(0)) + temp.substring(1));
            } else {
                captilizedStr.append(Character.toUpperCase(temp.charAt(0)) + temp.substring(1).toLowerCase() + " ");
            }

            count++;
        }
        return captilizedStr.toString();
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        Backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private static void Backtrack(List<List<Integer>> results, List<Integer> tempList, int[] candidates, int target,
                                  int index) {
        if (target < 0)
            return;
        if (target == 0) {
            results.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            tempList.add(candidates[i]);
            Backtrack(results, tempList, candidates, target - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);

        }
    }
}
