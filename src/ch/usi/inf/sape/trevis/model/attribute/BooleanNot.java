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
 * Compute the not (!) of a boolean attributes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class BooleanNot extends BooleanAttribute {
	
	private final BooleanAttribute argument;
	private final String name;
	private final String description;
	

	public BooleanNot(final BooleanAttribute argument) {
		this("not", argument);
	}

	public BooleanNot(final String name, final BooleanAttribute argument) {
		this(name, "!"+argument.getName(), argument);
	}

	public BooleanNot(final String name, final String description, final BooleanAttribute argument) {
		this.argument = argument;
		this.name = name;
		this.description = description;
	}

	public boolean evaluate(final ContextTreeNode node) {
		return !argument.evaluate(node);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
}
