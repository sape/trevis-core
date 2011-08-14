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
 * Comparison (prefix) of two string attributes,
 * determining whether the left string starts with the right string.
 * 
 * @see ch.usi.inf.sape.trevis.model.StringMatch
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class StringPrefix extends BooleanAttribute {

	private final String name;
	private final StringAttribute attribute;
	private final StringAttribute prefixAttribute;
	
	
	public StringPrefix(final String name, final StringAttribute attribute, final StringAttribute prefixAttribute) {
		this.name = name;
		this.attribute = attribute;
		this.prefixAttribute = prefixAttribute;
	}
	
	public StringPrefix(final StringAttribute attribute, final StringAttribute prefixAttribute) {
		this.name = null;
		this.attribute = attribute;
		this.prefixAttribute = prefixAttribute;
	}
	
	public String getName() {
		if (name==null) {
			return attribute.getName()+"="+prefixAttribute.getName()+"...";
		} else {
			return name;
		}
	}
	
	public String getDescription() {
		return attribute.getName()+" starts with "+prefixAttribute.getName();
	}
	
	public boolean evaluate(final ContextTreeNode node) {
		return attribute.evaluate(node).startsWith(prefixAttribute.evaluate(node));
	}
	
}
