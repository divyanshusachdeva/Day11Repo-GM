package com.graymatter;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({AppTest.class, TestCalculator.class})
//@RunWith(Suite.class)


//The below is used to run certain test cases and not all.
// For example, 1 class is given with MarkerInterface so only 1 case was tested.

@IncludeCategory(MarkerInterface.class)
@RunWith(Categories.class)

public class TestRunner {

	
	
}
