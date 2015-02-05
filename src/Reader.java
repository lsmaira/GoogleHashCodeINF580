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
		junctions = new ArrayList<Node>(n);
		for (int i=0; i<n; i++){
			junctions.add(new Node (i, sc.nextDouble(), sc.nextDouble()));
		}
		
		//Read and store the streets
		for (int i=0; i<m; i++){
			Street rue = new Street (i, junctions.get(sc.nextInt()), junctions.get(sc.nextInt()), sc.nextInt(), sc.nextInt(), sc.nextInt());
			rue.orig.neighbors.put(rue.dest, rue);
			if (rue.bothDirec){
				rue.dest.neighbors.put(rue.orig, rue);
			}
		}

		sc.close();
	}

}