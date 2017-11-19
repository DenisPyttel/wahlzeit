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
 * VehiclePhotoTest
 * 
 * Version 1.0
 * 
 * Date 11.11.2017
 */

public class VehiclePhotoTest {
	
	private Vehicle defaultVehicle;
	private VehiclePhoto defaultVehiclePhoto;
	
	@Before
	public void setUp(){
		defaultVehicle = new Vehicle("bmw","1",200,250);
		defaultVehiclePhoto = new VehiclePhoto(defaultVehicle);
	}
	
	@Test
	public void TestGetVehicle(){
		assertEquals("bmw", defaultVehiclePhoto.getVehicle().getVehicleBrand());		
		assertEquals("1", defaultVehiclePhoto.getVehicle().getVehicleModel());
		assertEquals(200, defaultVehiclePhoto.getVehicle().getVehiclePS());
		assertEquals(250, defaultVehiclePhoto.getVehicle().getMaxSpeed());
	}
	
	@Test
	public void TestSetVehicle(){
		defaultVehiclePhoto.getVehicle().setVehicleBrand("mercedes");
		defaultVehiclePhoto.getVehicle().setVehicleModel("C-Klasse");
		assertEquals("mercedes", defaultVehiclePhoto.getVehicle().getVehicleBrand());		
		assertEquals("C-Klasse", defaultVehiclePhoto.getVehicle().getVehicleModel());
	}
}
