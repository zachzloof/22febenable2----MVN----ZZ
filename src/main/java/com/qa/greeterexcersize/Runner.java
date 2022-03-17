package com.qa.greeterexcersize;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FormalGreeting fg = new FormalGreeting();
		CasualGreeting cg = new CasualGreeting();
			Greeter greeter = new Greeter(cg);
			System.out.println(greeter.greet());
			
	}

}
