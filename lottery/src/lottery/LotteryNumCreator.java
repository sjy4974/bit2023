package lottery;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumCreator {
	private static final Random random = new Random();
	private static final int MAX_SIZE = 5;

	/**
	 * �ڵ� �ζ� ����
	 * @return
	 */
	public static Set<Integer> createNumbers() {
		
		return random.ints(1, 40+1)
				.distinct()
				.limit(5)
				.boxed()
				.collect(Collectors.toUnmodifiableSet());
	}

	/**
	 * ������ �Է��� ��ȣ�� ������� �ζ� ����
	 * @return
	 */
	public static Set<Integer> inputCreateLotteryNumbers() {
		System.out.println("1~40 ������ ���ڸ� �Է� ���ּ���");
		Set<Integer> lotteryNumbers = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);

		while (lotteryNumbers.size() != MAX_SIZE) {
			System.out.print("�Է� : ");
			int pickNum = 0;

			try {
				pickNum = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է� ���ּ���");
				sc = new Scanner(System.in);
				continue;
			} 

			if (!checkValidation(pickNum)) {
				System.out.println("��ȿ ������ ���ڰ� �ƴ�");
				continue;
			}

			if (lotteryNumbers.contains(pickNum)) {
				System.out.println("�ߺ� �� ���� �Դϴ�. �ٽ� �Է� ���ּ���.");
			}

			lotteryNumbers.add(pickNum);
		}
		sc.close();
		return lotteryNumbers;

	}

	/**
	 * �Է� ���� üũ
	 * @param num
	 * @return
	 */
	private static boolean checkValidation(int num) {
		if (num < 1 || num > 40) {
			return false;
		}
		return true;
	}

}
