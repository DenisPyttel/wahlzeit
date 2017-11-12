package org.wahlzeit.model;

import org.wahlzeit.model.persistence.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	// package org.wahlzeit.model
	AccessRightsTest.class,
	CoordinateTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	// package org.wahlzeit.model.persistence
	DatastoreAdapter.class,
	AbstractAdapterTest.class
})

public class ModelTestSuite {

}
