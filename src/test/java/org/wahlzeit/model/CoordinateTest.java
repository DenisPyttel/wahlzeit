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
import static org.junit.Assert.assertEquals;

/*
 * CoordinateTest
 * 
 * Version 1.0
 * 
 * Date 29.10.2017
 */

public class CoordinateTest {
	
	@Test
	public void testGetDistance(){
		Coordinate a = new Coordinate(1,1,1);
		Coordinate b = new Coordinate(1,1,2);

		assertEquals(1.0, a.getDistance(b),0.0);		
	}
	
	@Test
	public void testIsEqual(){
		Coordinate a = new Coordinate(1,2,3);
		Coordinate b = new Coordinate(1,2,3);
		Coordinate c = new Coordinate(1,2,4);
		
		assertEquals(true, a.isEqual(b));
		assertEquals(false, a.isEqual(c));		
	}
	
	@Test
	public void testEquals(){
		Coordinate a = new Coordinate(1,2,3);
		Coordinate b = new Coordinate(1,2,3);
		Coordinate c = new Coordinate(1,2,4);
		Coordinate d = null;
		
		assertEquals(true, a.equals(b));
		assertEquals(false, a.equals(c));
		assertEquals(false, a.equals(d));
	}
}
