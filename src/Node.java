import java.util.HashMap;


class Node {

	final int id;
	final double latitude;
	final double longitude;
	
	HashMap<Node, Street> neighbors;
	
	public Node(int idx, double la, double lo) {
		id = idx;
		latitude = la;
		longitude = lo;
		neighbors = new HashMap<Node, Street>();
	}
	
}