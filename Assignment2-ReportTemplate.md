**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  10  |
| -------------- | --- |
| Student Names: |   Mohammad Mahtab Khan  |
|                |   Redwanul Islam  |
|                |   Rahat Islam  |
|                |   Zeeshan Chougle  |

# 1 Introduction

Text…

# 2 Detailed description of unit test strategy

We used a black-box testing technique known as Boundary Value Analysis (BVA) in order to check for errors at the boundaries of an input domain. Both invalid and valid parameters were used for a given range. Boundary Value Analysis was used in methods such as contains() in the Range class. For each of the methods, we first figured out boundaries, from this we then created equivalence class partitions.

We used Mocking to test methods contained in the DataUtilities class. A library that supports test-driven development of Java code with objects called JMock was used. This allowed us to test methods which take in interfaces as parameters to be tested. Moreover, it allowed dependencies to be accounted for and abstracted.

Benefits:
  * Easy to set up.
  * Allows for methods which require interfaces as parameters to be tested. 

Drawbacks:
  * Intricacies of the methods get obfuscated

**Range Class**  

String toString() equivalence class partitions:

  * (Negative, Any)
  * (Zero, Any)
  * (Positive, Any)
  * (Any, Negative)
  * (Any, Zero)
  * (Any, Positive)

boolean contains(double val) equivalence/boundary partitions:
  
  * val is just above the lower boundary and below the upper boundary
  * val is just below the upper boundary and above the lower boundary
  * val is below the lower boundary
  * val is above the upper coundary

Range combine(Range range1, Range range2)

  * range1 and range2 are valid and disjoint ranges
  * range1 and range2 are valid ranges and range2 is a subset of range1
  * range1 is a valid range and range2 is null
  * both ranges are null

**DataUtilities Class**

double calculateRowTotal(Values2D data, int row) equivalence class partitions:

  * Row with 1 column
  * Row with columns adding up to positive value
  * Row with columns adding up to zero value
  * Row with columns adding up to negative value
  * Null as Values2D parameter

double calculateRowTotal(Values2D data, int row, int[] validCols) equivalence/boundary class partitions:

  * choose 1st and last column for valid rows
  * choose middle columns for valid rows
  * choose a column that is out of bound

// including the input partitions you have designed

# 3 Test cases developed

**Range Class**

|    toString()   | Equivalence Class Partition | Status     |
|    :----:   |    :----:   |    :----:     |
| isStringNegLow()      | (Negative, Any)       | Pass   |
| isStringZeroLow()   | (Zero, Any)        | Pass      |
| isStringPosLow()   | (Positive, Any)        | Pass      |
| isStringNegHi()   | (Any, Negative)        | Pass      |
| isStringZeroHi()   | (Any, Zero)        | Pass      |
| isStringPosHi()   | (Any, Positive)        | Pass      |

|  boolean contains(double val) | Equivalence Class Partition | Status |
| :----: | :----: | :-----: |
| rangeContainsAboveLowerBound()| val is just above the lower boundary and below the upper boundary | Pass - returns true as expected |
| rangeContainsBelowUpperBound()| val is just below the upper boundary and above the lower boundary | Pass - returns true as expected |
| rangeDoesntContainAboveUpperBound()| val is below the lower boundary | Pass - returns false as expected |
| rangeDoesntContainBelowLowerBound()| val is above the upper boundary | Pass - returns false as expected |


| Range combine( Range range1, Range range2) | Equivalence Class Partition | Status |
| :----: | :----: | :-----: |
| combine2DisjointValidRanges() |range1 and range2 are valid and disjoint ranges | Pass - returns correct range as expected |
| combineValidRangeWithSubsetRange() | range1 and range2 are valid ranges and range2 is a subset of range1 | Pass - returns correct range as expected |
| combine1NullAndValidRange() | range1 is a valid range and range2 is null | Pass - returns range1 as expected |
| combine2NullRange() | both ranges are null | Pass - returns null as expected |


**DataUtilities Class**

|    calculateRowTotal(Values2D data, int column)   | Equivalence Class Partition | Status     |
|    :----:   |    :----:   |    :----:     |
| calculateRowTotalOneColumn()      | Row with 1 column       | Pass   |
| calculateRowTotalPos()   | Row with columns adding up to positive value        | Pass      |
| calculateRowTotalZero()   | Row with columns adding up to zero value        | Pass      |
| calculateRowTotalNeg()   | Row with columns adding up to negative value        | Pass      |
| calculateRowTotalIllegalArgumentException()   | Null as Values2D parameter        | Pass      |

|    equal(double[][] a, double[][] b)   | Equivalence Class Partition | Status     |
|    :----:   |    :----:   |    :----:     |
| testEqualArraysEquality()       | Arrays with same dimensions and values     | Pass   |
| testUnequalArraysEquality()   | Arrays with different dimensions but all same values     | Pass      |
| testUnequalDimesionsArraysEquality()   | Arrays with different Arrays with any dimensions and different values       | Pass      |

|    equal(double[][] a, double[][] b)   | Boundary Values & Edge Cases | Status     |
|    :----:   |    :----:   |    :----:     |
| testEmptyArraysEquality()      |A: [[]]    B: [[]]   | Pass   |
| test2NULLArraysEquality()   | A: null    B: null   | Pass      |
| test1NULLand1NormalArrayEquality()   | A: null     B: [[1]]       | Pass      |
| test1NULLand1EmptyArrayEquality()      | A: null    B: [[]]     | Pass   |
| test2INFArraysEquality()   | A: [[INF]]    B: [[INF]]     | Pass      |
| test2NANArraysEquality()   | A: [[NaN]]    B: [[NaN]]       | Pass      |
| test1NANand1INFArrayEquality()   |  A: [[NaN]]    B: [[INF]]   | Pass      |

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Each of the group members were tasked with testing 2-3 methods from Range and DataUtilities class. Once the testing phase was over, we all came together to share our results. In case of any discrepencies or issues, we re-visited the testing phase in order to rectify the issues. Once all issues had been dealt with, we came together and created the report.

# 5 Difficulties encountered, challenges overcome, and lessons learned

* Getting all of the dependencies sorted when initially setting up the Eclipse IDE for the project was one of the biggest challenges that we faced.
* We also faced the issue of inconsitencies when writing up our report.
* In hindsight, it would have probably been a better idea if only 1-2 members wrote the the whole report.

# 6 Comments/feedback on the lab itself
