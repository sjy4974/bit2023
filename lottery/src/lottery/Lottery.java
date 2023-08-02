package lottery;

import java.util.Set;

public class Lottery {
	
	private Set<Integer> numbers;
	
	public void addNumbers(Set<Integer> numbers) {
		this.numbers = Set.copyOf(numbers);
	}

	public Set<Integer> getNumbers() {
		return this.numbers;
	}
	
}
