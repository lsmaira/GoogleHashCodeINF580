import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Reader r = new Reader ("input.txt");
		for (int i=0; i<10; i++){
			Node j = Reader.junctions.get(i);
			System.out.print("Junction "+i+"\nNeighboors: ");
			for (Node n : r.junctions.get)
		}
	}

}
