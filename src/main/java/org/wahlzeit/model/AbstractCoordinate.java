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

	protected static final double epsilon = 0.00000001d;
	
	public abstract CartesianCoordinate asCartesianCoordinate();
	public abstract SphericCoordinate asSphericCoordinate();
	public abstract boolean isEqual(Coordinate coordinate);
	protected abstract void assertClassInvariants();
	
	public double getSphericDistance(Coordinate coordinate){
		assertClassInvariants();
		//Preconditions
		assertCoordinateNotNull(coordinate);
		
		double sphericDistance = doGetSphericDistance(coordinate);
		
		//Postconditions
		assertIsValidDoubleValue(sphericDistance);		
		assertClassInvariants();
		return sphericDistance;
	}
	
	/**
	 * Calculate the distance of two SphericCoordinates
	 */
	protected double doGetSphericDistance(Coordinate coordinate){
		double radicand = 2 - 2 * Math.cos(this.asSphericCoordinate().getLatitude() - coordinate.asSphericCoordinate().getLatitude()) + 
				2 * Math.cos(this.asSphericCoordinate().getLatitude()) * Math.cos(coordinate.asSphericCoordinate().getLatitude()) *
				(1 - Math.cos(this.asSphericCoordinate().getLongitude() - coordinate.asSphericCoordinate().getLongitude()));
		
		assertIsValidRadicand(radicand);
		return this.asSphericCoordinate().getRadius() * Math.sqrt(radicand);
	}
	
	public double getCartesianDistance(Coordinate coordinate){
		assertClassInvariants();
		//Preconditions
		assertCoordinateNotNull(coordinate);
		
		double cartesianDistance = doGetCartesianDistance(coordinate);
		
		//Postconditions
		assertIsValidDoubleValue(cartesianDistance);
		assertClassInvariants();
		return cartesianDistance;
	}
	
	/**
	 * Calculate the distance of two CartesianCoordinates (Euclidean distance)
	 */
	private double doGetCartesianDistance(Coordinate coordinate){		
		double radicand = Math.pow(Math.abs(this.asCartesianCoordinate().getX() -  coordinate.asCartesianCoordinate().getX()), 2.0)  + 
				Math.pow(Math.abs(this.asCartesianCoordinate().getY() - coordinate.asCartesianCoordinate().getY()), 2.0) + 
				Math.pow(Math.abs(this.asCartesianCoordinate().getZ() - coordinate.asCartesianCoordinate().getZ()), 2.0);
		
		assertIsValidRadicand(radicand);
		return Math.sqrt(radicand);
	}

	/**
	 * 
	 */
	public double getDistance(Coordinate coordinate){
		assertClassInvariants();		
		//Preconditions
		assertCoordinateNotNull(coordinate);
		
		double distance = this.asCartesianCoordinate().getCartesianDistance(coordinate);
		
		//Postconditions
		assertIsValidDoubleValue(distance);
		assertClassInvariants();
		return distance;
	}
	
	/**
	 * Compares two double parameter if they are equal
	 */
	protected static boolean isDoubleEqual(double a, double b){
		if(Math.abs(a-b)< epsilon){
			return true;
		}
		return false;
	}
	
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
	
	protected void assertIsValidDivisor(double divisor){
		if(divisor == 0.00000d){
			throw new IllegalArgumentException("divisor should not be 0");
		}
	}
	
	protected void assertIsValidRadicand(double radicand){
		if(radicand < 0.00000d){
			throw new IllegalArgumentException("radicand should not be negative");
		}
	}
	
	protected void assertIsValidLatitude(double latitude){
		if(latitude < 0.00000d || latitude >= (2*Math.PI)){
			throw new IllegalArgumentException("latitude [0,2*PI)");
		}
	}
	
	protected void assertIsValidLongitude(double longitude){
		if(longitude < 0.00000d || longitude > Math.PI)
		{
			throw new IllegalArgumentException("longitude [0,PI]");
		}
	}
	
	protected void assertIsValidRadius(double radius){
		if(radius < 0){
			throw new IllegalArgumentException("raidus should be a positive double value");
		}
	}

	protected void assertIsValidDoubleValue(double d){
		if(d > Double.MAX_VALUE){
			throw new IllegalArgumentException("double value should not be greater than " + Double.MAX_VALUE);
		}
	}
	
	protected void assertCoordinateNotNull(Coordinate coordinate){
		if(coordinate == null){
			throw new IllegalArgumentException("coordinate should not be null");
		}
	}
}
