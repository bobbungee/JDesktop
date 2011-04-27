package com.jdesktop;

import java.util.*;
import java.io.*;

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
