package com.zipcode.merger;

import java.util.Objects;

public class ZipcodeRange implements Comparable<ZipcodeRange> {

    private int lowerBound;
    private int upperBound;

    public ZipcodeRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }


    /**
     * Comparision on the basis of lowerBound
     * @param anotherZipcodeRange - The ZipCodeRange to be compared.
     * @return A negative integer, zero, or a positive integer as this lowerBound of ZipcodeRange
     * is less than, equal to, or greater than the lowerBound of the supplied ZipcodeRange object.
     */
    @Override
    public int compareTo(ZipcodeRange anotherZipcodeRange) {
        return this.getLowerBound() - anotherZipcodeRange.getLowerBound();
    }

    // Two zipcodeRanges are equal if their lowerbound and upperBound are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipcodeRange zipcodeRange = (ZipcodeRange) o;
        return lowerBound == zipcodeRange.lowerBound ;//&& upperBound == zipcodeRange.upperBound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerBound);
    }
}
