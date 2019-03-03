package com.crmpro.qa.testdata;

import org.testng.annotations.DataProvider;

import com.crmpro.qa.utils.TestUtils;

public class TestdataProvider  {
	
	@DataProvider(name="dataP1")
	public Object[][] getCRMTestData1(){
		String sheetName ="Credentials1";
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
	@DataProvider(name="dataP2")
	public Object[][] getCRMTestData2(){
		String sheetName ="Credentials2";
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
}
