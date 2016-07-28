package com.xebia.hr.utils;

public class CommonUtils {

	public static int calculatepercentage(int actualScore, int maxScore) {
		
		return (int) (((float)actualScore /(float)maxScore) * 100.0f);
	}
}
