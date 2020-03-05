package com.zipcode.merger;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ZipcodeValidator {

    private String zipcodeRanges;

    public ZipcodeValidator(String zipcodeRanges) {
        this.zipcodeRanges = zipcodeRanges;
    }

    public List<ZipcodeRange> getZipcodeRangeList() {
        String[] zipcodeRange = zipcodeRanges.split(" ");
        List<ZipcodeRange> zipcodesList = new LinkedList<>();
        for (String zips : zipcodeRange) {
            zipcodesList.add(validateAndConstructZipcodeRange(zips));
        }
        return zipcodesList;
    }

    private ZipcodeRange validateAndConstructZipcodeRange(String zipcodeString) {
        String[] zipRange = zipcodeString.replaceAll("[\\[\\]]", "").split(",");
        if (zipRange.length != 2) {
            throw new IllegalArgumentException(zipRange[0] + " : Zipcode range should have two values only");
        }
        if (validZipCode(zipRange[0])) {
            throw new IllegalArgumentException(zipRange[0] + ": " + "LowerBound of zipcode is not having 5 digits");
        }
        if (validZipCode(zipRange[1])) {
            throw new IllegalArgumentException(zipRange[1] + ": " + "UpperBound of zipcode is not having 5 digits");
        }
        int lowerBound = Integer.parseInt(zipRange[0]);
        int upperBound = Integer.parseInt(zipRange[1]);
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException(zipRange[0] + " " + zipRange[1] + ":  "
                    + "Upper Bound should be greater than lower bound in every zipcode range");
        }
        return new ZipcodeRange(lowerBound, upperBound);
    }

    private boolean validZipCode(String zip) {
        String regex = "^[0-9]{5}";
        Pattern pattern = Pattern.compile(regex);
        return !pattern.matcher(zip).matches();
    }
}
