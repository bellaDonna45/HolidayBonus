/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: HolidayBonus calculates holiday bonuses for stores based on their sales data. It determines the bonuses for each store in a district and calculates the total bonuses across all stores.
 * Due: 11/18/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Jade Messina Belinga
*/

package holidaypackage;

public class HolidayBonus {

    private static final double HIGH_BONUS = 5000.0;
    private static final double LOW_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] sales) {
        int numRows = sales.length;
        double[] bonuses = new double[numRows];

        int maxCols = 0;
        for (double[] row : sales) {
            maxCols = Math.max(maxCols, row.length);
        }

        for (int col = 0; col < maxCols; col++) {
            double highest = TwoDimRaggedArrayUtility.getHighestInColumn(sales, col);
            double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(sales, col);

            for (int row = 0; row < numRows; row++) {
                if (col < sales[row].length) {
                    double value = sales[row][col];
                    if (value == highest) {
                        bonuses[row] += HIGH_BONUS;
                    } else if (value == lowest) {
                        bonuses[row] += LOW_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] sales) {
        double[] bonuses = calculateHolidayBonus(sales);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}
//;)
