package com.Extentreports;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3 {
	
	@Test(priority=1,enabled=false)
	public void test1() {
		Assert.assertTrue(true);
	}

}
