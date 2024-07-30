package com.graymatter;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
	
	@Test
	public void testPrintName() {
		assertEquals("Divyanshu", App.printName("Divyanshu"));
		
	}


}
