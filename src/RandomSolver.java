import java.io.FileNotFoundException;
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
				boolean got = false;
				for(Node neighbor : car.getPossibleMoves()) {
					if (car.canMove (neighbor)){
						car.goToNode(neighbor);
						got = true;
						break;
					}
					if(car.) {
						
					}
				}
				if(! got) iterator.remove();
			}
		}
		
		Writer writer = new Writer(Reader.cars);
		writer.generateSolution("randomSolution.txt");
	}

}
