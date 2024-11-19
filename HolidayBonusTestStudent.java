package holidaypackage;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent {

    private double[][] testData;

    @Before
    public void setUp() throws Exception {
        testData = new double[][] {
            { 10.5, 20.2, 30.1 },
            { 5.5, 15.6 },
            { 25.0, 35.7, 45.2, 55.3 }
        };
    }

    @After
    public void tearDown() throws Exception {
        testData = null;
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(testData);

        // Test each store's holiday bonus
        assertEquals(8000.0, bonuses[0], 0.001);
        assertEquals(7000.0, bonuses[1], 0.001);
        assertEquals(16000.0, bonuses[2], 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(testData);
        assertEquals(31000.0, totalBonus, 0.001);
    }
}

