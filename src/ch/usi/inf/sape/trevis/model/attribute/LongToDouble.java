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
 * Convert the value of a long attribute to a double.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class LongToDouble extends DoubleAttribute {
	
	private final LongAttribute argument;
	private final String name;
	private final String description;
	

	public LongToDouble(final LongAttribute argument) {
		this("(double)", argument);
	}

	public LongToDouble(final String name, final LongAttribute argument) {
		this(name, "(double)"+argument.getName(), argument);
	}

	public LongToDouble(final String name, final String description, final LongAttribute argument) {
		this.argument = argument;
		this.name = name;
		this.description = description;
	}

	public double evaluate(final ContextTreeNode node) {
		return argument.evaluate(node);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
}
