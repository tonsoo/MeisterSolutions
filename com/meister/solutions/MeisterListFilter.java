package com.meister.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MeisterListFilter {

	private List<String> UserInputList;

    public MeisterListFilter(){
		UserInputList = new ArrayList<>();
    }

	public void Start(){
		UserInputList = InputList();
		List<String> filteredList = UserInputList.stream().filter(c -> c.length() == 3 && c.charAt(0) == 'a').collect(Collectors.toList());
		
		for(String item : filteredList) {
			System.out.println(item);
		}

		System.out.println();
		System.out.println("Filtered " + filteredList.size() + " items out of " + UserInputList.size());
	}

    public List<String> InputList() {
		List<String> list = new ArrayList<>();
		
		System.out.println("Input an empty value to finish");
		
		try (Scanner scanner = new Scanner(System.in)) {
			int index = 1;
			String inputText;
			do {
				System.out.print(index + "# item of list: ");
				
				inputText = scanner.nextLine();
				
				if(!inputText.equals("")) {
					list.add(inputText);
				}
				
				index++;
			} while(!inputText.equals(""));
		}
		
		System.out.println();
		
		return list;
	}
}
