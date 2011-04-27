package com.jdesktop;

import java.util.*;
import java.io.*;

public class Loader {

	private Properties prop;
	
	/**
	 * 
	 * @param file File to load properties from
	 * @throws IOException
	 */
	public Loader(File file) throws IOException {
		prop = new Properties();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String contents = "";
		
		String temp = null;
		do {
			temp = br.readLine();
			if (temp == null)
				continue;
			contents += temp+"\n";
		} while (temp != null);
		br.close();
		
		prop.load(new StringReader(contents.replace("\\","\\\\")));
	}
	
	/**
	 * 
	 * @return Returns the properties
	 */
	public Properties getProperties() {
		return prop;
	}
	
}
