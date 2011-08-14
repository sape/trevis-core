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


/**
 * Utility methods used by the various Attribute classes.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class Util {

	public static final String buildDescription(final String operator, final NodeAttribute a, final NodeAttribute b) {
		final StringBuffer sb = new StringBuffer("(");
		sb.append(a.getName());
		sb.append(operator);
		sb.append(b.getName());
		return sb.append(")").toString();
	}
	
}
