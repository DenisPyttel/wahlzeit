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
 * SphericCoordinate
 * 
 * Version 1.0
 * 
 * Date 17.11.2017
 */

public class SphericCoordinate implements Coordinate{

	private double latitude;
	private double longitude;
	private double radius;
	private static final double epsilon = 0.00000001d;
	
	public SphericCoordinate(double latitude, double longitude, double radius){
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	public SphericCoordinate asSphericCoordinate(){
		return this;
	}
	
	public CartesianCoordinate asCartesianCoordinate(){
		return new CartesianCoordinate(this.radius * Math.sin(this.longitude) * Math.cos(this.latitude),
				this.radius * Math.sin(this.longitude) * Math.sin(this.latitude),
				this.radius * Math.cos(longitude));
	}
	
	public double getSphericDistance(Coordinate coordinate){
		double temp = this.radius * Math.sqrt(2- 2 * Math.cos(this.latitude - coordinate.asSphericCoordinate().getLatitude()) + 
				2 * Math.cos(this.latitude) * Math.cos(coordinate.asSphericCoordinate().getLatitude()) *
				(1 - Math.cos(this.longitude - coordinate.asSphericCoordinate().getLongitude())));
		return temp;
	}
	
	public double getCartesianDistance(Coordinate coordinate){
		return this.asCartesianCoordinate().getCartesianDistance(coordinate);
	}
	
	public double getDistance(Coordinate coordinate){
		if(coordinate instanceof SphericCoordinate){
			return this.getSphericDistance(coordinate);
		}
		else if(coordinate instanceof CartesianCoordinate){
			return this.getSphericDistance(coordinate.asSphericCoordinate());
		}
		else{
			return 0.0d;
		}
	}
	
	/**
	 * Vergleicht zwei Double Werte ob diese identisch sind
	 */
	private boolean isDoubleEqual(double a, double b)
	{
		if(Math.abs(a-b)< epsilon){
			return true;
		}
		return false;
	}
	
	/**
	 * Vergleicht zwei Coordinaten ob diese identisch sind
	 */
	public boolean isEqual(Coordinate coordinate){
		if(coordinate instanceof SphericCoordinate){
			if(isDoubleEqual(this.latitude,coordinate.asSphericCoordinate().getLatitude()) && isDoubleEqual(this.longitude,coordinate.asSphericCoordinate().getLongitude()) && isDoubleEqual(this.radius,coordinate.asSphericCoordinate().getRadius())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	/**
	 *  Override der Methode equals die zwei Coordinaten mit der Methode isEqual vergleicht
	 */
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof SphericCoordinate){
			return this.isEqual((SphericCoordinate) obj);
		}
		return false;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
}
