import java.io.FileNotFoundException;


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
		
		
		
		Writer writer = new Writer(reader.cars);
		writer.generateSolution("randomSolution.txt");
	}

}