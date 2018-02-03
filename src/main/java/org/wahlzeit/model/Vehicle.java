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

	protected String vehicleNumber;
	protected VehicleType vehicleType;
	
	public Vehicle(String vehicleNumber, VehicleType vehicleType)
	{
		//Preconditions
		//assertIsValidIntegerValue(vehiclePs);
		//assertIsValidIntegerValue(maxSpeed);
		
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
	}
	
	/**
	 * @methodtype get
	 */
	public VehicleType getVehicleType(){
		return vehicleType;
	}
	
	/**
	 * @methodtype set
	 */
	public void setVehicleType(VehicleType vehicleType){
		this.vehicleType = vehicleType;
	}
	
	/**
	 * @methodtype get
	 */
	public String getVehicleNumber(){
		return vehicleNumber;
	}
	
	/**
	 * @methodtype set
	 */
	public void setVehicleNumber(String vehicleNumber){
		this.vehicleNumber = vehicleNumber;
	}
	
	public String asString(){
		return vehicleType.asString() + " Kennzeichen: " + this.vehicleNumber; 
	}
	
	public void assertIsValidIntegerValue(int i){
		if(i > Integer.MAX_VALUE){
			throw new IllegalArgumentException("integer value should not be greater than " + Integer.MAX_VALUE);
		}
	}
}
