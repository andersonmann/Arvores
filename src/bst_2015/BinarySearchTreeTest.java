package bst_2015;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	/*
	@Test
	public void testGetChildrenNoChildren() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		int[] actual = bst.getChildren(100);
		assertEquals(0, actual.length);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetChildrenNotFound() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		bst.getChildren(200);
	}

	@Test
	public void testGetChildrenOneChildLeft() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		bst.add(50);
		int[] actual = bst.getChildren(100);
		assertEquals(1, actual.length);
		assertEquals(50, actual[0]);
	}

	@Test
	public void testGetChildrenOneChildRight() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		bst.add(150);
		int[] actual = bst.getChildren(100);
		assertEquals(1, actual.length);
		assertEquals(150, actual[0]);
	}

	@Test
	public void testGetChildrenTwoChildren() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		bst.add(50);
		bst.add(150);
		int[] actual = bst.getChildren(100);
		assertEquals(2, actual.length);
		assertEquals(50, actual[0]);
		assertEquals(150, actual[1]);
	} */

	@Test(expected = IllegalArgumentException.class)
	public void testGetParentNoParent() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		bst.getParent(100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParentNotFound() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		bst.getParent(200);
	}

	@Test
	public void testGetParentLeft() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		bst.add(50);
		int actual = bst.getParent(50);
		assertEquals(100, actual);
	}

	@Test
	public void testGetParentRight() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(100);
		bst.add(150);
		int actual = bst.getParent(150);
		assertEquals(100, actual);
	}

}
