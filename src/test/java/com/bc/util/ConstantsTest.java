package com.bc.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ConstantsTest {

	@Test
	public void validateConstantsVariables() {
		assertNotNull(Constants.APPLICATION_START_MSG);
	}
	
	@Test
	public void validateConstantsVariableValue() {
		String APPLICATION_START_MSG_LOCAL = "################  Sample Rest API Started!  ##########################";
		assertEquals(Constants.APPLICATION_START_MSG, APPLICATION_START_MSG_LOCAL);
	}
	
}
