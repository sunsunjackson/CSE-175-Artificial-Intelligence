import java.util.*;

public class AStarSearch {
	
	StreetMap mapp;
	public String startLoc;
	public String Dest;
	public int lim;
	public int nodeExpansionCount;
	
	public AStarSearch(StreetMap graph, String initialLoc, String destinationLoc, int limit) {
		// TODO Auto-generated constructor stub
		this.mapp = graph;
		this.startLoc = initialLoc;
		this.Dest = destinationLoc;
		this.lim = limit;
	}

	public Node search(boolean b) {
		// TODO Auto-generated method stub

			HashSet<String> exploredNode = new HashSet<String>();
			nodeExpansionCount = 0;
			int i;
			Node newNode = new Node(mapp.findLocation(this.startLoc));
			SortedFrontier frontier = new SortedFrontier(SortBy.f);
			
			GoodHeuristic gHeuristic = new GoodHeuristic();
			
			frontier.addSorted(newNode);//a priority queue
			
			Node removedTop;
			
			while(frontier.isEmpty() == false) {
				removedTop = frontier.removeTop();
				
				if (removedTop.depth >= this.lim) {
					return null;
				}
				
				if(removedTop.isDestination(this.Dest)) {
					return removedTop;
				}

				
				if(b == true) {
					exploredNode.add(removedTop.loc.name);
				}
				
				removedTop.expand(gHeuristic);
				nodeExpansionCount++;
				
				for(Node child : removedTop.children) {
					if(b == true) {
						if(!exploredNode.contains(child.loc.name)) {
							
							if(!frontier.contains(child)) {
								frontier.addSorted(child);
							}
							else if(child.partialPathCost < frontier.find(child).partialPathCost) { //if is frontier with higher path cost 
								//replace that frontier node with child
								frontier.remove(frontier.find(child));
								frontier.addSorted(child);
							}
					}
					}
					else {
						frontier.addSorted(child);
					}
				}
			}
			
			
			return null;
	}

}
