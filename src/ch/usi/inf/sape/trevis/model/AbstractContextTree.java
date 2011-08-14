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


/**
 * A default implementation of some of the ContextTree functionality.
 * 
 * Subclass this class for your own kinds of ContextTrees.
 * Normally, a subclass would add a constructor that builds a tree
 * (consisting of objects of a ContextTreeNode subclass)
 * from some external source of information
 * (e.g. a trace or profile).
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public abstract class AbstractContextTree implements ContextTree, Serializable {

	private static final long serialVersionUID = 201010317L;
	
	private String name;
	
	
	/**
	 * Set the name (an arbitrary string that briefly describes this tree).
	 */
	public void setName(final String name) {
		this.name = name;
	}
	
	/**
	 * Get the name (the string that briefly describes this tree).
	 */
	public String getName() {
		return name;
	}
	
}
