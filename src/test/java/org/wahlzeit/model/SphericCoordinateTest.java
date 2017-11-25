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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * SphericCoordinateTest
 * 
 * Version 1.0
 * 
 * Date 17.11.2017
 */

public class SphericCoordinateTest {

	private SphericCoordinate a;
	private SphericCoordinate b;
	private SphericCoordinate c;
	private SphericCoordinate d;
	private SphericCoordinate e;
	
	@Before
	public void setUp(){
		a = new SphericCoordinate(1.0d,1.0d,1.0d);
		b = new SphericCoordinate(2.0d,2.0d,2.0d);
		c = new SphericCoordinate(3.0d,3.0d,3.0d);
		d = new SphericCoordinate(1.0d,1.0d,1.0d);
		e = null;
	}
	
	@Test
	public void testIsEqual(){
		assertEquals(false, a.isEqual(b));
		assertEquals(false, a.isEqual(c));
		assertEquals(true, a.isEqual(d));
		assertEquals(true, a.isEqual(a));		
	}
	
	@Test
	public void testEquals(){		
		assertEquals(false, a.equals(b));
		assertEquals(false, a.equals(c));
		assertEquals(true, a.equals(d));
		assertEquals(false, a.equals(e));	
	}
	
	@Test
	public void testAsCartesianCoordinate(){
		assertEquals(true, a.isEqual(d.asCartesianCoordinate().asSphericCoordinate()));
		assertEquals(true, b.isEqual(b.asCartesianCoordinate().asSphericCoordinate()));
		assertEquals(false, a.isEqual(b.asCartesianCoordinate().asSphericCoordinate()));
	}
	
	@Test
	public void testAsSphericCoordinate(){
		assertEquals(true, a.isEqual(a.asSphericCoordinate()));
		assertEquals(false, a.isEqual(b.asSphericCoordinate()));
	}
	
	@Test
	public void testGetDistance(){
		assertEquals(0.0d, a.getDistance(a), 0.00000001d);
		assertEquals(2.0605185659442626d, a.getDistance(b), 0.00000001d);
	}
	
	@Test
	public void testGetSphericDistance(){
		assertEquals(0.0d, a.getSphericDistance(a),0.00000001d);			
		assertEquals(0.8442001211267167d, a.getSphericDistance(b),0.00000001d);
		assertEquals(1.1477426981095216d, a.getSphericDistance(c),0.00000001d);
		assertEquals(0.8442001211267167d, a.getSphericDistance(b.asSphericCoordinate().asCartesianCoordinate()),0.00000001d);
	}
}
