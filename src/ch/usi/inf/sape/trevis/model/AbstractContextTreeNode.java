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
package ch.usi.inf.sape.trevis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * An default implementation of some of the ContextTreeNode functionality.
 * To be subclassed.
 *
 * @author Matthias.Hauswirth@usi.ch
 */
public abstract class AbstractContextTreeNode implements ContextTreeNode, Serializable {
	
	private static final long serialVersionUID = -3852930314266670705L;
		
	private final Object label;
	private ContextTreeNode parent;
	private final ArrayList<ContextTreeNode> children;
	
	
	public AbstractContextTreeNode(final Object label) {
		this.label = label;
		children = new ArrayList<ContextTreeNode>();
	}
	
	//--- construction (only call these methods while building the tree)
	public final void connectChild(final AbstractContextTreeNode child) {
		children.add(child);
		child.parent = this;
	}
		
	public final void disconnectChild(final AbstractContextTreeNode child) {
		children.remove(child);
		child.parent = null;
	}
		
	
	//--- query
	public final Object getLabel() {
		return label;
	}

	public final ContextTreeNode getParent() {
		return parent;
	}
	
	public final Iterator<ContextTreeNode> iterator() {
		return children.iterator();
	}
	
	public final int getChildCount() {
		return children.size();
	}
	
	public final ContextTreeNode getChild(final int index) {
		return children.get(index);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public final ContextTreeNode getChild(final Object label) {
		for (final ContextTreeNode child : children) {
			if (child.getLabel().equals(label)) {
				return child;
			}
		}
		return null;
	}

	public final int indexOfChild(final ContextTreeNode child) {
		return children.indexOf(child);
	}
	
	public final boolean isRoot() {
		return getParent()==null;
	}	
	
}
