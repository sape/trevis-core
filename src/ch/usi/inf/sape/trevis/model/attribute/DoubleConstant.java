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

import ch.usi.inf.sape.trevis.model.ContextTreeNode;


/**
 * A constant double value.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class DoubleConstant extends DoubleAttribute {
	
	private final double value;
	private final String name;
	private final String description;
	
	
	public DoubleConstant(final double value) {
		this(""+value, ""+value, value);
	}

	public DoubleConstant(final String name, final double value) {
		this(name, name, value);
	}

	public DoubleConstant(final String name, final String description, final double value) {
		this.name = name;
		this.description = description;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double evaluate(final ContextTreeNode node) {
		return value;
	}
	
}
