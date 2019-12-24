//
// GoodHeuristic
//
// This class extends the Heuristic class, providing a reasonable
// implementation of the heuristic function method. The provided "good"
// heuristic function is admissible.
//
// YOUR NAME -- TODAY'S DATE
//


// IMPORT ANY PACKAGES THAT YOU NEED.
import java.util.*;


public class GoodHeuristic extends Heuristic {
	
        // YOU CAN ADD ANYTHING YOU LIKE TO THIS CLASS ... WHATEVER WOULD
        // ASSIST IN THE CALCULATION OF YOUR GOOD HEURISTIC VALUE.
//	public ArrayList<Location> locations;
	
	public HashSet<String> recordedLocation;
	double distance, x1, y1;
	double velocity = 0;
	double maxV = 0;
	StreetMap graph;
	Location destinationLoc;
	Road roads;
	//Node endNode = new Node(graph.findLocation(destinationLoc));
	
	public double findV(Road roads) {
		
		this.recordedLocation = new HashSet<String>();
		
		
		x1 = roads.toLocation.longitude - roads.fromLocation.longitude;
		y1 = roads.toLocation.latitude - roads.fromLocation.latitude;	
		
		distance = (Math.sqrt( (x1*x1) + (y1*y1) ));
		//velocity = distance/roads.cost;
		
		for(int i = 0; i < graph.locations.size(); i++) {
			for(int j = i + 1; j < graph.locations.size(); j++) {
				roads = graph.locations.get(i).roads.get(j);
				if(recordedLocation.contains(roads.name)) {
					continue;
				}
				else {
					velocity = distance/roads.cost;
					if(maxV < velocity)
						maxV = velocity;
					recordedLocation.add(roads.name);
				}
			}
		}
		return maxV;
	}
	
	// heuristicValue -- Return the appropriate heuristic values for the
	// given search tree node. Note that the given Node should not be
	// modified within the body of this function.
	public double heuristicValue(Node thisNode) {
		double hVal = 0.0;
		//this.locations = new ArrayList<Location>();		
		
		//Node startNode = new Node(graph.findLocation(initialLoc));		
		
		x1 = thisNode.loc.longitude - destination.longitude;
		y1 = thisNode.loc.latitude - destinationLoc.latitude;
		
		double newDistance = (Math.sqrt( (x1*x1) + (y1*y1) ));
		
		hVal = newDistance / maxV;
		
		
		return (hVal);
	}

}
