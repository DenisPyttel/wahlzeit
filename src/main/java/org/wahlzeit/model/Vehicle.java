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
 * VehiclePhoto
 * 
 * Version 1.0
 * 
 * Date 11.11.2017
 */

public class Vehicle {

	protected String vehicleBrand;
	protected String vehicleModel;
	protected int vehiclePS;
	protected int maxSpeed;
	
	public Vehicle(String vehicleBrand, String vehicleModel, int vehiclePs, int maxSpeed)
	{
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.vehiclePS = vehiclePs;
		this.maxSpeed = maxSpeed;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public int getVehiclePS() {
		return vehiclePS;
	}

	public void setVehiclePS(int vehiclePs) {
		this.vehiclePS = vehiclePs;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public String asString(){
		return this.vehicleBrand 
				+ ": " + this.vehicleModel 
				+ " PS: " + this.vehiclePS 
				+ " MaxSpeed: " + this.maxSpeed; 
	}
}
