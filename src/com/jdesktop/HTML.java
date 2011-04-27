package com.jdesktop;

import java.util.*;

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
