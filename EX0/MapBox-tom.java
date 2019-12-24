// For this excercize I used the github help in how to use the Hashset class posted by the TA Matthew Turner at: https://github.com/mt-digital/UCM-IntroAI-F19/blob/master/Lab1-Intro/HashSetExample.java
// Additional help was attained from both TA' (Matthew and TainTian) during lab times
// Discussion was made about this assignment with the following student: Jackson Chen
import java.util.ArrayList;
import java.util.HashSet;


public class MapBox {
		// a public member variable called “locations” that holds a list of objects of the type Location
		public ArrayList<Location> locations;
		
		// Create a hashset for the found x and y locations
		HashSet<String> foundLocation;
		
		// Create the inital ArrayList and HashSet
		MapBox(){
			this.locations = new ArrayList<Location>();
			
			this.foundLocation = new HashSet<String>();
		}
		
		// When called it  returns the minimum x-axis coordinate
		public double Westmost() {
			// Since the variable MiniX never leaves the Westmost function we can just initalize here
			double miniX;
			// goto the locations and grab the value at location 0 and assign it to the new location variable
			Location westLocation = locations.get(0);
			// Set miniX to the lonitude value stored at location westLocation
			miniX = westLocation.longitude;
			// One by one go through the location-simple.java file and compare miniX to the difference longitude values
			for (int i = 0; i < locations.size(); i++) {
				// If the value is lower than our current value, make that value our new miniX
				if (locations.get(i).longitude < miniX) {
					
					miniX = locations.get(i).longitude;
				}
			}
			// Return back value in miniX
			return miniX;
		}
		// When called it  returns the maximum x-axis coordinate
		public double Eastmost() {
			// Since the maxiX variable never leaves the Eastmost function we can just initalize it here
			double maxiX;
			// goto the locations and grab the value at location 0 and assign it to the new location variable
			Location eastLocation = locations.get(0);
			// Set maxiX to the lonitude value stored at location eastLocation
			maxiX = eastLocation.longitude;
			// One by one go through the location-simple.java file and compare miniX to the difference longitude values
			for (int i = 0; i < locations.size(); i++) {
				if (locations.get(i).longitude > maxiX) {
					// If the value is lower than our current value, make that value our new maxiX
					maxiX = locations.get(i).longitude;
				}
			}
			// Return back value in maxiX
			return maxiX;
		}
		
		//  When called it  returns the minimum y-axis coordinate
		public double Southmost() {
			// Since the miniY variable never leaves the Southmost function we can just initalize it here
			double miniY;
			// goto the locations and grab the value at location 0 and assign it to the new location variable
			Location southLocation = locations.get(0);
			// Set miniY to the lonitude value stored at location southLocation
			miniY = southLocation.latitude;
			// One by one go through the location-simple.java file and compare miniX to the difference longitude values
			for(int i = 0; i < locations.size(); i++) {
				// If the value is lower than our current value, make that value our new miniY
				if (locations.get(i).latitude < miniY) {
					// If the value is lower than our current value, make that value our new miniY
					miniY = locations.get(i).latitude;
				}
			}
			// Return back the value in miniY
			return miniY;
		}
		
		// When called it returns the maximum y-axis coordinate
		public double Northmost() {
			// Since the maxiY variable never leaves the Northmost function we can just initalize it here
			double maxiY;
			// goto the locations and grab the value at location 0 and assign it to the new location variable
			Location northLocation = locations.get(0);
			// Set maxiY to the lonitude value stored at location southLocation
			maxiY = northLocation.latitude;
			// One by one go through the location-simple.java file and compare miniX to the difference longitude values
			for (int i = 0; i < locations.size(); i++) {
				// If the value is lower than our current value, make that value our new maxiY
				if (locations.get(i).latitude > maxiY) {
					// If the values lower than our current value, make that value our new maxiY
					maxiY = locations.get(i).latitude;
				}
			}
			// Return back the value in maxiY
			return maxiY;
		}
		// Checking to see if there is a duplicate of a lognitude value
		public boolean recordLocation(Location loc) {
			
			if(foundLocation.contains(loc.name)) {
				return false;
			}
			else {
				locations.add(loc);
				foundLocation.add(loc.name);
				
				return true;
			}
			
		}
		
		
	}
