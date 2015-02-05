import java.util.Set;


class RandomSolver {
	
	Reader reader;
	final String fileName = "bla.txt";
	Set<Car> availableCars;
	
	public void main() {
		reader = new Reader(fileName);
		for(Car car : reader.cars) {
			availableCars.add(car);
		}
		
		while(! availableCars.isEmpty()) {
			for(Car car : availableCars) {
				
			}
		}
	}

}
