import java.io.FileNotFoundException;


public class Testing_Reader {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		new Reader ("paris_54000.txt");
		for (int i=0; i<10; i++){
			Node j = Reader.junctions.get(i);
			System.out.print("\n--------------------------------------------------\nJunction "+i+"\nNeighboors:");
			
			for (Node n: j.neighbors.keySet()){
					System.out.printf("%8d",n.id);
			}
		}
		System.out.println("\n--------------------------------------------------\n Cars");
		for (Car c : Reader.cars){
			System.out.println("Starting Node = " + c.current.id);
		}
	}

}
