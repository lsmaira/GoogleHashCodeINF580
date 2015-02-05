import java.util.LinkedList;
import java.util.List;
import java.util.Set;


class Car {
	
	Node current;
	int remainingTime;
	int currentScore;
	List<Node> way;
	
	public Car(Node begining) {
		current = begining;
		way = new LinkedList<Node>();
		way.add(begining);
	}
	
	public int getScore() {
		return currentScore;
	}
	
	public void goToNode(Node destination) {
		if(current.neighbors.containsKey(destination)) {
			Street rue = current.neighbors.get(destination);
			remainingTime -= rue.cost;
			if (!rue.isUsed()){
				currentScore += rue.gain;
				rue.use();
			}
			
			way.add(destination);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public Set<Node> getPossibleMoves() {
		return current.neighbors.keySet();
	}

}