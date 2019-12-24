import java.util.ArrayList;
import java.util.HashSet;
import java.lang.Math;

// sources: TA Matt
public class MapBox {
	double minX, minY, maxX, maxY;
	
	public ArrayList<Location> locations;
	public HashSet<String> recordedLocation;
//	public List locations = new ArrayList();
//	ArrayList<String> locations = new ArrayList(String);
	
	MapBox() {
		//creating a list of array and contains list of locations
		this.locations = new ArrayList<Location>();
		//container that contains the strings
		//use track location name to record/track names
		this.recordedLocation = new HashSet<String>();
	}
	
	public double Westmost() {
		//TODO Auto-generated method stub
		Location westLocation = locations.get(0);
		minX = westLocation.longitude;
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i).longitude < minX) {
				
				minX = locations.get(i).longitude;
			}
		}
		return minX;
	}
	
	public double Eastmost() {
		Location eastLocation = locations.get(0);
		maxX = eastLocation.longitude;
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i).longitude > maxX) {
				
				maxX = locations.get(i).longitude;
			}
		}
		return maxX;
	}
	public double Southmost() {
		Location southLocation = locations.get(0);
		minY = southLocation.latitude;
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i).latitude < minY) {
				
				minY = locations.get(i).latitude;
			}
		}
		return minY;
	}
	public double Northmost() {
		//for ()
		Location northLocation = locations.get(0);
		maxY = northLocation.latitude;
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i).latitude > maxY) {
				
				maxY = locations.get(i).latitude;
			}
		}
		return maxY;
	}
	
	public boolean recordLocation(Location loc) {
		// TODO Auto-generated method stub
		if(recordedLocation.contains(loc.name)) {
			return false;
		}
		else {
			locations.add(loc);
			recordedLocation.add(loc.name);
			
			return true;
		}
		
		//locations.add();
		//return false;
	}
	
	
}
