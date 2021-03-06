/*
 *	  This file is part of the Bytewalla Project
 *    More information can be found at "http://www.tslab.ssvl.kth.se/csd/projects/092106/".
 *    
 *    Copyright 2009 Telecommunication Systems Laboratory (TSLab), Royal Institute of Technology, Sweden.
 *    
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *    
 */
package se.kth.ssvl.tslab.bytewalla.androiddtn.systemlib.util;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Generic List used in AnroidDTN. This list is made by extending Java ArrayList
 * @author Rerngvit Yanggratoke (rerngvit@kth.se)
 */
public class List<T> extends ArrayList<T> implements Serializable{

	/**
	 * Unique identifier according to Java Serializable specification
	 */
	private static final long serialVersionUID = 1850296177208192183L;

	
	/**
	 * Get the first element of the list 
	 * @return the first element. And, null, if it's impossible to peak
	 */
	public final T front()
	{
		if (this.size() > 0) return get(0);
		else return null;
	}
	
	/**
	 * Get the last element of the list
	 * @return the last element. And, null, if it's impossible to peak.
	 */
	public final T back()
	{
		if (this.size() > 0) return get(this.size() - 1);
		else return null;
	}

}
