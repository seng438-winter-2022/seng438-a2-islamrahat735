package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	 @Test
	 public void calculateRowTotalOneColumn() { //Row with 1 column
		 Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             one(values).getColumnCount();
	             will(returnValue(1));
	             one(values).getValue(0, 0);
	             will(returnValue(5.0));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(5.0, result, .000000001d);
	 }
	 
	 @Test
	 public void calculateRowTotalPos() { //Row with columns adding up to positive value
		 Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(5.0));
	             one(values).getValue(0, 1);
	             will(returnValue(5.0));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(10.0, result, .000000001d);
	 }
	 
	 @Test
	 public void calculateRowTotalZero() { //Row with columns adding up to zero
		 Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(5.0));
	             one(values).getValue(0, 1);
	             will(returnValue(-5.0));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(0.0, result, .000000001d);
	 }
	 
	 @Test
	 public void calculateRowTotalNeg() { //Row with columns adding up to negative value
		 Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1));
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(0.0));
	             one(values).getValue(0, 1);
	             will(returnValue(-5.0));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals(-5.0, result, .000000001d);
	 }	 
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void calculateRowTotalIllegalArgumentException() { //Null as Values2D parameter
		 Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(1, 0);
	             will(returnValue(1.5));
	             one(values).getValue(1, 1);
	             will(returnValue(3.0));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(null, 1);
	 }
	 
	 @Test
	    public void testEqualArraysEquality() 
	    { 
	    	// This test checks one of the equivalence classes by checking equality of two equal 2D arrays with same dimensions and same values

	    	double[][] temp1 = new double[5][5];  // declaring array 1
	    	double[][] temp2 = new double[5][5];  // declaring array 2
	    	
	    	for(int i=0;i<temp1.length;i++)  // populating the arrays to be equal
	    	{
	    		for(int j=0; j<temp1[i].length; j++)
	    		{
	    			temp1[i][j]=i*j;
	    			temp2[i][j]=i*j;
	    		}
	    	}
	    	
	    	boolean result = DataUtilities.equal(temp1, temp2);  // checks if the two arrays are equal
	        
	    	assertTrue(result);  // verify if the actual outcome is True (expected outcome)
	    }
	    
	    
	    @Test
	    public void testUnequalArraysEquality() 
	    {
	    	// This test checks one of the equivalence classes by checking equality of two unequal 2D arrays

	    	double[][] temp1 = new double[5][5];  // declaring array 1
	    	double[][] temp2 = new double[5][5];  // declaring array 2
	    	
	    	for(int i=0;i<temp1.length;i++) // populating the arrays to be unequal
	    	{
	    		for(int j=0; j<temp1[i].length; j++)
	    		{
	    			temp1[i][j]=i*j;
	    			temp2[i][j]=i*(j+1);
	    		}
	    	}
	    	
	    	boolean result = DataUtilities.equal(temp1, temp2);   // checks if the two arrays are equal
	        
	       assertFalse(result);  // verify if the actual outcome is False (expected outcome)
	    }
	    
	    
	    @Test
	    public void testUnequalDimesionsArraysEquality() 
	    { 
	    	// This test checks one of the equivalence classes by checking equality of two arrays with all 0 values but different dimensions

	    	double[][] temp1 = new double[5][6];  // declaring array 1
	    	double[][] temp2 = new double[5][5];  // declaring array 2
	    	
	    	for(int i=0;i<temp1.length;i++) // populating the array1 
	    	{
	    		for(int j=0; j<temp1[i].length; j++)
	    		{
	    			temp1[i][j]=0;
	    		}
	    	}
	    	
	    	for(int i=0;i<temp2.length;i++)  // populating the array2 
	    	{
	    		for(int j=0; j<temp2[i].length; j++)
	    		{
	    			temp2[i][j]=0;
	    		}
	    	}
	    	
	    	
	    	boolean result = DataUtilities.equal(temp1, temp2);  // checks if the two arrays are equal
	        
	       // verify
	       assertFalse(result); // verify if the actual outcome is False (expected outcome)
	        
	    }
	    
	    
	    @Test
	    public void testEmptyArraysEquality() 
	    { 
	    	// This test checks one of the edge cases by testing the equality of two empty 2D arrays
	    	
	    	double[][] temp1 = new double[5][5];  // declaring array 1
	    	double[][] temp2 = new double[5][5];  // declaring array 2
	    	
	    	boolean result = DataUtilities.equal(temp1, temp2);  // checks if the two arrays are equal
	        
	       // verify
	       assertTrue(result);  // verify if the actual outcome is True (expected outcome)
	        
	    }
	    
	    @Test
	    public void test2NULLArraysEquality() 
	    { 
	    	
	    	// This test checks one of the edge cases by testing the equality of two NULL parameters
	  
	    	boolean result = DataUtilities.equal(null, null);  // checks if the two arrays are equal
	        
	       
	       assertTrue(result); // verify if the actual outcome is True (expected outcome)
	        
	    }
	    
	    @Test
	    public void test1NULLand1NormalArrayEquality() 
	    { 
	    	// This test checks one of the edge cases by testing the equality of 1 NULL and 1 Normal 2D array
	    	double[][] temp1 = new double[5][5]; // declaring array 1
	    		
	    	for(int i=0;i<temp1.length;i++)  // populating array 1
	    	{
	    		for(int j=0; j<temp1[i].length; j++)
	    		{
	    			temp1[i][j]=i*j;
	   
	    		}
	    	}
	    	
	    	boolean result = DataUtilities.equal(temp1, null);  // checks if the two arrays are equal
	        
	       // verify
	       assertFalse(result);  // verify if the actual outcome is False (expected outcome)
	        // tear-down: NONE in this test method
	    }
	    
	    @Test
	    public void test1NULLand1EmptyArrayEquality() 
	    { 
	    	// This test checks one of the edge cases by testing the equality of 1 NULL and 1 empty 2D array
	    	
	    	double[][] temp1 = new double[5][5]; // declaring array 1
	    		
	    	
	    	boolean result = DataUtilities.equal(temp1, null);  // checks if the two arrays are equal
	        
	       // verify
	       assertFalse(result);  // verify if the actual outcome is False (expected outcome)
	        // tear-down: NONE in this test method
	    }
	    
	    @Test
	    public void test2INFArraysEquality() 
	    {
	    	// This test checks one of the edge cases by testing the equality of 2 INF parameters

	    	boolean result = DataUtilities.equal(new double[][] {{Double.POSITIVE_INFINITY}}, new double[][] {{Double.POSITIVE_INFINITY}});  // checks if the two arrays are equal
	        
	       // verify
	       assertTrue(result);  // verify if the actual outcome is True (expected outcome)
	        // tear-down: NONE in this test method
	    
	    }
	    
	    @Test
	    public void test2NANArraysEquality() 
	    { 
	    	// This test checks one of the edge cases by testing the equality of 2 NaN parameters

	    	boolean result = DataUtilities.equal(new double[][] {{Double.NaN}}, new double[][] {{Double.NaN}});  // checks if the two arrays are equal
	        
	       // verify
	       assertTrue(result);  // verify if the actual outcome is True (expected outcome)
	        // tear-down: NONE in this test method
	    
	    }

	    
	    @Test
	    public void test1NANand1INFArrayEquality() 
	    { 
	    	// This test checks one of the edge cases by testing the equality of 1 NaN and 1 INF parameter

	   
	    	boolean result = DataUtilities.equal(new double[][] {{Double.POSITIVE_INFINITY}}, new double[][] {{Double.NaN}});  // checks if the two arrays are equal
	        
	       // verify
	       assertFalse(result);  // verify if the actual outcome is False (expected outcome)
	        // tear-down: NONE in this test method
	    
	    }
	    
		@Test
	    public void testAValidInputUsingEdgeColumnsForMethodCalculateRowTotal() //Find Total Row Value using the first and last column
	    {
	        Mockery mock1 = new Mockery();
	        final Values2D value1 = mock1.mock(Values2D.class);//created a mockery for the value2D class
	        mock1.checking(new Expectations() {
	            {
	            	//Setting up Mock Object
	            	allowing(value1).getColumnCount();
	                will(returnValue(4));//return value
	                allowing(value1).getValue(0, 0);
	                will(returnValue(6.9));//return value
	                allowing(value1).getValue(0, 1);
	                will(returnValue(1.3));//return value
	                allowing(value1).getValue(0, 2);
	                will(returnValue(134.6));//return value
	                allowing(value1).getValue(0, 3);
	                will(returnValue(1));//return value
	                
	            }
	        });
	        int [] valCols = new int[] {0, 3};
	        double result = DataUtilities.calculateRowTotal(value1, 0, valCols);// call the calculateRowTotal method and passed the variable data and row
	        assertEquals("Expected 7.9", 7.9, result, .000000001d);//verify
	    }
	    
	    //Method double calculateRowTotal(Values2D data, int row, int[] valCols) 
	    @Test
	    public void testAValidInputUsingMiddleColumnsForMethodCalculateRowTotal() //Find Total Row Value using the middle columns
	    {
	        Mockery mock1 = new Mockery();
	        final Values2D value1 = mock1.mock(Values2D.class);//created a mockery for the value2D class
	        mock1.checking(new Expectations() {
	            {
	                //Setting up Mock Object
	            	allowing(value1).getColumnCount();
	                will(returnValue(4));//return value
	                allowing(value1).getValue(0, 0);
	                will(returnValue(6.9));//return value
	                allowing(value1).getValue(0, 1);
	                will(returnValue(1.3));//return value
	                allowing(value1).getValue(0, 2);
	                will(returnValue(134.6));//return value
	                allowing(value1).getValue(0, 3);
	                will(returnValue(1));//return value
	                
	            }
	        });
	        int [] valCols = new int[] {1, 2};
	        double result = DataUtilities.calculateRowTotal(value1, 0, valCols);// call the calculateRowTotal method and passed the variable data and row
	        assertEquals("Expected 135.9", 135.9, result, .000000001d);//verify
	    }
	    
	    //Method double calculateRowTotal(Values2D data, int row, int[] valCols) 
	    @Test(expected = Exception.class)
		 public void testInvalidColumnsForMethodCalculateRowTotal() { //Find Total Row Value using an invalid column with the expectation of an exception to be thrown
			 Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(2));
		             one(values).getColumnCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue(6.5));
		             one(values).getValue(0, 1);
		             will(returnValue(4.0));
		             one(values).getValue(1, 0);
		             will(returnValue(1.5));
		             one(values).getValue(1, 1);
		             will(returnValue(3.0));
		         }
		     });
		     int [] valCols = new int[] {0, 1, 7};
		     double result = DataUtilities.calculateRowTotal(values, 1, valCols);
		 }
	    
	  //Method double calculateColumnTotal(Values2D data, int col, int[] valRows) 
	  	@Test
	      public void testAValidInputUsingEdgeRowsForMethodCalculateColumnTotal() //Find Total Column Value using the first and last row
	      {
	          Mockery mock1 = new Mockery();
	          final Values2D value1 = mock1.mock(Values2D.class);//created a mockery for the value2D class
	          mock1.checking(new Expectations() {
	              {
	                  //setting up mock object
	            	  allowing(value1).getRowCount();
	                  will(returnValue(4));//return value
	                  allowing(value1).getValue(0, 0);
	                  will(returnValue(6.9));////return value
	                  allowing(value1).getValue(1, 0);
	                  will(returnValue(1.3));//return value
	                  allowing(value1).getValue(2, 0);
	                  will(returnValue(134.6));//return value
	                  allowing(value1).getValue(3, 0);
	                  will(returnValue(1));//return value
	                  
	              }
	          });
	          int [] valRow = new int[] {0, 3};
	          double result = DataUtilities.calculateColumnTotal(value1, 0, valRow);// call the calculateColumnTotal method
	          assertEquals(""
	          		+ "Expected value is 7.9", 7.9, result, .000000001d);
	      }
	      
	    //Method double calculateColumnTotal(Values2D data, int col, int[] valRows) 
	  	@Test
	  	public void testAValidInputUsingMiddleColumnsForMethodCalculateColumnTotal() //Find Total Column Value using the middle rows
	      {
	          Mockery mock1 = new Mockery();
	          final Values2D value1 = mock1.mock(Values2D.class);//created a mockery for the value2D class
	          mock1.checking(new Expectations() {
	              {
	                  //setting up mock object
	            	  allowing(value1).getRowCount();
	                  will(returnValue(4));//return value
	                  allowing(value1).getValue(0, 0);
	                  will(returnValue(6.9));////return value
	                  allowing(value1).getValue(1, 0);
	                  will(returnValue(1.3));//return value
	                  allowing(value1).getValue(2, 0);
	                  will(returnValue(134.6));//return value
	                  allowing(value1).getValue(3, 0);
	                  will(returnValue(1));//return value
	                  
	              }
	          });
	          int [] valRow = new int[] {1, 2};
	          double result = DataUtilities.calculateColumnTotal(value1, 0, valRow);// call the calculateColumnTotal method
	          assertEquals(""
	          		+ "Expected value is 135.9", 135.9, result, .000000001d);
	      }
	  	
	  	
	    //Method double calculateColumnTotal(Values2D data, int col, int[] valRows) 
	    @Test(expected = Exception.class)
		 public void testInvalidRowsForMethodCalculateColumnTotal() { //Find Total Column Value using an invalid row with the expectation of an exception to be thrown
			 Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		        	 one(values).getRowCount();
		             will(returnValue(2));
		             one(values).getColumnCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue(6.5));
		             one(values).getValue(0, 1);
		             will(returnValue(4.0));
		             one(values).getValue(1, 0);
		             will(returnValue(1.5));
		             one(values).getValue(1, 1);
		             will(returnValue(3.0));
		         }
		     });
		     int [] valRows = new int[] {0, 1, 9};
		     double result = DataUtilities.calculateColumnTotal(values, 1, valRows);
		 }
	    
