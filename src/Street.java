
class Street {
	
	Node orig;
	Node dest;
	int cost;
	int gain;
	boolean bothDirec;
	
	public Street(Node o, Node d, int c, int g, int dir) {
		orig = o;
		dest = d;
		cost = c;
		gain = g;
		bothDirec = (dir==2);
	}

}
