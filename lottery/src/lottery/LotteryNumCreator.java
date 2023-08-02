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
	 * 자동 로또 생성
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
	 * 유저가 입력한 번호를 기반으로 로또 생성
	 * @return
	 */
	public static Set<Integer> inputCreateLotteryNumbers() {
		System.out.println("1~40 사이의 숫자를 입력 해주세요");
		Set<Integer> lotteryNumbers = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);

		while (lotteryNumbers.size() != MAX_SIZE) {
			System.out.print("입력 : ");
			int pickNum = 0;

			try {
				pickNum = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력 해주세요");
				sc = new Scanner(System.in);
				continue;
			} 

			if (!checkValidation(pickNum)) {
				System.out.println("유효 범위의 숫자가 아님");
				continue;
			}

			if (lotteryNumbers.contains(pickNum)) {
				System.out.println("중복 된 숫자 입니다. 다시 입력 해주세요.");
			}

			lotteryNumbers.add(pickNum);
		}
		sc.close();
		return lotteryNumbers;

	}

	/**
	 * 입력 범위 체크
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
