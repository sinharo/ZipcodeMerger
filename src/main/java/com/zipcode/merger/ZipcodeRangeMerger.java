package com.zipcode.merger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZipcodeRangeMerger {

    public List<ZipcodeRange> mergeZipcodesRange(List<ZipcodeRange> zipcodeRangeList) {
        Collections.sort(zipcodeRangeList);
        List<ZipcodeRange> mergedZipcodeRangeList = new LinkedList<>();
        ZipcodeRange zipcodeRange = null;
        for (ZipcodeRange zips : zipcodeRangeList) {
            if (zipcodeRange == null)
                zipcodeRange = zips;
            else {
                if (zipcodeRange.getUpperBound() >= zips.getLowerBound()) {
                    zipcodeRange.setUpperBound(Math.max(zipcodeRange.getUpperBound(), zips.getUpperBound()));
                } else {
                    mergedZipcodeRangeList.add(zipcodeRange);
                    zipcodeRange = zips;
                }
            }
        }
        mergedZipcodeRangeList.add(zipcodeRange);
        return mergedZipcodeRangeList;
    }

}
