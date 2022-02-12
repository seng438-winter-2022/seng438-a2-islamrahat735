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

toString() equivalence class partitions:

  * (Negative, Any) = (-3, 1)
  * (Zero, Any) = (0, 3)
  * (Positive, Any) = (1,3)
  * (Any, Negative) = (-3, -1)
  * (Any, Zero) = (-1, 0)
  * (Any, Positive) = (1, 3)

**DataUtilities Class**

calculateRowTotal(Values2D data, int row) equivalence class partitions:

  * Row with 1 column = [5]
  * Row with columns adding up to positive value = [5,5]
  * Row with columns adding up to zero value = [5, -5]
  * Row with columns adding up to negative value = [0, -5]
  * Null as Values2D parameter

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

**DataUtilities Class**

|    calculateRowTotal(Values2D data, int column)   | Equivalence Class Partition | Status     |
|    :----:   |    :----:   |    :----:     |
| calculateRowTotalOneColumn()      | Row with 1 column       | Pass   |
| calculateRowTotalPos()   | Row with columns adding up to positive value        | Pass      |
| calculateRowTotalZero()   | Row with columns adding up to zero value        | Pass      |
| calculateRowTotalNeg()   | Row with columns adding up to negative value        | Pass      |
| calculateRowTotalIllegalArgumentException()   | Null as Values2D parameter        | Pass      |


Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
