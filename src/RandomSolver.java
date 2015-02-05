import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class RandomSolver {

	public static void main(String[] args) {

		final String fileName = "paris_54000.txt";
		Set<Car> availableCars = new HashSet<Car>();
		
		try {
			new Reader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Car car : Reader.cars) {
			availableCars.add(car);
		}
		
		System.out.println(availableCars.toString());
		 
		while(! availableCars.isEmpty()) {
			
			Iterator<Car> iterator = availableCars.iterator();
			while(iterator.hasNext()) {
				Car car = iterator.next();
				
				ArrayList<Node> attainableNodes = new ArrayList<Node>();
				for(Node neighbor : car.getPossibleMoves()) {
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
		
		Writer writer = new Writer(Reader.cars);
		writer.generateSolution("randomSolution.txt");
	}

}
