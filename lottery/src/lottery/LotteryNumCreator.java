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
	 * 자동 로또 생성
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
