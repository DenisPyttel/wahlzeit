/*
 * Copyright (c) 2017 by Denis Pyttel
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * WahlzeitTestSuite
 * 
 * Version 1.0
 * 
 * Date 11.11.2017
 */

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
