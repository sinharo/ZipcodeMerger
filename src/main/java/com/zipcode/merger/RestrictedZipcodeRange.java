package com.zipcode.merger;

import java.util.List;
import java.util.Scanner;

public class RestrictedZipcodeRange {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String zipcodeRanges = scan.nextLine();

            ZipcodeValidator zipcodeValidator = new ZipcodeValidator(zipcodeRanges);
            List<ZipcodeRange> zipcodeRangeList = zipcodeValidator.getZipcodeRangeList();

            if(!zipcodeRangeList.isEmpty()) {
                List<ZipcodeRange> mergedZipcodeRangeList = new ZipcodeRangeMerger().mergeZipcodesRange(zipcodeRangeList);

                for (ZipcodeRange zipcodeRange : mergedZipcodeRangeList) {
                    System.out.println("[" + zipcodeRange.getLowerBound() + "," + zipcodeRange.getUpperBound() + "]");
                }
            }
        }catch(Exception exp){
            System.err.println("Exception in merging ZipcodeRange" +exp.getMessage());
        }

    }
}
