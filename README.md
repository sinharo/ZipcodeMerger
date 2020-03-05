 **ZIPCODE MERGER**
 
Java maven application to merge the zipcode ranges 

----------------------------------------------------------------------------------------------------------------------
_Problem Statement:_
 
BACKGROUND
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

---------------------------------------------------------------------------------------------------------------------

_Assumptions made:_
1) Assumed input to come as String
For instance input [94133,94133] [94200,94299] [94600,94699] as whole under a string.

_DataStructures used:_
1) LinkedList - For now, used 2 linkedlist, one for storing the input and the other for storing the output.
2) Created maven project to help extension of this project for future work

_Java File Description:_
1) RestrictedZipcodeRange.java --> This is the main class that gets the input from the command line and prints a merged zipcode ranges.
2) ZipcodeRange.java -->  Java bean to represent the lower bound and upper bound of zipcode range. It implements Comparable interface and override equal and hashcode method too
4) ZipcodeValidator.java --> A validator class that parses, validates the input data and constructs the data structure.
5) ZipcodeRangeMerger.java --> The business logic to merger the zipcode ranges

_Tests:_
1) ZipcodeRangeValidatorTest --> Junit tests for the validator class to validate different scenarios of input
2) ZipcoderangeMergerTest --> Junit tests for the merging business logic.

_Sample outputs:_

  ![result](https://github.com/sinharo/ZipcodeMerger/blob/master/Result.jpg)
  
  
  
