package com.meister.solutions;

public class Main {
	
	public static void main(String[] args) {
		
		MeisterNumberSwapper.Swap(10, 20);

		System.out.println();

		String text = "Bom dia! Aqui existem      6 espaços.";
		String spacelessText = MeisterWhiteSpaceRemover.RemoveWhiteSpace(text);

		System.out.println("Original: " + text);
		System.out.println("Spaceless: " + spacelessText);
		System.out.println();

		MeisterListFilter listFilter = new MeisterListFilter();
		listFilter.Start();
	}
}
