package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	// package org.wahlzeit.services
	EmailAddressTest.class,
	LogBuilderTest.class,
	// package org.wahlzeit.services.mailing
	org.wahlzeit.services.mailing.EmailServiceTest.class
})

public class ServiceTestSuite {

}
