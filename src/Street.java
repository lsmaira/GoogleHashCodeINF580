
class Street {
	
	final int id;
	final Node orig;
	final Node dest;
	final int cost;
	final int gain;
	final boolean bothDirec;
	private boolean used;
	
	public Street(int idx, Node o, Node d, int dir, int c, int g) {
		id = idx;
		orig = o;
		dest = d;
		cost = c;
		gain = g;
		bothDirec = (dir==2);
	}
	
	public void use() {
		used = true;
	}
	
	public void clean() {
		used = false;
	}
	
	public boolean isUsed() {
		return used;
	}

}