package com.test.kerja.sqa.web.driver;

import com.test.kerja.sqa.web.utils.ConstantsDriver;

public class DriverStrategyImplementor {
	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case ConstantsDriver.CHROME:
			return new Chrome();

		case ConstantsDriver.FIREFOX:
			return new FireFox();

		default:
			return null;
		}
	}
}
