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
 * A NodeAttribute can extract a specific value from a ContextTreeNode.
 * Subclass this class to extract whatever values you store in your ContextTreeNode subclasses
 * (or their associated frames).
 * 
 * E.g. in a CCT, a NodeAttribute may be the name of the method.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public abstract class NodeAttribute {

	public abstract String getName();
	public abstract String getDescription();
	public abstract Type getType();
	public abstract Object getValue(ContextTreeNode node);

}
