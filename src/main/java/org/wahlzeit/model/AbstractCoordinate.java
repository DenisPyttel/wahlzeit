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
 * AbstractCoordinate
 * 
 * Version 1.0
 * 
 * Date 21.11.2017
 */

public abstract class AbstractCoordinate implements Coordinate {

	private static final double epsilon = 0.00000001d;
	
	public abstract CartesianCoordinate asCartesianCoordinate();
	public abstract SphericCoordinate asSphericCoordinate();
	public abstract boolean isEqual(Coordinate coordinate);
	
	/**
	 * 
	 */
	public double getSphericDistance(Coordinate coordinate){
		return this.asSphericCoordinate().getRadius() * Math.sqrt(2- 2 * Math.cos(this.asSphericCoordinate().getLatitude() - coordinate.asSphericCoordinate().getLatitude()) + 
				2 * Math.cos(this.asSphericCoordinate().getLatitude()) * Math.cos(coordinate.asSphericCoordinate().getLatitude()) *
				(1 - Math.cos(this.asSphericCoordinate().getLongitude() - coordinate.asSphericCoordinate().getLongitude())));
	}
	
	/**
	 * 
	 */
	public double getCartesianDistance(Coordinate coordinate){
		return Math.sqrt(Math.pow(Math.abs(this.asCartesianCoordinate().getX() -  coordinate.asCartesianCoordinate().getX()), 2.0)  + 
				Math.pow(Math.abs(this.asCartesianCoordinate().getY() - coordinate.asCartesianCoordinate().getY()), 2.0) + 
				Math.pow(Math.abs(this.asCartesianCoordinate().getZ() - coordinate.asCartesianCoordinate().getZ()), 2.0));
	}

	/**
	 * 
	 */
	public double getDistance(Coordinate coordinate){
		return this.asCartesianCoordinate().getCartesianDistance(coordinate);
	}
	
	/**
	 * Vergleicht zwei Double Werte ob diese identisch sind
	 */
	protected boolean isDoubleEqual(double a, double b)
	{
		if(Math.abs(a-b)< epsilon){
			return true;
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
		if(obj instanceof Coordinate){
			return this.isEqual((Coordinate) obj);
		}
		return false;
	}
	
}
