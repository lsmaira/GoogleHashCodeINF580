import java.io.FileNotFoundException;
import java.util.Set;


class RandomSolver {
	
	Reader reader;
	final String fileName = "paris_54000.txt";
	Set<Car> availableCars;
	
	public void main() {
		try {
			reader = new Reader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(Car car : reader.cars) {
			availableCars.add(car);
		}
		
		while(! availableCars.isEmpty()) {
			for(Car car : availableCars) {
				for(Node neighbor : car.getPossibleMoves()) {
					if(car.current.neighbors.get(neighbor).cost<car.remainingTime) {
						car.goToNode(neighbor);
						break;
					}
				}
			}
		}
		
		Writer writer = new Writer(reader.cars);
	}

}
