package problem1;

import java.util.Scanner;

/**
 *
 * @author bas
 */

public class FormattingNumbers {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int a = input.nextInt();
		double b = input.nextDouble();
		double c = input.nextDouble();

		System.out.printf("|%s\t|%010d|\t%.2f|%.3f\t|", Integer.toHexString(a),
				Integer.parseInt(Integer.toBinaryString(a)), b, c);
		
		input.close();
	}
}
