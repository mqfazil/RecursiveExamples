import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String inputString = "0001000abcdef586485975324654 6543654465465465654zxjuf;gmlvnsrutmg;oisauit'pmvsaiaism'gtfoisa'iretpkyi9[-w0595768681687 +ias;fmpoiujasldjfmasd;f574697612000006800000";
        System.out.println(countDecimals(inputString));

        // Examples of using the recursive methods
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("5th Fibonacci number: " + fibonacci(5));
        System.out.println("Number of zeros in 1005: " + numberOfZeros(1005));
        System.out.print("987 in words: ");
        inWords(987);
        System.out.println();

        int[] array = {5, 7, 9, 13, 32, 33, 42, 54, 56, 88};
        System.out.println("Binary Search for 33: " + binarySearch(33, array, 0, array.length - 1));

        int[] unsortedArray = {3, 6, 8, 2, 5, 4, 7, 1};
        mergeSort(unsortedArray);
        System.out.println("Merge Sorted Array: " + Arrays.toString(unsortedArray));
    }

    public static int countDecimals(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char firstChar = str.charAt(0);
        boolean isDigit = firstChar >= '0' && firstChar <= '9';
        int count = isDigit ? 1 : 0;
        return count + countDecimals(str.substring(1));
    }

    // Factorial method
    public static int factorial(int n) {
        if (n > 1) {
            return factorial(n - 1) * n;
        } else {
            return 1;
        }
    }

    // Fibonacci method
    public static int fibonacci(int n) {
        if (n > 2) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else if (n == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    // Number of zeros method
    public static int numberOfZeros(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 10) {
            return 0;
        } else {
            return (n % 10 == 0 ? 1 : 0) + numberOfZeros(n / 10);
        }
    }

    // Numbers to words method
    public static void inWords(int numeral) {
        if (numeral < 10) {
            System.out.print(digitWord(numeral) + " ");
        } else {
            inWords(numeral / 10);
            System.out.print(digitWord(numeral % 10) + " ");
        }
    }
    private static String digitWord(int digit) {
        // Convert a single digit to its word representation
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        return words[digit];
    }

    // Binary Search method
    public static int binarySearch(int target, int[] a, int first, int last) {
        if (first <= last) {
            int mid = (first + last) / 2;
            if (target == a[mid]) {
                return mid;
            } else if (target < a[mid]) {
                return binarySearch(target, a, first, mid - 1);
            } else {
                return binarySearch(target, a, mid + 1, last);
            }
        } else {
            return -1; // Not found
        }
    }

    // Merge Sort method
    public static void mergeSort(int[] a) {
        if (a.length >= 2) {
            int halfLength = a.length / 2;
            int[] front = new int[halfLength];
            int[] tail = new int[a.length - halfLength];
            System.arraycopy(a, 0, front, 0, halfLength);
            System.arraycopy(a, halfLength, tail, 0, a.length - halfLength);
            mergeSort(front);
            mergeSort(tail);
            merge(a, front, tail);
        }
    }
    private static void merge(int[] a, int[] front, int[] tail) {
        int i = 0, j = 0, k = 0;
        while (i < front.length && j < tail.length) {
            if (front[i] <= tail[j]) {
                a[k++] = front[i++];
            } else {
                a[k++] = tail[j++];
            }
        }
    }
}