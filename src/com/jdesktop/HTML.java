package com.jdesktop;

import java.util.*;

/*
	This file is part of JDesktop.

	JDesktop is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	JDesktop is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with JDesktop.  If not, see <http://www.gnu.org/licenses/>.
*/

public class HTML {
	
	/**
	 * Place HTML in head
	 */
	public static final int HEAD = 1;
	
	/**
	 * Place HTML in body
	 */
	public static final int BODY = 2;
	
	private List<String> html;
	
	public HTML() {
		html = new ArrayList<String>();
		
		html.add("<html>");
		html.add("<head>");
		html.add("</head>");
		html.add("<body>");
		html.add("</body>");
		html.add("</html>");
	}
	
	/**
	 * 
	 * @param place Whether to put HTML in head or body
	 * @param html The HTML code
	 */
	public void addHTML(int place, List<String> html) {
		if (place != HTML.HEAD && place != HTML.BODY)
			return;
		
		switch (place) {
		
		case HTML.HEAD:
			int hcount = this.html.indexOf("<head>")+1;
			this.html.addAll(hcount, html);
			
			break;
			
		case HTML.BODY:
			int bcount = this.html.indexOf("<body>")+1;
			this.html.addAll(bcount, html);
			
			break;
			
		}
	}
	
	public List<String> getHTML() {
		return html;
	}
	
}
