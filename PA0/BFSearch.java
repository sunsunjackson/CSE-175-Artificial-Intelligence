import java.util.*;
import java.io.*;
//I collaborated with Jack Cascio
public class BFSearch {
	
	Map mapp; //a complete Map object, endcoding the map to be searched
	public String startLoc; //a string for the starting loation
	public String Dest; //a string for the destination location
	public int lim; //limit of the depth for the search
	public int nodeExpansionCount; //contains the number of node expansions

	public BFSearch(Map graph, String initialLoc, String destinationLoc, int limit) {
		//TODO Auto-generated constructor stub
		this.mapp = graph;
		this.startLoc = initialLoc;
		this.Dest = destinationLoc;
		this.lim = limit;
		
	}

	public Node search(boolean b) {
		// TODO Auto-generated method stub
		//creates an empty set using Hash to contain the explored nodes
		HashSet<String> exploredNode = new HashSet<String>();
		
		nodeExpansionCount = 0;
		int i;
		
		Node newNode = new Node(mapp.findLocation(this.startLoc));
		
		Frontier frontier = new Frontier();
		frontier.addToBottom(newNode);
		
		Node removedTop;
		
		//if frontier is empty, return failure and pop it
		while(frontier.isEmpty() == false) {
			
			removedTop = frontier.removeTop();
			
			if (removedTop.depth >= this.lim) {
				return null;
			}
			
			if(removedTop.isDestination(this.Dest)) {
				return removedTop;
			}
			
			
			removedTop.expand();
			nodeExpansionCount++;
			
			if(b == true && (exploredNode.contains(removedTop.loc.name) == false)) {
				exploredNode.add(removedTop.loc.name); //add node to explored

			}
			
			//repeated state checking				
			for(Node child : removedTop.children) {
				if(b == false || (!frontier.contains(child) && !exploredNode.contains(child.loc.name))) {
					frontier.addToBottom(child);
				}
			}
		}
		
		return null;
	}

}