import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


class Reader {
	
	static int n, m, maxT, c;
	
	static ArrayList<Node> junctions;
	static ArrayList<Car> cars;
	
	public Reader(String fileName) throws FileNotFoundException {
		
		File data = new File(fileName);
		Scanner sc = new Scanner(data);
		
		n = sc.nextInt();
		m = sc.nextInt();
		maxT = sc.nextInt();
		c = sc.nextInt();
		
		//Create, read and store the junction list
		junctions = new ArrayList<Node>();
		for (int i=0; i<n; i++){
			junctions.add(new Node (sc.nextInt(), sc.nextDouble(), sc.nextDouble()));
		}
		
		//Read and store the streets
		for (int i=0; i<m; i++){
			Node orig = junctions.get(sc.nextInt());
			Node dest = junctions.get(sc.nextInt());
			int dir = sc.nextInt();
			int cost = sc.nextInt();
			int gain = sc.nextInt();
			Street newStreet = new Street (i, orig, dest, dir, cost, gain);
			orig.neighbors.put(dest, newStreet);
			if (dir == 2){
				dest.neighbors.put(orig, newStreet);
			}
			
		}

		sc.close();
	}

}