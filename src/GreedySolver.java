import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class GreedySolver implements Solver{
	
	int searchDepth;
	
	public GreedySolver (int sD){
		searchDepth = sD;
	}
	
	public int evaluatePath (ArrayList<Node> path){
		int totalGain = 0;
		Node origin = path.get(0);
		for (int i=1; i<path.size(); i++){
			Node destination = path.get(i);
			Street s = origin.neighbors.get(destination);
			if (!s.isUsed()) totalGain += s.gain;
			origin = destination;
		}
		return totalGain;
	}
	
	// Perform a DFS on the possibility graph with given searchDepth and return the best next node to choose 
	public Node explore (){
		Node best = null;
		
		return best;
	}
	
	@Override
	public Writer solve(Reader r) {

		Set<Car> availableCars = new HashSet<Car>();
		for(Car car : r.cars) {
			availableCars.add(car);
		}
		 
		while(! availableCars.isEmpty()) {
			
			Iterator<Car> iterator = availableCars.iterator();
			while(iterator.hasNext()) {
				Car car = iterator.next();
				
				ArrayList<Node> attainableNodes = new ArrayList<Node>();
				
				
				for(Node neighbor : car.neighborDestinations()) {
					if (car.canMove (neighbor)){
						attainableNodes.add(neighbor);
					}
				}
				
				if (attainableNodes.size() > 0){
					car.goToNode(attainableNodes.get((int) (Math.random()*attainableNodes.size()))); 
				}
				
				else iterator.remove();
			}
		}
		return new Writer(r.cars);
	}
}
