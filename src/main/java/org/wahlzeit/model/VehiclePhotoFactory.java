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

import org.wahlzeit.services.LogBuilder;

/*
 * VehiclePhotoFactory
 * 
 * Version 1.0
 * 
 * Date 11.11.2017
 */

public class VehiclePhotoFactory extends PhotoFactory {

	private static VehiclePhotoFactory instance = null;
	
	protected VehiclePhotoFactory(){
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized VehiclePhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic VehiclePhotoFactory").toString());
			setInstance(new VehiclePhotoFactory());
		}
		return instance;
	}

	/**
	 * Method to set the singleton instance of VehiclePhotoFactory.
	 */
	protected static synchronized void setInstance(VehiclePhotoFactory vehiclePhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize VehiclePhotoFactory twice");
		}

		instance = vehiclePhotoFactory;
	}
	
	@Override
	public VehiclePhoto createPhoto(PhotoId id){
		VehiclePhoto defaultVehiclePhoto = new VehiclePhoto(id, new Vehicle("default", "default", 200, 240));
		return defaultVehiclePhoto;
	}
	
	public VehiclePhoto createPhoto(PhotoId id, Vehicle vehicle){
		VehiclePhoto vehiclePhoto = new VehiclePhoto(id, vehicle);
		return vehiclePhoto;
	}
}
