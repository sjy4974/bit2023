package lottery;

import java.util.Set;

public class Office {

	private static final Office office = new Office();
	
	private static long totalReward = 5000000000L;

	private Set<Integer> winNumbers;

	private Office() {
	}

	public static Office getInstence() {
		return office;
	}

	public void pickNumbers() {	
		winNumbers = LotteryNumCreator.createNumbers();
	}

	public long getTotalReward() {
		return totalReward;
	}

	public Set<Integer> getWinNumbers() {
		return winNumbers;
	}

}
