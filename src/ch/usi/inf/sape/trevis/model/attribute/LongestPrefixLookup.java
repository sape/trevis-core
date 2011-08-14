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

import java.util.HashSet;
import java.util.Set;

import ch.usi.inf.sape.trevis.model.ContextTreeNode;


/**
 * A StringAttribute matching the evaluated argument against the given list of prefixes,
 * and returning the longest prefix that matches.
 * 
 * This can be used to categorize package names into a few meaningful groups, or "components".
 * The component name (the String returned by this attribute)
 * can then be used to determine the hue of a node.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class LongestPrefixLookup extends StringAttribute {
	
	private final String name;
	private final StringAttribute argument;
	private final char separator;
	private final Set<String> prefixSet;
	private final String defaultValue;
	
	
	public LongestPrefixLookup(final String name, final StringAttribute argument, final char separator, final String[] prefixes, final String defaultValue) {
		this.name = name;
		this.argument = argument;
		this.separator = separator;
		this.defaultValue = defaultValue;
		prefixSet = new HashSet<String>();
		for (int i=0; i<prefixes.length; i++) {
			prefixSet.add(prefixes[i]);
		}
	}

	public String evaluate(final ContextTreeNode node) {
		final String path = argument.evaluate(node);
		if (path!=null) {
			return lookup(path);
		} else {
			return null;
		}
	}
	
	private String lookup(final String path) {
		String part = path;
		while (true) {
			if (prefixSet.contains(part)) {
				return part;
			}
			final int lastSeparator = part.lastIndexOf(separator);
			if (lastSeparator<0) {
				return defaultValue;
			} else {
				part = part.substring(0, lastSeparator);
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return name;
	}
	
}
