**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  10  |
| -------------- | --- |
| Student Names: |   Mohammad Mahtab Khan  |
|                |   Redwanul Islam  |
|                |   Rahat Islam  |
|                |   Zeeshan Chougle  |

# 1 Introduction

The purpose of this lab is to explore automated unit-testing and more specifically, the concept of black-box testing. A total of ten functions is tested using a combination of unit tests and mock tests. This was accomplisherd by utilizing Java’s JUnit framework to develop these unit tests. We also learned to utilize and work with mock objects in test-code development

# 2 Detailed description of unit test strategy

We used a black-box testing technique known as Boundary Value Analysis (BVA) in order to check for errors at the boundaries of an input domain. Both invalid and valid parameters were used for a given range. Boundary Value Analysis was used in methods such as contains() in the Range class. For each of the methods, we first figured out boundaries, from this we then created equivalence class partitions.

The partitions for calculateColumnTotal tested on a Values2D object with 5 elements, one with 2 elements and one with 3 elements. Each Values2D object was mocked to return a specific size, with values in each cell.

We have tested the boundary values and edges cases for each of our methods. Down below is an example for boundary values and edge case test for a Range and DataUtilities method respectively:

| getLength()| Boundary Values & Edge Cases | Status |
|    :----:   |    :----:   |    :----:     |
| testGetLengthZeroZero()| Range: (0,0) | Pass |
| testGetLengthZeroPINF()| Range: (0,+INF) | Pass |
| testGetLengthNINFZero()| Range: (-INF,0) | Fail |


|    equal(double[][] a, double[][] b)   | Boundary Values & Edge Cases | Status     |
|    :----:   |    :----:   |    :----:     |
| testEmptyArraysEquality()      |A: [[]]    B: [[]]   | Pass   |
| test2NULLArraysEquality()   | A: null    B: null   | Pass      |
| test1NULLand1NormalArrayEquality()   | A: null     B: [[1]]       | Pass      |
| test1NULLand1EmptyArrayEquality()      | A: null    B: [[]]     | Pass   |
| test2INFArraysEquality()   | A: [[INF]]    B: [[INF]]     | Pass      |
| test2NANArraysEquality()   | A: [[NaN]]    B: [[NaN]]       | Pass      |
| test1NANand1INFArrayEquality()   |  A: [[NaN]]    B: [[INF]]   | Pass      |


We used Mocking to test methods contained in the DataUtilities class. A library that supports test-driven development of Java code with objects called JMock was used. This allowed us to test methods which take in interfaces as parameters to be tested. Moreover, it allowed dependencies to be accounted for and abstracted.

Benefits:
  * Easy to set up.
  * Allows for methods which require interfaces as parameters to be tested. 

Drawbacks:
  * Intricacies of the methods get obfuscated

**Range Class**  

Note: Upper bound >= Lower bound

String toString() equivalence class partitions:

  * (Negative, Any)
  * (Zero, Any)
  * (Positive, Any)
  * (Any, Negative)
  * (Any, Zero)
  * (Any, Positive)


boolean getLength() equivalence class partitions:

  * (Positive, Positive)
  * (Negative, Positive)
  * (Negative, Negative)
  * (Zero, Positive)
  * (Negative, Zero)
 

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

double getCentralValue() equivalence class partitions:

  * Find a range with normal values to test (integer result)
  * Find a range with the same values
  * Find a range with abnormal values (non-integer result)



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

boolean equal(double[][], double[][]) equivalence/boundary partitions:

  * Arrays with same dimensions and values
  * Arrays with different dimensions but all same values 
  * Arrays with different Arrays with any dimensions and different value

static double calculateColumnTotal(Values2D data, int column) equivalence class partitions:

  * Column with 5 rows created with 5 positive values and check if their sum adds up to a positive number
  * Column with 2 rows created with only negative values and check if their sum adds up
  * Column with 3 rows created with positive and negative values and check if their sum adds up


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


| getCentralValue()| Equivalence Class Partition | Status |
|    :----:   |    :----:   |    :----:     |
| centralValueShouldBeThree()| Normal values for range (2,4)| Pass |
| centralValueShouldBeTwo()| Same values for range (2,2)| Pass |
| centralValueShouldBeOneAndHalf()| Abnormal values for range (1,2)| Pass |

| getLength()| Equivalence Class Partition | Status |
|    :----:   |    :----:   |    :----:     |
| testGetLengthPositivePositive()| (Positive, Positive) | Pass |
| testGetLengthNegativePositive()| (Negative, Positive) | Pass |
| testGetLengthNegativeNegative()| (Negative, Negative)| Pass |
| testGetLengthZeroPositive()| (Zero, Positive) | Pass |
| testGetLengthNegativeZero()| (Negative, Zero)| Pass |


| getLength()| Boundary Values & Edge Cases | Status |
|    :----:   |    :----:   |    :----:     |
| testGetLengthZeroZero()| Range: (0,0) | Pass |
| testGetLengthZeroPINF()| Range: (0,+INF) | Pass |
| testGetLengthNINFZero()| Range: (-INF,0) | Fail |



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



|    calculateRowTotal(Values2D data, int row, int[] valCols)   | Equivalence Class Partition | Status     |
|    :----:   |    :----:   |    :----:     |
| testAValidInputUsingEdgeColumnsForMethodCalculateRowTotal()      | Find Total Row Value using the first and last column       | Pass - return value is as expected   |
| testAValidInputUsingMiddleColumnsForMethodCalculateRowTotal()   | Find Total Row Value using the middle columns        | Pass - return value is as expected      |
| testInvalidColumnsForMethodCalculateRowTotal()   | Find Total Row Value using an invalid column with the expectation of an exception to be thrown        | Fail - exception was expected to be thrown due to an invalid column number  |


| calculateColumnTotal( Values2D data, int column )| Equivalence Class Partition | Status |
|    :----:   |    :----:   |    :----:     |
| calculateColumnTotalForFiveRows() | Column with 5 rows | Pass |
| calculateColumnTotalForTwoRowswithNegValues()| Column with 2 rows with only negative values | Pass |
| calculateColumnTotalForThreeRowswithPosNegValues()| Column with 3 rows with positive and negative values| Pass |



# 4 How the team work/effort was divided and managed

The effort was divided equally between the four members of our group. Each of us selected at least two methods, one from Range class and one from DataUtilities class, to write Unit tests for. Our next step was to plan how we would design our test cases and document the strategy. Next, we wrote our test cases and reviewed each other’s work to ensure we maintain a high standard for the tests written. We communicated through zoom and discord to explain our code to each other and discuss key theoretical concepts learned during the assignment. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

* Getting all of the dependencies sorted when initially setting up the Eclipse IDE for the project was one of the biggest challenges that we faced.
* We also faced the issue of inconsitencies when writing up our report.
* In hindsight, it would have probably been a better idea if only 1-2 members wrote the the whole report.

# 6 Comments/feedback on the lab itself

This assignment has greatly helped us familiarise with the fundamental concepts of automated unit testing specifically unit testing based on requirements for each unit.
Moreover, it helped us familiarise on the usage of JUnit framework and the purpose of mock objects in test-code developent. It has also provided us with an opportunity to learn about each person’s strengths and weaknesses, and in future assignments we hope to utilise this knowledge in order to further streamline our group work. Finally, the lab document was a great way to summarize and document our work throughout the lab which could serve as a great reference tool for future assignments.

