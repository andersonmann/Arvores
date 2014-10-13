package bst2;

import java.util.ArrayList;

public class BinarySearchTreeApp {

	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(20);
		t.insert(10);
		t.insert(30);
		t.insert(40);
		
		//System.out.println(t);
		
		//System.out.println(t.contains(100));
		//System.out.println(t.contains(30));

		//System.out.println(t.getDegreeFor(30));		

//		System.out.println(t.getLevelFor(20));		
//		System.out.println(t.getLevelFor(10));		
//		System.out.println(t.getLevelFor(30));		
//		System.out.println(t.getLevelFor(40));		
//		System.out.println(t.getLevelFor(15));		
		

//		System.out.println(t.getHeightFor(20));		
//		System.out.println(t.getHeightFor(10));		
//		System.out.println(t.getHeightFor(30));		
//		System.out.println(t.getHeightFor(40));		
//		System.out.println(t.getHeightFor(15));		
		
		System.out.println(t.getPathTo(20)); // [20]		
		System.out.println(t.getPathTo(10)); // [20, 10]		
		System.out.println(t.getPathTo(30)); // [20, 30]		
		System.out.println(t.getPathTo(40)); // [20, 30, 40]		
		//System.out.println(t.getPathTo(15)); // Exception!		
		
	}

	
	
}






