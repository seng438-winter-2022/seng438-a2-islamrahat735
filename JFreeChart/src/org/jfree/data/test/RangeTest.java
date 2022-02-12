package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
	private Range exampleRange;
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range exampleRange5;
    private Range exampleRange6;
    private Range myRange;
    private Range rahatRange;

    @BeforeClass public static void setUpBeforeClass() throws Exception {}

    @Before
    public void setUpOne() throws Exception {
        exampleRange1 = new Range(-3, 1);
    }

    @Test
    public void isStringNegLow() { //Negative Lower Bound
        assertEquals("The string should be Range[-3.0,1.0]", "Range[-3.0,1.0]", exampleRange1.toString());
    }

    @Before
    public void setUpTwo() throws Exception {
        exampleRange2 = new Range(0, 3);
    }

    @Test
    public void isStringZeroLow() { //Zero Lower Bound
        assertEquals("The string should be Range[0.0,3.0]", "Range[0.0,3.0]", exampleRange2.toString());
    }

    @Before
    public void setUpThree() throws Exception {
        exampleRange3 = new Range(1, 3);
    }

    @Test
    public void isStringPosLow() { //Positive Lower Bound
        assertEquals("The string should be Range[1.0,3.0]", "Range[1.0,3.0]", exampleRange3.toString());
    }

    @Before
    public void setUpFour() throws Exception {
        exampleRange4 = new Range(-3, -1);
    }

    @Test
    public void isStringNegHi() { //Negative Upper Bound
        assertEquals("The string should be Range[-3.0,-1.0]", "Range[-3.0,-1.0]", exampleRange4.toString());
    }

    @Before
    public void setUpFive() throws Exception {
        exampleRange5 = new Range(-1, 0);
    }

    @Test
    public void isStringZeroHi() { //Zero Upper Bound
        assertEquals("The string should be Range[-1.0,0.0]", "Range[-1.0,0.0]", exampleRange5.toString());
    }

    @Before
    public void setUpSix() throws Exception {
        exampleRange6 = new Range(1, 3);
    }

    @Test
    public void isStringPosHi() { //Positive Upper Bound
        assertEquals("The string should be Range[1.0,3.0]", "Range[1.0,3.0]", exampleRange6.toString());
    }


    // Set range to (2,4) initially
    @Before
    public void setUp() throws Exception { myRange = new Range(2, 4);
    }

    // This test covers normal values for the range (2,4) in method centralValueShouldBeThree()
    // Check if the central value of 2 and 4 is 3
    @Test
    public void centralValueShouldBeThree() {
        // If the central value returned does not match the set value, it will output the message in first parameter
        assertEquals("The central value of 2 and 4 should be 3",
        3, myRange.getCentralValue(), .000000001d);
    }

    // This test covers same values for the range (2,2) in method centralValueShouldBeTwo()
    // Check if the central value of 2 and 2 is 2
    @Test
    public void centralValueShouldBeTwo() {
        
        Range newRange = new Range(2,2);
        // If the central value returned does not match the set value, it will output the message in first parameter
        assertEquals("The central value of 2 and 2 should be 2",
        2, newRange.getCentralValue(), .000000001d);
    }
    
    // This test covers non-integer values for the range (1,2) in method centralValueShouldBeOneAndHalf()
    // Check if the central value of 1 and 2 is 1.5
    @Test
    public void centralValueShouldBeOneAndHalf() {
        
        Range anotherRange = new Range(1,2);
        // If the central value returned does not match the set value, it will output the message in first parameter
        assertEquals("The central value of 1 and 2 should be 1.5",
        1.5, anotherRange.getCentralValue(), .000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    //Method boolean contains(int val)
    @Test
    public void rangeContainsAboveLowerBound() { // test to see is contains() returns true for value above the lower bound 
    	rahatRange = new Range(-10, 10);
    	assertEquals("Range should contain -9.95",
    	        true, rahatRange.contains(-9.95));
    }
    
    
  //Method boolean contains(int val)
    @Test
    public void rangeContainsBelowUpperBound() { // test to see is contains() returns true for value below the upper bound
    	rahatRange = new Range(-10, 10);
    	assertEquals("Range should contain 9.99",
    	        true, rahatRange.contains(9.99));
    }
    
  //Method boolean contains(int val)
    @Test
    public void rangeDoesntContainAboveUpperBound() { // test to see is contains() returns false for value above the upper bound
    	rahatRange = new Range(-10, 10);
    	assertEquals("Range should not contain 10.1",
    	        false, rahatRange.contains(10.1));
    }
    
    
    //Method boolean contains(int val)
    @Test
    public void rangeDoesntContainBelowLowerBound() { // test to see is contains() returns false for value below the lower bound
    	rahatRange = new Range(-10, 10);
    	assertEquals("Range should  not contain -10.01",
    	        false, rahatRange.contains(-10.01));
    }
    
    
    //Method Range combine(Range range1, Range range2)
    @Test
    public void combine2DisjointValidRanges() { //Combine 2 Valid Ranges which are disjoint from each other
    	Range range1 = new Range(-50, 50);
    	Range range2 = new Range(60, 85);
    	
    	assertEquals("Range should be (-50, 85)",
    			new Range(-50, 85),Range.combine(range1, range2));
    }
    
    //Method Range combine(Range range1, Range range2)
    @Test
    public void combineValidRangeWithSubsetRange() { // Combine a valid Range with another range that is a subset of the first Range
    	Range range1 = new Range(-50, 50);
    	Range range2 = new Range(0, 10);
    	
    	assertEquals("Range should be (-50, 50)",
    			new Range(-50, 50),Range.combine(range1, range2));
    }
    
    //Method Range combine(Range range1, Range range2)
    @Test
    public void combine1NullAndValidRange() { // Combine A valid range with a null range, expecting the valid range to be outputted
    	Range range1 = new Range(-50, 50);
    	Range range2 = null;
    	
    	assertEquals("Range should be (-50, 50)",
    			new Range(-50, 50),Range.combine(range1, range2));
    }
    
    
    //Method Range combine(Range range1, Range range2)
    @Test
    public void combine2NullRange() { // Combine 2 null ranges, expecting null as an output
    	Range range1 = null;
    	Range range2 = null;
    	
    	assertEquals("Range should be null",
    			null, Range.combine(range1, range2));
    }
    
    @Test
    public void testGetLengthPositivePositive() {
        
        // This test checks one of the equivalence classes by checking the length of the following class of inputs: (Positive, Positive)
        
        exampleRange = new Range(1,5);  // setting range to (1,5)
        assertEquals("The length of the range is:",
        4, exampleRange.getLength(), .000000001d);  // Expected output 4
    }
    
    @Test
    public void testGetLengthNegativePositive() {
        
        // This test checks one of the equivalence classes by checking the length of the following class of inputs: (Negative, Positive)
        
        exampleRange = new Range(-1,5); // setting range to (-1,5)
        assertEquals("The length of the range is:",
        6, exampleRange.getLength(), .000000001d); // Expected output 6
    }
    
    @Test
    public void testGetLengthNegativeNegative() {
        
        // This test checks one of the equivalence classes by checking the length of the following class of inputs: (Negative, Negative)
        
        exampleRange = new Range(-7,-5); // setting range to (-7,-5)
        assertEquals("The length of the range is:",
        2, exampleRange.getLength(), .000000001d); // Expected output 2
    }
    
    @Test
    public void testGetLengthNegativeZero() {
        
        // This test checks one of the equivalence classes by checking the length of the following class of inputs: (Negative, Zero)
        
        exampleRange = new Range(-1,0); // setting range to (-1,0)
        assertEquals("The length of the range is:",
        1, exampleRange.getLength(), .000000001d); // Expected output 1
    }
    
    @Test
    public void testGetLengthZeroPositive() {
        
        // This test checks one of the equivalence classes by checking the length of the following class of inputs: (Zero, Positive)
        
        exampleRange = new Range(0,1); // setting range to (0,1)
        assertEquals("The length of the range is:",
        1, exampleRange.getLength(), .000000001d);    // Expected output 1
    }
    
    @Test
    public void testGetLengthZeroZero() {
        
        // This test checks one of the edge cases by checking the length of the range (0,0)
        
        exampleRange = new Range(0,0); // setting range to (0,0)
        assertEquals("The length of the range is:",
        0, exampleRange.getLength(), .000000001d);    // Expected output 0
    }
    
    @Test
    public void testGetLengthZeroPINF() {
        
        // This test checks one of the edge cases by checking the length of the range (0,+INF)
        
        exampleRange = new Range(0   ,Double.POSITIVE_INFINITY); // setting range to (0, +INF)
        assertEquals("The length of the range is:",
                Double.POSITIVE_INFINITY, exampleRange.getLength(), .000000001d);  // Expected output +INF
    }
    
    @Test
    public void testGetLengthNINFZero() {
        
        // This test checks one of the edge cases by checking the length of the range (-INF,0)
        
        exampleRange = new Range(Double.NEGATIVE_INFINITY,0); // setting range to (-INF,0)
        assertEquals("The length of the range is:",
                Double.NEGATIVE_INFINITY, exampleRange.getLength(), .000000001d); // Expected output -INF
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}
}