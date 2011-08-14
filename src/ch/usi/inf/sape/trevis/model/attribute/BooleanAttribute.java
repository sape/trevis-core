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
 * A NodeAttribute that returns a boolean value.
 * BooleanAttributes (predicates) are e.g. used to highlight certain nodes
 * (e.g. all nodes corresponding to a function with name "bla").
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public abstract class BooleanAttribute extends NodeAttribute {

	public final Type getType() {
		return Type.BOOLEAN;
	}
	
	public Object getValue(final ContextTreeNode node) {
		return evaluate(node);
	}
	
	public abstract boolean evaluate(ContextTreeNode node);
	
}