//		Testing calculateColumnTotal( Values2D data, int column ) method
		
		//setup
		Mockery mockingContext = new Mockery();
		final Values2D values= mockingContext.mock(Values2D.class);
		
		// This test covers values for 5 rows in method calculateColumnTotalForFiveRows()
		 @Test
		 public void calculateColumnTotalForFiveRows() { // Tests for a column with 5 rows

		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(5));  // Five rows       
		             one(values).getColumnCount();
		             will(returnValue(1));	// One column
		             
		             one(values).getValue(0, 0);
		             will(returnValue(7.5));
		             
		             one(values).getValue(1, 0);
		             will(returnValue(2.5));
		             
		             one(values).getValue(2, 0);
		             will(returnValue(4.5));
		             
		             one(values).getValue(3, 0);
		             will(returnValue(3.0));
		             
		             one(values).getValue(4, 0);
		             will(returnValue(0.0));
		         }
		     });
		     
			//exercise
			double result = DataUtilities.calculateColumnTotal(values, 0);
		     // verify
		    assertEquals(result, 17.5, .000000001d);
		     // tear-down: NONE in this test method
		 }
		 
		 // This test covers negative values for 2 rows in method calculateColumnTotalForTwoRowswithNegValues()
		 @Test
		 public void calculateColumnTotalForTwoRowswithNegValues() { // Tests for a column with 2 rows with negative values
		     
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(2));    // Two rows     
		             one(values).getColumnCount();
		             will(returnValue(1));	// One column
		             
		             one(values).getValue(0, 0);
		             will(returnValue(-8.0));
		             
		             one(values).getValue(1, 0);
		             will(returnValue(-200.5));	           
		         }
		     });
		     
			double result = DataUtilities.calculateColumnTotal(values, 0);
		     // verify
		    assertEquals(result, -208.5, .000000001d);
		 }
		 
		 // This test covers positive and negative values for 3 rows in method calculateColumnTotalForThreeRowswithPosNegValues()
		 @Test
		 public void calculateColumnTotalForThreeRowswithPosNegValues() { // Tests for a column with 3 rows with positive and negative values

		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(3));   // Three rows      
		             one(values).getColumnCount();
		             will(returnValue(1));	// One column
		             
		             one(values).getValue(0, 0);
		             will(returnValue(17.5));
		             
		             one(values).getValue(1, 0);
		             will(returnValue(-2.5));
		             
		             one(values).getValue(2, 0);
		             will(returnValue(-6.0));
		         }
		     });
		     
			double result = DataUtilities.calculateColumnTotal(values, 0);
		     // verify
		    assertEquals(result, 9.0, .000000001d);
		 }
	 
	 

}
