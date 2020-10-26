
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

import acm.program.*;

public class TakeFlight extends ConsoleProgram{
	HashMap<String, String> listofFlights = new HashMap<String,String>();
	ArrayList<String> city = new ArrayList<String>();
	private int index;
	
	public void run() {
		
		File thefile = new File("flights.txt");
		
		readFile(thefile);
		
		for(String s : city) {
			println(s);
		}
		
	}

	private void readFile(File thefile) {
		// TODO Auto-generated method stub
		
		try(BufferedReader breader = new BufferedReader(new FileReader(thefile))){
			String line;
			
			while((line = breader.readLine()) !=null) {
				String[] listofflights = line.split(" -> ");
				for(int i=0; i<listofflights.length; i++) {
					
					city.add(listofflights[i]);
					
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i< city.size(); i++) {
			if(city.get(i).equals("")) {
				city.remove(i);
			}
			
		}
			
			for (int i = 0; i < city.size(); i += 2) {
				listofFlights.put(city.get(i), city.get(i+1));
				System.out.println("city:" + city.get(i) + "Destination: " + city.get(i+1));
				index = i;
				System.out.println("Index: " + index);
			}
	}
}
			
	 
	
				
			//if(city.get(i).equals("New York")) {
					 //System.out.println("Destination" + city.get(i+1));
					
	
			// System.out.println(listofFlights.toString);
	

	
	

