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
import static org.junit.Assert.assertNotNull;

/*
 * VehiclePhotoFactoryTest
 * 
 * Version 1.0
 * 
 * Date 11.11.2017
 */

public class VehiclePhotoFactoryTest {
	
	@Test
	public void TestGetInstance(){
		assertNotNull(VehiclePhotoFactory.getInstance());
	}
	
	@Test
	public void TestCreatePhoto(){
		VehiclePhotoFactory instance = VehiclePhotoFactory.getInstance();
		Vehicle vehicle = new Vehicle("Mercedes", "C-Klasse",200,300);
		VehiclePhoto vehiclePhoto = instance.createPhoto(vehicle);
		assertNotNull(vehiclePhoto);
	}
}
