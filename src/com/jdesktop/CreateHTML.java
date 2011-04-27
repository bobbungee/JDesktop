package com.jdesktop;

import java.util.*;
import java.io.*;

public class CreateHTML {
	
	private static HTML html;
	private static Loader loader;
	private static BufferedWriter bw;
	
	public static void main(String args[]) throws IOException {
		html = new HTML();
		loader = new Loader(new File("desktop.ini"));
		bw = new BufferedWriter(new FileWriter(new File("Desktop.htt")));
		Properties file = loader.getProperties();
		Set<Object> keys = file.keySet();
		Iterator<Object> i = keys.iterator();
		
		while (i.hasNext()) {
			String str = (String)i.next();
			
			if (Generate.OPERATIONS.indexOf(str) != -1)
				html.addHTML(Generate.PLACES[Generate.OPERATIONS.indexOf(str)], Generate.generate(Generate.OPERATIONS.indexOf(str), file.getProperty(str)));
		}
		
		Iterator<String> iterator = html.getHTML().iterator();
		while (iterator.hasNext())
			 bw.write(iterator.next());
		
		if (bw != null)
			bw.flush();
		
		bw.close();
	}

}
