import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


class Writer {
	
	ArrayList<Car> cars;
	int totalScore;

	public Writer(ArrayList<Car> cars) {
		this.cars = cars;
		totalScore = 0;
	}
	
	public void generateSolution(String fileName) {
		
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(fileName, "UTF-8");
		} catch (FileNotFoundException fe){
			fe.printStackTrace();
		} catch (UnsupportedEncodingException ue) {
			ue.printStackTrace();
		}
		
		for (Car c:cars) totalScore += c.currentScore;
		
		System.out.println("Total score obtained = "+totalScore);
		
		writer.println("Total score obtained = "+totalScore);
		writer.println("################################################################################################");
		
		int i=0;
		for (Car c : cars){
			writer.println("CAR " + ++i + ": score = " +c.currentScore+", remaining time = "+c.remainingTime);
			writer.println("Path made by car " + i + ":");
			for (Node n : c.path){
				writer.print("" + n.id + " ");
			}
			writer.println("\n---------------------------------------------------------------------------------------------");
		}
		writer.close();
	}
}
