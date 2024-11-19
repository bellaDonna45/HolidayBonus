package holidaypackage;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] testData;
    private File testFile;

    @Before
    public void setUp() throws Exception {
        testData = new double[][] {
            { 10.5, 20.2, 30.1 },
            { 5.5, 15.6 },
            { 25.0, 35.7, 45.2, 55.3 }
        };
        testFile = new File("testData.txt");

        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("10.5 20.2 30.1\n");
            writer.write("5.5 15.6\n");
            writer.write("25.0 35.7 45.2 55.3\n");
        }
    }

    @After
    public void tearDown() throws Exception {
        testData = null;
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testReadFile() throws Exception {
        double[][] result = TwoDimRaggedArrayUtility.readFile(testFile);
        assertArrayEquals(testData, result);
    }

    @Test
    public void testWriteToFile() throws Exception {
        File outputFile = new File("outputTestData.txt");
        TwoDimRaggedArrayUtility.writeToFile(testData, outputFile);

        double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertArrayEquals(testData, result);

        if (outputFile.exists()) {
            outputFile.delete();
        }
    }

    @Test
    public void testGetTotal() {
        assertEquals(243.1, TwoDimRaggedArrayUtility.getTotal(testData), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(30.3875, TwoDimRaggedArrayUtility.getAverage(testData), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(60.8, TwoDimRaggedArrayUtility.getRowTotal(testData, 0), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(41.0, TwoDimRaggedArrayUtility.getColumnTotal(testData, 0), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(30.1, TwoDimRaggedArrayUtility.getHighestInRow(testData, 0), 0.001);
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(5.5, TwoDimRaggedArrayUtility.getLowestInRow(testData, 1), 0.001);
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(25.0, TwoDimRaggedArrayUtility.getHighestInColumn(testData, 0), 0.001);
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(5.5, TwoDimRaggedArrayUtility.getLowestInColumn(testData, 0), 0.001);
    }
}

