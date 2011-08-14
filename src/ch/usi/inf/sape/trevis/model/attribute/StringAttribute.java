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
 * A StringAttribute can extract a specific String value from a ContextTreeNode.
 * Subclass this class to extract whatever String values you store in your ContextTreeNode subclasses.
 * E.g. in a CCT based on a sampling profile, each node may store the name of the method or class the node represents.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public abstract class StringAttribute extends NodeAttribute {

	public final Type getType() {
		return Type.STRING;
	}
	
	public Object getValue(final ContextTreeNode node) {
		return evaluate(node);
	}
	
	public abstract String evaluate(ContextTreeNode node);

}
