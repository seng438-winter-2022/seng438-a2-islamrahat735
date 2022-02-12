package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range exampleRange5;
    private Range exampleRange6;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUpOne() throws Exception { exampleRange1 = new Range(-3, 1);
    }
    
    @Test
    public void isStringNegLow() { //Negative Lower Bound
    	assertEquals("The string should be Range[-3.0,1.0]", "Range[-3.0,1.0]", exampleRange1.toString());
    }
    
    @Before
    public void setUpTwo() throws Exception { exampleRange2 = new Range(0, 3);
    }
    
    @Test
    public void isStringZeroLow() { //Zero Lower Bound
    	assertEquals("The string should be Range[0.0,3.0]", "Range[0.0,3.0]", exampleRange2.toString());
    }
    
    @Before
    public void setUpThree() throws Exception { exampleRange3 = new Range(1, 3);
    }
    
    @Test
    public void isStringPosLow() { //Positive Lower Bound
    	assertEquals("The string should be Range[1.0,3.0]", "Range[1.0,3.0]", exampleRange3.toString());
    }
    
    @Before
    public void setUpFour() throws Exception { exampleRange4 = new Range(-3, -1);
    }
    
    @Test
    public void isStringNegHi() { //Negative Upper Bound
    	assertEquals("The string should be Range[-3.0,-1.0]", "Range[-3.0,-1.0]", exampleRange4.toString());
    }
    
    @Before
    public void setUpFive() throws Exception { exampleRange5 = new Range(-1, 0);
    }
    
    @Test
    public void isStringZeroHi() { //Zero Upper Bound
    	assertEquals("The string should be Range[-1.0,0.0]", "Range[-1.0,0.0]", exampleRange5.toString());
    }
    
    @Before
    public void setUpSix() throws Exception { exampleRange6 = new Range(1, 3);
    }
    
    @Test
    public void isStringPosHi() { //Positive Upper Bound
    	assertEquals("The string should be Range[1.0,3.0]", "Range[1.0,3.0]", exampleRange6.toString());
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}