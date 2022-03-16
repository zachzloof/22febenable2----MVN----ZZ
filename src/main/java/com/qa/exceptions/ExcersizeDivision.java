package com.qa.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcersizeDivision {

	public void division() {
		int result;
		int a = 0;
		int b = 0;
		Scanner scanner = new Scanner(System.in);

			System.out.println("Please input 2 integers, to divide");
			try {
				 a = scanner.nextInt();
				 b = scanner.nextInt();
				 
				 if (b > a) {
					 throw new LargerDenominator();
				 }
			} catch (LargerDenominator ld) {
				ld.printStackTrace();
			} catch(ArithmeticException ae) {
				System.out.println("You cant divide by 0.");

			} catch(InputMismatchException ime) {
				System.out.println("Input cannot be a string.");

			} catch(Exception e) {
				e.printStackTrace();

			} finally {
				scanner.close();
			}
			result = a / b;
			System.out.println(result);
		
	}

}

