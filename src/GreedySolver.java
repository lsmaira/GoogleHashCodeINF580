import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class BestNode {
	double value = 0.0;
	Node node = null;
}

class GreedySolver implements Solver{
	
	int searchDepth;
	
	public GreedySolver (int sD){
		searchDepth = sD;
	}
	
	// Perform a DFS on the possibility graph with given searchDepth and return the best next node to choose 
	public Node explore (Car car){
		Node first = null;
		BestNode best = new BestNode();
		int rt0 = car.remainingTime;
		int s0 = car.currentScore;
		DFS (car, 0, best, first, rt0, s0);
		return best.node;
	}
	
	public void DFS (Car car, int depth, BestNode best, Node first, int rt0, int s0){
		
		if (depth == 1){
			first = car.current;
		}
		
		if (depth == searchDepth || !canContinue(car)){
			double currentScore;
			if (depth == 0) currentScore = 0.0;
			else currentScore = (double)(car.currentScore-s0);//(rt0-car.remainingTime);
			if (currentScore > best.value){
				best.value = currentScore;
				best.node = first;
			}
			return;
		}
	
		Node origin = car.current;
		for (Node destination : origin.neighbors.keySet()) {
			Street rue = origin.neighbors.get(destination);
			if (car.canMove(destination)){
				boolean change = !rue.isUsed();
				car.goToNode(destination);
				DFS(car, depth+1, best, first, rt0, s0);
				car.goBack(origin, change);
			}
		}
	}
	
	private boolean canContinue(Car car) {
		for (Node destination : car.neighborDestinations()){
			if (car.canMove(destination)) return true;
		}
		return false;
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
				
				Node destination = explore(car);
				if (destination != null){
					car.goToNode(destination);
				}
				
				else iterator.remove();
			}
		}
		return new Writer(r.cars);
	}
	
}
