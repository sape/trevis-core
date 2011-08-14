/*
 * This file is licensed to You under the "Simplified BSD License".
 * You may not use this software except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/bsd-license.php
 *
 * See the COPYRIGHT file distributed with this work for information
 * regarding copyright ownership.
 */
package ch.usi.inf.sape.trevis.model.attribute;


/**
 * The type system of trevis attributes supports four types: BOOLEAN, LONG, DOUBLE, and STRING.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public enum Type {

	BOOLEAN("boolean", "false"), LONG("long", "0"), DOUBLE("double", "0.0"), STRING("String", "\"\"");
	
	private final String name;
	private final String defaultValueString;
	
	
	private Type(final String name, final String defaultValueString) {
		this.name = name;
		this.defaultValueString = defaultValueString;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDefaultValueString() {
		return defaultValueString;
	}
	
}
