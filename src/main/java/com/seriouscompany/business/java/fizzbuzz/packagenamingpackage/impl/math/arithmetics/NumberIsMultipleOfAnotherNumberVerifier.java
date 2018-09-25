package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.math.arithmetics;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.ApplicationContextHolder;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.comparators.integercomparator.IntegerForEqualityComparator;

@Service
public class NumberIsMultipleOfAnotherNumberVerifier implements InitializingBean {

	private static IntegerDivider integerDivider;

	@Autowired
	private ApplicationContextHolder applicationContextHolder;

	public void init() {
		final ApplicationContext applicationContext = applicationContextHolder.getApplicationContext();

		NumberIsMultipleOfAnotherNumberVerifier.integerDivider = applicationContext.getBean(IntegerDivider.class);
	}

	public static boolean numberIsMultipleOfAnotherNumber(final int nFirstNumber, final int nSecondNumber) {
		try {
			final int nDivideFirstIntegerBySecondIntegerResult =
					(NumberIsMultipleOfAnotherNumberVerifier.integerDivider.divide(nFirstNumber, nSecondNumber));
			final int nMultiplyDivisionResultBySecondIntegerResult =
					nDivideFirstIntegerBySecondIntegerResult * nSecondNumber;
			if (IntegerForEqualityComparator.areTwoIntegersEqual(nMultiplyDivisionResultBySecondIntegerResult,
					nFirstNumber)) {
				return true;
			} else {
				return false;
			}
		} catch (final ArithmeticException ae) {
			return false;
		}
	}

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
