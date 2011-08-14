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
 * A constant string value.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class StringConstant extends StringAttribute {

	private final String value;
	private final String name;
	private final String description;
	
	
	public StringConstant(final String value) {
		this(value, value, value);
	}

	public StringConstant(final String name, final String value) {
		this(name, name, value);
	}

	public StringConstant(final String name, final String description, final String value) {
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
	
	public String evaluate(final ContextTreeNode node) {
		return value;
	}
	
}
