package com.bc.model;

import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class EmployeeTest {

	@Test
	public void validateGettersAndSetters() {
		PojoClass personPojo = PojoClassFactory.getPojoClass(Employee.class);
		Validator validator = ValidatorBuilder.create().
				with(new SetterMustExistRule(), new GetterMustExistRule())
				.with(new SetterTester(), new GetterTester()).build();
		validator.validate(personPojo);
	}

}
