import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        getArithmeticException(2,0);
        getIOException("missing.file");
        getErrors(-99,6999999);

        int[][] x = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4},{1,2,3},{1,2,3,4,5}};
        for (var y:x) {
            System.out.println(Arrays.toString(y));
        }
        System.out.println(isCorrect(x));
    }
    // Задача 1
    public static void getArithmeticException(int x, int y) {
        try {
            System.out.println(x/y);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void getIOException(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)){
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getErrors(int min, int max) {
        try {
            max -= min;
            int randomIndex = (int)(Math.random() * ++max) + min;
            int[] err = new int[randomIndex];
            getErrors(min, max);
        } catch (StackOverflowError | OutOfMemoryError | NegativeArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
    // Задача 2
    public static int[] subtractionArray(int[] first, int[] second) {
        if (isCorrectArrays(first,second)) {
            int[] result = new int[first.length];
            for (int i = 0; i < first.length; i++) {
                if (first[i] - second[i] != (long)first[i] - second[i]) {
                    try {
                        throw new RuntimeException("result cannot be put in int");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                result[i] = first[i] - second[i];
            }
            return result;
        }
        return null;
    }
    // Задача 3
    public static int[] divisionArray(int[] first, int[] second) {
        if (isCorrectArrays(first,second)) {
            int[] result = new int[first.length];
            for (int i = 0; i < first.length; i++) {
                try {
                    result[i] = first[i] / second[i];
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            }
            return result;
        }
        return null;
    }
    // Задача 3
    public static int[] sumArray(int[] first, int[] second) {
        if (isCorrectArrays(first,second)) {
            int[] result = new int[first.length];
            for (int i = 0; i < first.length; i++) {
                if (first[i] - second[i] != (long)first[i] + second[i]) {
                    try {
                        throw new RuntimeException("result cannot be put in int");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                result[i] = first[i] + second[i];
            }
            return result;
        }
        return null;
    }
    // Задача 4
    public static boolean isCorrect(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int numberColumns = array[i].length;
            int numberRows = 0;
            for (int j = 0; j < array.length; j++) {
                try {
                   int temp = array[numberRows][i];
                   ++numberRows;
                } catch (ArrayIndexOutOfBoundsException e) {
                    if (numberRows != numberColumns) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCorrectArrays(int[] first, int[] second) {
        if (first.length != second.length || first.length + second.length > 50000)
            try {
                throw new RuntimeException("lengths arrays not correct");
            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        return true;
    }
    
}