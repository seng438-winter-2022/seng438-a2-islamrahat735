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
	 
	 

}
