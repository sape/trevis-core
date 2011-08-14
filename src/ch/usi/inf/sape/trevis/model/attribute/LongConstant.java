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
 * A constant long value.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class LongConstant extends LongAttribute {
	
	private final long value;
	private final String name;
	private final String description;
	
	
	public LongConstant(final long value) {
		this(""+value, ""+value, value);
	}

	public LongConstant(final String name, final long value) {
		this(name, name, value);
	}

	public LongConstant(final String name, final String description, final long value) {
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
	
	public long evaluate(final ContextTreeNode node) {
		return value;
	}
	
}
