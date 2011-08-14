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
 * Convert the value of an attribute of an arbitrary type to a string.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class ToString extends StringAttribute {

	private final NodeAttribute attribute;
	
	
	public ToString(final NodeAttribute attribute) {
		this.attribute = attribute;
	}
	
	public String getName() {
		return "ToString("+attribute.getName()+")";
	}
	
	public String getDescription() {
		return "ToString("+attribute.getDescription()+")";
	}
	
	public String evaluate(final ContextTreeNode node) {
		return attribute.getValue(node).toString();
	}
	
}
