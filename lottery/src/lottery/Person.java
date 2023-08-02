package lottery;

import java.util.Set;

public class Person implements Comparable<Person>{

	private Lottery lottery;
	private String reward = "¾øÀ½";
	private int count;
	
	public void setLottery(Lottery lottery) {
		this.lottery = lottery;
	}
	
	public Lottery getLottery() {
		return lottery;
	}
	
	public void setReward(String reward) {
		this.reward = reward;
	}
	
	public String getReward() {
		return reward;
	}
	
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}

	public void buy() {
		Set<Integer> lotterNumbers = LotteryNumCreator.inputCreateLotteryNumbers();
		Lottery lottery = new Lottery();
		lottery.addNumbers(lotterNumbers);
		this.lottery = lottery;
	}
	
	@Override
	public int compareTo(Person p) {
		// TODO Auto-generated method stub
		
		return p.count - this.count;
	}
	
	
	@Override
	public String toString() {
		return "Person [lottery=" + lottery + ", reward=" + reward + "]";
	}

	
	
	
	
}
