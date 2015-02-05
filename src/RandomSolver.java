import java.io.FileNotFoundException;
import java.util.HashSet;
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
		
		while(! availableCars.isEmpty()) {
			for(Car car : availableCars) {
				boolean got = false;
				for(Node neighbor : car.getPossibleMoves()) {
					if(car.current.neighbors.get(neighbor).cost<car.remainingTime) {
						car.goToNode(neighbor);
						got = true;
						break;
					}
				}
				if(! got) availableCars.remove(car);
			}
		}
		
		Writer writer = new Writer(Reader.cars);
		writer.generateSolution("randomSolution.txt");
	}

}
