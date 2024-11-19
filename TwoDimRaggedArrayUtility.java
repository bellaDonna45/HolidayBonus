/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: TwoDimRaggedArrayUtility class works in conjunction with the HolidayBonus class to analyze sales data and determine bonuses efficiently.
 * Due: 11/18/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Jade Messina Belinga
*/
package holidaypackage;

import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        List<double[]> data = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().trim().split("\\s+");
            double[] row = Arrays.stream(line).mapToDouble(Double::parseDouble).toArray();
            data.add(row);
        }
        scanner.close();
        
        return data.toArray(new double[0][]);
    }

    public static void writeToFile(double[][] array, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        
        for (double[] row : array) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }
//gettysbergers
    public static double getTotal(double[][] array) {
        double total = 0;
        for (double[] row : array) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] array) {
        double total = getTotal(array);
        int count = 0;
        for (double[] row : array) {
            count += row.length;
        }
        return total / count;
    }

    public static double getRowTotal(double[][] array, int row) {
        double total = 0;
        for (double value : array[row]) {
            total += value;
        }
        return total;
    }

    public static double getColumnTotal(double[][] array, int col) {
        double total = 0;
        for (double[] row : array) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] array, int row) {
        return Arrays.stream(array[row]).max().orElse(Double.NEGATIVE_INFINITY);
    }

    public static int getHighestInRowIndex(double[][] array, int row) {
        double max = getHighestInRow(array, row);
        for (int i = 0; i < array[row].length; i++) {
            if (array[row][i] == max) {
                return i;
            }
        }
        return -1;
    }

    public static double getLowestInRow(double[][] array, int row) {
        return Arrays.stream(array[row]).min().orElse(Double.POSITIVE_INFINITY);
    }

    public static int getLowestInRowIndex(double[][] array, int row) {
        double min = getLowestInRow(array, row);
        for (int i = 0; i < array[row].length; i++) {
            if (array[row][i] == min) {
                return i;
            }
        }
        return -1;
    }

    public static double getHighestInColumn(double[][] array, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : array) {
            if (col < row.length) {
                max = Math.max(max, row[col]);
            }
        }
        return max;
    }

    public static int getHighestInColumnIndex(double[][] array, int col) {
        double max = getHighestInColumn(array, col);
        for (int i = 0; i < array.length; i++) {
            if (col < array[i].length && array[i][col] == max) {
                return i;
            }
        }
        return -1;
    }

    public static double getLowestInColumn(double[][] array, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : array) {
            if (col < row.length) {
                min = Math.min(min, row[col]);
            }
        }
        return min;
    }

    public static int getLowestInColumnIndex(double[][] array, int col) {
        double min = getLowestInColumn(array, col);
        for (int i = 0; i < array.length; i++) {
            if (col < array[i].length && array[i][col] == min) {
                return i;
            }
        }
        return -1;
    }

    public static double getHighestInArray(double[][] array) {
        return Arrays.stream(array).flatMapToDouble(Arrays::stream).max().orElse(Double.NEGATIVE_INFINITY);
    }

    public static double getLowestInArray(double[][] array) {
        return Arrays.stream(array).flatMapToDouble(Arrays::stream).min().orElse(Double.POSITIVE_INFINITY);
    }
}
//:}

