import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class GreedySolver implements Solver{
	
	int searchDepth;
	
	public GreedySolver (int sD){
		searchDepth = sD;
	}
	
	// Perform a DFS on the possibility graph with given searchDepth and return the best next node to choose 
	public Node explore (Car car){
		System.out.println("-------------");
		Node best = null;
		Node first = null;
		Integer bestScore = new Integer(car.currentScore);
		DFS (car, 0, bestScore, best, first);
		return best;
	}
	
	public void DFS (Car car, int depth, Integer bestScore, Node best, Node first){
		
		System.out.println(car.current.id);
		System.out.println("bs" + bestScore);
		if(best!=null) System.out.println("best" + best.id);
		if(first!=null) System.out.println("first" + first.id);
		
		if (depth == 1){
			first = car.current;
		}
		
		if (depth == searchDepth || !canContinue(car)){
			System.out.println("bla");
			System.out.println("score" + car.currentScore);
			if (car.currentScore > bestScore){
				System.out.println("a" + bestScore);
				bestScore = new Integer(car.currentScore);
				System.out.println("d" + bestScore);
				best = first;
				System.out.println(best.id);
			}
			return;
		}
	
		Node origin = car.current;
		for (Node destination : origin.neighbors.keySet()) {
			Street rue = origin.neighbors.get(destination);
			if (car.canMove(destination)){
				boolean change = !rue.isUsed();
				car.goToNode(destination);
				DFS(car, depth+1, bestScore, best, first);
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
				System.out.println(destination.id);
				if (destination != null){
					car.goToNode(destination);
				}
				
				else iterator.remove();
			}
		}
		return new Writer(r.cars);
	}
	
}
