import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.PriorityQueue;


class GenerateShorterDistances {

	public static void main(String[] args) {

		final String fileName = "paris_54000.txt";
		Reader r = null;
		
		try {
			r = new Reader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int[] minDist = new int[r.n];
		
		PriorityQueue<Integer> notVisited = new PriorityQueue<Integer>(r.n, new Comparator<Integer>() {
	        public int compare(Integer a, Integer b) {
	            return minDist[a]-minDist[b];
	        }
	    });
		
		minDist[r.s] = 0;
		notVisited.add(r.s);
		for(int i = 0; i<r.n; i++) {
			if(i!=r.s) minDist[i] = Integer.MAX_VALUE;
		}
		
		while(! notVisited.isEmpty()) {
			int current = notVisited.poll();
			for(Node neighbor : r.junctions.get(current).neighbors.keySet()) {
				if(minDist[neighbor.id]>minDist[current]+r.junctions.get(current).neighbors.get(neighbor).cost) {
					minDist[neighbor.id] = minDist[current]+r.junctions.get(current).neighbors.get(neighbor).cost;
					if(notVisited.contains(neighbor.id)) notVisited.remove(neighbor.id);
					notVisited.add(neighbor.id);
				}
			}
		}
		
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter("out.txt", "UTF-8");
		} catch (FileNotFoundException fe){
			fe.printStackTrace();
		} catch (UnsupportedEncodingException ue) {
			ue.printStackTrace();
		}
		
		for(int i = 0; i<r.n; i++) System.out.println(i + " " + minDist[i]);
	}

}
