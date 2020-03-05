package com.zipcode.merger;

import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple RestrictedZipcodeRange.
 */
public class ZipcodeRangeValidatorTest {

    private ZipcodeRangeMerger zipcodeRangeMerger;

    @Before
    public void setUp() throws Exception {
        zipcodeRangeMerger = new ZipcodeRangeMerger();
    }

    @Test
    public void testLoadedList() {
        String inputDataSet = "[06902,07007] [92003,92004]";
        List<ZipcodeRange> zipcodeRangeList = new ZipcodeValidator(inputDataSet).getZipcodeRangeList();
        assertTrue(zipcodeRangeList.size() > 0);
    }

    @Test
    public void testfinalResultToMatch() {
        String inputDataSet = "[92002,92007] [92003,92004]";
        List<ZipcodeRange> zipcodeRangeList = new ZipcodeValidator(inputDataSet).getZipcodeRangeList();
        List<ZipcodeRange> mergedZipcodeRangeList = zipcodeRangeMerger.mergeZipcodesRange(zipcodeRangeList);
        Assert.assertEquals(1, mergedZipcodeRangeList.size());
    }

    @Test
    public void testExceptionWhenLessDigitInLower() {
        try {
            String inputDataSet = "[0200,92007] [92003,92004]";
            new ZipcodeValidator(inputDataSet).getZipcodeRangeList();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
        }
    }

    @Test
    public void testExceptionWhenLessDigitInUpper() {
        try {
            String inputDataSet = "[06902,08979] [92003,9200]";
            new ZipcodeValidator(inputDataSet).getZipcodeRangeList();
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
        }
    }

    @Test
    public void testExceptionMessageWhenLowerBoundGreater() {
        try {
            String inputDataSet = "[06903,06902] [92003,92004]";
            new ZipcodeValidator(inputDataSet).getZipcodeRangeList();
        } catch (IllegalArgumentException e) {
            String expectedMessage = "06903 06902:  Upper Bound should be greater than lower bound in every zipcode range";
            Assert.assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testExceptionMessageWhenMoreRangeGiven() {
        try {
            String inputDataSet = "[92004,92002,92003] [92003,92004]";
            new ZipcodeValidator(inputDataSet).getZipcodeRangeList();
        } catch (IllegalArgumentException e) {
            String expectedMessage = "92004 : Zipcode range should have two values only";
            Assert.assertEquals(expectedMessage, e.getMessage());
        }
    }

}
