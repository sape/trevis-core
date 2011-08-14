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
 * Negate (-) the value of a double attribute.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class DoubleNegation extends DoubleAttribute {
	
	private final DoubleAttribute argument;
	private final String name;
	private final String description;
	

	public DoubleNegation(final DoubleAttribute argument) {
		this("-", argument);
	}

	public DoubleNegation(final String name, final DoubleAttribute argument) {
		this(name, "-"+argument.getName(), argument);
	}

	public DoubleNegation(final String name, final String description, final DoubleAttribute argument) {
		this.argument = argument;
		this.name = name;
		this.description = description;
	}

	public double evaluate(final ContextTreeNode node) {
		return -argument.evaluate(node);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
}
