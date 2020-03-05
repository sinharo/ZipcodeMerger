package com.zipcode.merger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZipcodeRangeMergerTest {

  private ZipcodeRangeMerger zipcodeRangeMerger;

  @Before
  public void setUp() throws Exception {
    zipcodeRangeMerger = new ZipcodeRangeMerger();
  }

  @Test
  public void testMergeZipcodes() {
    ZipcodeRange firstZipcodeRange = new ZipcodeRange(16902, 17007);
    ZipcodeRange secondZipcodeRange = new ZipcodeRange(95002, 95006);
    List<ZipcodeRange> zipcodeRangeList = new LinkedList<>();
    zipcodeRangeList.add(firstZipcodeRange);
    zipcodeRangeList.add(secondZipcodeRange);

    List<ZipcodeRange> mergedZipcodeRangeList = zipcodeRangeMerger.mergeZipcodesRange(zipcodeRangeList);
    Assert.assertTrue(mergedZipcodeRangeList.size() > 0);
  }

  @Test
  public void testOverlappingRange() {
    ZipcodeRange firstZipcodeRange = new ZipcodeRange(95000, 95005);
    ZipcodeRange secondZipcodeRange = new ZipcodeRange(95002, 95006);
    List<ZipcodeRange> zipcodeRangeList = new LinkedList<>();
    zipcodeRangeList.add(firstZipcodeRange);
    zipcodeRangeList.add(secondZipcodeRange);
    List<ZipcodeRange> mergedZipcodeRangeList = zipcodeRangeMerger.mergeZipcodesRange(zipcodeRangeList);
    Assert.assertEquals(95006, mergedZipcodeRangeList.get(0).getUpperBound());
  }

  @Test
  public void testSorting() {
    ZipcodeRange firstZipcodeRange = new ZipcodeRange(95000, 95005);
    ZipcodeRange firstZipcodeRange1 = new ZipcodeRange(95003, 95004);
    ZipcodeRange secondZipcodeRange = new ZipcodeRange(95002, 95006);
    List<ZipcodeRange> zipcodeRangeList = new LinkedList<>();
    zipcodeRangeList.add(secondZipcodeRange);
    zipcodeRangeList.add(firstZipcodeRange);
    zipcodeRangeList.add(firstZipcodeRange1);
    Collections.sort(zipcodeRangeList);
    for(ZipcodeRange z : zipcodeRangeList) {
      System.out.println(z.getLowerBound() + ","+ z.getUpperBound());
    }
    Assert.assertSame(zipcodeRangeList.get(0), firstZipcodeRange);
  }

  @Test
  public void testLoadAfterCallingMerge() {
    ZipcodeRange firstZipcodeRange = new ZipcodeRange(95000, 95005);
    ZipcodeRange secondZipcodeRange = new ZipcodeRange(95007, 95008);
    List<ZipcodeRange> zipcodeRangeList = new LinkedList<>();
    zipcodeRangeList.add(firstZipcodeRange);
    zipcodeRangeList.add(secondZipcodeRange);
    List<ZipcodeRange> mergedZipcodeRangeList = zipcodeRangeMerger.mergeZipcodesRange(zipcodeRangeList);
    Assert.assertEquals(mergedZipcodeRangeList, zipcodeRangeList);
  }

}
