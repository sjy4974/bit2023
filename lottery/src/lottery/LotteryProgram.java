package lottery;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LotteryProgram {

	private static List<Person> people = new ArrayList<>();
	private static Map<Integer, Integer> collectCount = new HashMap<Integer,Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ��÷ ��ȣ ����
		Office office = Office.getInstence();
		office.createWinNumbers();
		// �Է� �޾� �ζ� ���� (���� �� �ζ�)
		Person person = createLotteryWithInput();
		// �ӽ� �ζ� 1000�� ����
		createAutoLottery();
		// ��÷�� ��� �� ��� ���
		result(person);
		
		
	}

	/**
	 * ������ �Է��� ��ȣ�� �ζ� ����
	 * @return Person
	 */
	private static Person createLotteryWithInput() {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.buy();
		people.add(person);
		return person;
	}
	
	/**
	 * �ڵ� �ζ� ����
	 */
	private static void createAutoLottery() {
		// TODO Auto-generated method stub
		for(int i = 0; i<999; i++) {
			Person temp = new Person();
			Lottery lottery = new Lottery();
			Set<Integer> num = LotteryNumCreator.createNumbers();
			lottery.addNumbers(num);
			temp.setLottery(lottery);
			people.add(temp);
		}
	}

	/**
	 * ��� ��� �� ���� ���� reward ���
	 * @param person
	 */
	private static void result(Person person) {
		// TODO Auto-generated method stub
		operator(person);
		setMyReward(person);
		printResult(person);
	}

	/**
	 * ��� ������� �ζǿ� ��÷ �ζ� ���� ���� ��� ���� �� ���� ������ ����
	 * @param person
	 */
	private static void operator(Person person) {
		for(Person p : people) {
			int count = getWinNumberCount(p.getLottery());
			p.setCount(count);
		}
		
		Collections.sort(people);
		
		collectCount.put(5, 0);
		collectCount.put(4, 0);
		collectCount.put(3, 0);
		collectCount.put(2, 0);
		collectCount.put(1, 0);
		
		for(Person p : people) {
			int count = p.getCount();
			if(count == 0) break;
			if(collectCount.containsKey(count)) {
				collectCount.put(count, collectCount.get(count)+1);
			};
		}
	}
	
	/**
	 * ��÷ �ζǿ� �ش� �ζǰ� � �¾Ҵ��� �� �� ���� count ���
	 * @param lottery
	 * @return
	 */
	private static int getWinNumberCount(Lottery lottery) {
		Office office = Office.getInstence();
		
		Set<Integer> winNumbers = office.getWinNumbers();
		Iterator<Integer> myNumbers = lottery.getNumbers().iterator();
		
		int count = 0;
		
		while(myNumbers.hasNext()) {
			int num = myNumbers.next();
			if(winNumbers.contains(num)) {
				count++;
			}
		}
		
		return count;	
	}

	/**
	 * ���� ���� reward ��� �� ����
	 * @param person
	 */
	private static void setMyReward(Person person) {
		// TODO Auto-generated method stub
		int cnt = person.getCount();
		float percent = 0.0f;
		switch(cnt) {
		case 1: 
			percent = 0.02f;
			break;
		case 2:
			percent = 0.08f;
			break;
		case 3:
			percent = 0.1f;
			break;
		case 4:
			percent = 0.3f;
			break;
		case 5: 
			percent = 0.5f;
		}
		if(cnt == 0) {
			return ;
		}
		
		long reward = (long)(Office.getInstence().getTotalReward() * percent) / collectCount.get(cnt);
		DecimalFormat dc = new DecimalFormat("###,###");
		String rewardString = dc.format(reward);
		person.setReward(rewardString);
		
	}
	
	/**
	 * ��� ��� ���
	 * @param person
	 */
	private static void printResult(Person person) {
		
		System.out.println("���� ��ȣ : "+Office.getInstence().getWinNumbers());
		System.out.println("�� ��ȣ : "+person.getLottery().getNumbers());
		System.out.println("���� ���� : "+person.getCount());
		System.out.println("���� ���� �� : "+person.getReward());	
	}

}
