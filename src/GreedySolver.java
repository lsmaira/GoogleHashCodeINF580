import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;


class GreedySolver {

	final int depth = 10;

	public static void main(String[] args) {
		
		Reader reader = null;
		final String fileName = "paris_54000.txt";
		try {
			reader = new Reader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Set<Car> availableCars = new HashSet<Car>();
		
		while(! availableCars.isEmpty()) {
			for(Car car : availableCars) {
				
			}
		}
		
		Writer writer = new Writer(reader.cars);
		writer.generateSolution("randomSolution.txt");
	}

}