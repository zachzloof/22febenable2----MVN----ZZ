package com.qa.solid.liskov;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Animal();

		Owl owl = new Owl();
		Penguin penguin = new Penguin();

		// compile-time safety
		a.learnToFly(owl);

		a.tryToFly(penguin);

	}

}
