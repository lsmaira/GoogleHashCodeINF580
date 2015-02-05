import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		
		
		Solver s = new GreedySolver(3);
		final String fileName = "paris_54000.txt";
		Reader r = null;
		
		try {
			r = new Reader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Writer w = s.solve(r);
		w.generateSolution("randomSolution.txt");
		
		/* Random Solver
		int nTests = 200;
		int bestSolution = 0;
		while (nTests --> 0){
		
			Solver s = new RandomSolver();
	
			final String fileName = "paris_54000.txt";
			Reader r = null;
			
			try {
				r = new Reader(fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			Writer w = s.solve(r);
			w.generateSolution("randomSolution.txt");
			bestSolution = Math.max(bestSolution, w.totalScore);
		}
		
		System.out.println("##################################################################");
		System.out.println("Best solution = " + bestSolution);
		*/
		
	}

}
