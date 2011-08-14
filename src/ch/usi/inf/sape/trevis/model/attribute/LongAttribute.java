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
 * A LongAttribute can extract a specific long value from a ContextTreeNode.
 * Subclass this class to extract whatever long values you store in your ContextTreeNode subclasses.
 * E.g. in a CCT based on a sampling profile, each node may store the number of samples taken with that node's context,
 * and thus would provide a LongAttribute subclass that retrieves that value.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public abstract class LongAttribute extends NodeAttribute {

	public Type getType() {
		return Type.LONG;
	}

	public final Object getValue(final ContextTreeNode node) {
		return evaluate(node);
	}
	
	public abstract long evaluate(ContextTreeNode node);
	
}
