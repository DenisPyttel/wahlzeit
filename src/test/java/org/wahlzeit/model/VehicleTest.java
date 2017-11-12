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

package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

/*
 * VehicleTest
 * 
 * Version 1.0
 * 
 * Date 11.11.2017
 */

public class VehicleTest {

	private Vehicle bmw_1;
	private Vehicle mercedes_c;
	
	@Before
	public void setUp(){
		bmw_1 = new Vehicle("BMW", "1", 150, 200);
		mercedes_c = new Vehicle("Mercedes", "C-Klasse", 200,250);
	}
	
	@Test
	public void TestAsString(){
		assertEquals("BMW: 1 PS: 150 MaxSpeed: 200",bmw_1.asString());
		assertEquals("Mercedes: C-Klasse PS: 200 MaxSpeed: 250",mercedes_c.asString());
	}
}
