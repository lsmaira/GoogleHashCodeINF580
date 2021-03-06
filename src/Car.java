import java.util.LinkedList;
import java.util.Set;


class Car {
	
	Node current;
	int remainingTime;
	int currentScore;
	LinkedList<Node> path;
	
	public Car(Node begining, int timeLimit) {
		current = begining;
		remainingTime = timeLimit;
		path = new LinkedList<Node>();
		path.add(begining);
	}
	
	public Car (Car car){
		this.current = car.current;
		this.remainingTime = car.remainingTime;
		this.currentScore = car.currentScore;
	}
	
	public int getScore() {
		return currentScore;
	}
	
	public void goToNode(Node destination) {
		if(current.neighbors.containsKey(destination)) {
			//System.out.println("Going from node " + current.id + " to node " + destination.id);
			Street rue = current.neighbors.get(destination);
			remainingTime -= rue.cost;
			if (!rue.isUsed()){
				currentScore += rue.gain;
				rue.use();
			}
			path.add(destination);
			current = destination;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	
	public void goBack(Node origin, boolean hasChanged) {
		
		Street rue = origin.neighbors.get(current);
		
		if (hasChanged) {
			rue.clean();
			currentScore -= rue.gain;
		}
		current = origin;
		remainingTime += rue.cost;
	}
	
	public Set<Node> neighborDestinations() {
		return current.neighbors.keySet();
	}

	public boolean canMove(Node destination) {
		return current.neighbors.get(destination).cost <= remainingTime;
	}

}