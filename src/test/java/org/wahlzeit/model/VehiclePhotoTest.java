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
	
	private Vehicle vehicle;
	private VehiclePhoto vehiclePhoto;
	
	@Before
	public void setUp(){
		vehicle = new Vehicle("AAA AAA", VehicleManager.getInstance().createVehicleType("BMW"));
		vehiclePhoto = new VehiclePhoto(vehicle);
	}
	
	@Test
	public void TestGetVehicle(){
		String temp = vehiclePhoto.getVehicle().getVehicleNumber();
		System.out.println(temp);
		assertEquals("AAA AAA", vehiclePhoto.getVehicle().getVehicleNumber());
		assertEquals("BMW", vehiclePhoto.getVehicle().getVehicleType().getModel());		
	}
	
	@Test
	public void TestSetVehicle(){
		vehiclePhoto.getVehicle().setVehicleNumber("BBB BBB");
		assertEquals("BBB BBB", vehiclePhoto.getVehicle().getVehicleNumber());
	}
}
