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
 * CartesianCoordinate
 * 
 * Version 1.0
 * 
 * Date 29.10.2017
 */

public class CartesianCoordinate extends AbstractCoordinate{

	private double x,y,z;
	
	public CartesianCoordinate(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * 
	 */
	public CartesianCoordinate asCartesianCoordinate(){
		return this;
	}

	/**
	 * Converts the CartesianCoordinate into a SphericCoordinate
	 */
	public SphericCoordinate asSphericCoordinate(){
		assertIsValidRadicand(this.x * this.x + this.y * this.y + this.z * this.z);
		assertIsValidDivisor(Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z));
		
		double latitude = Math.atan2(this.y, this.x);
		double longitude = Math.acos(this.z / (Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z)));
		double radius = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
		
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
			
		return new SphericCoordinate(latitude, longitude, radius);
	}
	
	/**
	 * Vergleicht zwei Coordinaten ob diese identisch sind
	 */
	public boolean isEqual(Coordinate coordinate){
		if(coordinate instanceof CartesianCoordinate){
			if(isDoubleEqual(this.x,coordinate.asCartesianCoordinate().getX()) && isDoubleEqual(this.y,coordinate.asCartesianCoordinate().getY()) && isDoubleEqual(this.z,coordinate.asCartesianCoordinate().getZ())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @methodtype set
	 */
	public void setZ(int z) {
		this.z = z;
	}
}
