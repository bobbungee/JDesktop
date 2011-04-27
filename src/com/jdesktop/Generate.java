package com.jdesktop;

import java.io.File;
import java.util.*;

public class Generate {
	
	public static final List<String> OPERATIONS = Arrays.asList(new String[] {"background", "color", "flash", "applet"});
	public static final int[] PLACES			= {HTML.HEAD, HTML.HEAD, HTML.BODY, HTML.BODY};
	
	public static List<String> generate(int operation, String value) {
		
		if (Generate.OPERATIONS.indexOf("background") == operation)
			return background(value);
		else if (Generate.OPERATIONS.indexOf("color") == operation)
			return color(value);
		else if (Generate.OPERATIONS.indexOf("flash") == operation)
			return flash(value);
		else if (Generate.OPERATIONS.indexOf("applet") == operation)
			return applet(value);
		
		return null;
	}
	
	private static List<String> background(String value) {
		List<String> html = new ArrayList<String>();
		
		html.add("<style type=\"text/css\">");
		html.add("body {background-image:url('"+value+"');background-repeat:no-repeat;}");
		html.add("</style>");
		
		return html;
	}
	
	private static List<String> color(String value) {
		List<String> html = new ArrayList<String>();
		
		html.add("<style type=\"text/css\">");
		html.add("body {background-color:"+value+";}");
		html.add("</style>");
		
		return html;
	}
	
	private static List<String> flash(String value) {
		List<String> html = new ArrayList<String>();
		
		html.add("<object width=\""+Desktop.WIDTH+"\" height=\""+Desktop.HEIGHT+"\">");
		html.add("<param name=\"movie\" value=\""+value+"\">");
		html.add("<embed src=\""+value+"\" width=\""+Desktop.WIDTH+"\" height=\""+Desktop.HEIGHT+"\">");
		html.add("</embed>");
		html.add("</object>");
		
		return html;
	}
	
	private static List<String> applet(String value) {
		List<String> html = new ArrayList<String>();
		
		html.add("<applet codebase=\""+value.substring(0, value.lastIndexOf(File.separator))+"\"");
		
		if (value.substring(value.lastIndexOf('.')).equals("jar"))
			html.add(" archive=\""+value.substring(value.lastIndexOf(File.separator)+1)+"\">");
		else
			html.add(" code=\""+value.substring(value.lastIndexOf(File.separator)+1)+"\">");
			
		html.add("</applet>");
		
		return html;
	}

}
