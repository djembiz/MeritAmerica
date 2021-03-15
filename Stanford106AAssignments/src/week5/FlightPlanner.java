package week5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class FlightPlanner extends ConsoleProgram {
	HashMap<String, ArrayList<String>> flightList = new HashMap<String, ArrayList<String>>();
	ArrayList<String> destinationList = new ArrayList<>();
	String cityName;
	ArrayList<String> itinerary = new ArrayList<>();
	private static final String SENTINEL = "home";

	public void run() {
		println("Welcome to Flight Planner! \n");
		println("Let's plan a trip!");
		println("Here's all the destinations: \n");
		makeCityList();
		println("\nWhere would you like to start?");
		String selectionPrompt = "Enter \"home\" when all destinations selected: \n";
		makeSelections(selectionPrompt);
		showItinerary(itinerary);

	}
	
	public void makeCityList() {
		openDataFile("week5/CityList");
		for (String k : flightList.keySet()){
			println(k);
		}
	}

	public void makeSelections(String prompt) {
		String selection = readLine(prompt);
		while (!selection.equalsIgnoreCase(SENTINEL)) {
			if (!flightList.containsKey(selection)) {
				print("That city isn't available \n");
				selection = readLine(prompt);
			} else {
				showCityOptions(selection);
				itinerary.add(selection);
				selection = readLine(prompt);
			}
		}
	}

	public void showItinerary(ArrayList<String> itin) {
		println("Your itinerary is: \n");
		for (int i = 0; i < itin.size(); i++) {
			if (i == itin.size() - 1) {
				print(itin.get(i));
			} else {
				print(itin.get(i) + " -> ");
			}
		}
	}
	
	public void openDataFile(String fileName) {
		BufferedReader rd = null;
		while (rd == null) {
			rd = fileOpener(fileName);
			while (true) {
				try {
					String line = rd.readLine();
					if (line == null) {
						break;
					} else if (line.length() == 0) {
						editMapEntry(cityName, destinationList);
						destinationList.clear();
					} else {
						cityName = line.substring(0, (line.indexOf("->"))).trim();;
						destinationList.add(line.substring(line.indexOf("->")+2).trim());
					}
				} catch (IOException e) {
					print("Whoops!");
				}
			}
			editMapEntry(cityName, destinationList);
		}
	}
	
	public BufferedReader fileOpener(String filePath) {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader(filePath));
			} catch (IOException ex) {
				println("Bad File Name or Path");
			}
		}
		return rd;
	}
	
	public void editMapEntry(String cityName, ArrayList<String> destList) {
		ArrayList<String> tempList = new ArrayList<>();
		for (String city : destList) {
			tempList.add(city);
		}
			flightList.put(cityName, tempList);
	}
	
	public void showCityOptions(String selection) {
		println("\nThe options from " + selection + " are: \n");
		for (String location : flightList.get(selection)) {
			println(selection + " -> " + location);
		}
	}

}