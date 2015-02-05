import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class RandomSolver implements Solver{
	
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
