package lottery;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LotteryNumCreator {
	private static final Random random = new Random();
	private static final int MAX_SIZE = 5;
	private static final int MAX_LIMIT_NUM = 40;

	/**
	 * �ڵ� �ζ� ����
	 * @return
	 */
	public static Set<Integer> createNumbers() {
		Set<Integer> winNumbers = new HashSet<Integer>();

		while (winNumbers.size() != MAX_SIZE) {

			int pickNumber = random.nextInt(MAX_LIMIT_NUM) + 1;

			if (!winNumbers.contains(pickNumber)) {
				winNumbers.add(pickNumber);
			}
		}

		return Set.copyOf(winNumbers);
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
