
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class TakeAFlight extends ConsoleProgram {
	/** Runs the program. */
	public void run() {
		println("Are you ready?");
		readFlightData("flights.txt");
		println("This is the list of all the cities available:");
		printCityList(cities);
		println("Plan your round-trip route!");
		
		
		String cityofOrigin = readLine("Enter the city of origin: ");
		ArrayList<String> route = new ArrayList<String>();
		route.add(cityofOrigin);
		String currentCity = cityofOrigin;
		while (true) {
			String nextCity = getNextCity(currentCity);
			route.add(nextCity);
			if (nextCity.equals(cityofOrigin))
				break;
			currentCity = nextCity;
		}

		printRoute(route);
	}

	private String getNextCity(String city) {
		ArrayList<String> wereto = getDestinations(city);
		String nextCity = null;
		while (true) {
			println("From " + city + " you can fly directly to:");
			printCityList(wereto);
			String prompt = "Where do you want to go from " + city + "? ";
			nextCity = readLine(prompt);
			if (wereto.contains(nextCity))
				break;
			println("You can't get to that city by a direct flight.");
		}
		return nextCity;
	}

	private ArrayList<String> getDestinations(String fromCity) {
		return outgoingflights.get(fromCity);
	}

	
	private void printCityList(ArrayList<String> cityList) {
		for (int i = 0; i < cityList.size(); i++) {
			String city = cityList.get(i);
			println(" " + city);
		}
	}

	/**
	 * Given a list of city names, prints out the flight route, with a " -> "
	 * between each pair of cities
	 */
	private void printRoute(ArrayList<String> route) {
		println("The route you've chosen is: ");
		for (int i = 0; i < route.size(); i++) {
			if (i > 0)
				print(" -> ");
			print(route.get(i));
		}
		println();
	}

	/**
	 * Reads in the city information from the given file storing the information in
	 * both the ArrayList of cities and the HashMap of flights.
	 */
	private void readFlightData(String filename) {
		outgoingflights = new HashMap<String, ArrayList<String>>();
		cities = new ArrayList<String>();
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				if (line.length() != 0) {
					readFlightEntry(line);
				}
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}

	private void readFlightEntry(String line) {
		int arrow = line.indexOf("->");
		if (arrow == -1) {
			throw new ErrorException("Illegal flight entry " + line);
		}
		String fromCity = line.substring(0, arrow).trim();
		String toCity = line.substring(arrow + 2).trim();
		defineCity(fromCity);
		defineCity(toCity);
		getDestinations(fromCity).add(toCity);
	}

	/**
	 * Defines a city if it has not already been defined. Defining a city consists
	 * of entering it in the cities array and entering an empty ArrayList in the
	 * flights table to show that it has no destinations yet.
	 */
	private void defineCity(String cityName) {
		if (!cities.contains(cityName)) {
			cities.add(cityName);
			outgoingflights.put(cityName, new ArrayList<String>());
		}
	}

	private HashMap<String, ArrayList<String>> outgoingflights;
	private ArrayList<String> cities;
}
