import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	// package org.wahlzeit.handlers
	org.wahlzeit.handlers.HandlerTestSuite.class,
	// package org.wahlzeit.model
	org.wahlzeit.model.ModelTestSuite.class,
	// package org.wahlzeit.services
	org.wahlzeit.services.ServiceTestSuite.class,
	// package org.wahlzeit.utils
	org.wahlzeit.utils.UtilsTestSuite.class
})

public class WahlzeitTestSuite {

}
