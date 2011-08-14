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
 * Compute the length of the string.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class StringLength extends LongAttribute {

	private final StringAttribute argument;
	
	
	public StringLength(final StringAttribute argument) {
		this.argument = argument;
	}
	
	public String getName() {
		return "StringLength("+argument.getName()+")";
	}
	
	public String getDescription() {
		return "StringLength("+argument.getDescription()+")";
	}
	
	public long evaluate(final ContextTreeNode node) {
		return argument.evaluate(node).length();
	}
	
}
