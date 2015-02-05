import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		
		
		Solver s = new GreedySolver(5);
		final String fileName = "paris_54000.txt";
		Reader r = null;
		
		try {
			r = new Reader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Writer w = s.solve(r);
		w.generateSolution("randomSolution.txt");
		
	}

}
