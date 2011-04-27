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
