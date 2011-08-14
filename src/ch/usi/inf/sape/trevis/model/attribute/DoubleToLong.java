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
 * Convert the value of a double attribute to a long.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class DoubleToLong extends LongAttribute {
	
	private final DoubleAttribute argument;
	private final String name;
	private final String description;
	

	public DoubleToLong(final DoubleAttribute argument) {
		this("(long)", argument);
	}

	public DoubleToLong(final String name, final DoubleAttribute argument) {
		this(name, "(long)"+argument.getName(), argument);
	}

	public DoubleToLong(final String name, final String description, final DoubleAttribute argument) {
		this.argument = argument;
		this.name = name;
		this.description = description;
	}

	public long evaluate(final ContextTreeNode node) {
		return (long)argument.evaluate(node);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
}
