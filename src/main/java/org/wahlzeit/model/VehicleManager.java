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

/*
 * VehicleManager
 * 
 * Version 1.0
 * 
 * Date 12.01.2018
 */

public class VehicleManager {

	protected VehicleType vehicleType;
	protected static VehicleManager instance = new VehicleManager();
	
	private VehicleManager(){
		vehicleType = new VehicleType();
	}
	
	public static synchronized VehicleManager getInstance(){
		if (instance == null){
			instance = new VehicleManager();
		}
		return instance;
	}
	
	public VehicleType createVehicleType(String model){
		return vehicleType.createVehicleType(model);
	}
	
	public VehicleType createVehicleType(String model, int vehiclePS, int maxSpeed){
		return vehicleType.createVehicleType(model, vehiclePS, maxSpeed);
	}
	
	public Vehicle createVehicle(String vehicleNumber, String model){
		return new Vehicle(vehicleNumber, vehicleType.createVehicleType(model));
	}
	
	public Vehicle createVehicle(String vehicleNumber, String model, int vehiclePS, int maxSpeed){
		return new Vehicle(vehicleNumber, vehicleType.createVehicleType(model, vehiclePS, maxSpeed));
	}
}
