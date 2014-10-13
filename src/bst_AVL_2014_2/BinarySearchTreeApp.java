package bst_AVL_2014_2;

import java.util.ArrayList;

public class BinarySearchTreeApp {

	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(20);
		t.insert(10);
		t.insert(30);
		t.insert(40);
		t.insert(5);
		t.insert(15);
		t.insert(25);
		
		
		
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
		
//		System.out.println(t.getPathToRoot(20)); // [20]		
//		System.out.println(t.getPathToRoot(10)); // [20, 10]		
//		System.out.println(t.getPathToRoot(30)); // [20, 30]		
//		System.out.println(t.getPathToRoot(40)); // [20, 30, 40]		
		//System.out.println(t.getPathTo(15)); // Exception!		
		
//		System.out.println(t.getParent(30)); // 20		
//		System.out.println(t.getParent(40)); // 30		
//		System.out.println(t.getParent(10)); // 20		
//
//		System.out.println(t.getUncle(40)); // 10		
//		System.out.println(t.getEven());
//		
//		t.visit(new PrintProcessor());
//		
//		EvenProcessor ep = new EvenProcessor();
//		t.visit(ep);
//		System.out.println(ep.getResult());
//		
//		t.drawTree2();
//		System.out.println(t.getEvenChild());
		
//		System.out.println(t.check());
//		t.preorder();
//		t.central();
//		t.postorder();
		System.out.println(t.getLeaf());
		System.out.println(t.getPath(5, 15));
	}

	

}













