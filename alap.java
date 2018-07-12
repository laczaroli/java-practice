import java.util.Scanner;

class Node {
	public int value;
	public Node right;
	public Node left;
	
	Node(int value)
	{
		this.value = value;
		right = null;
		left = null;
	}
}

class BinaryTree {
	Node root;
	private int depth = 0;
	
	private Node addRec(Node current, int value)
	{
		if(current == null)
			return new Node(value);
		
		if(current.value > value)
			current.left = addRec(current.left,value);
		else if(current.value < value)
			current.right = addRec(current.right,value);
		else 
			return current;
		return current;
	}
	
	public void add(int value)
	{
		root = addRec(root,value);
	}
	
	public void kiir(Node temp)
	{
		if(temp != null)
		{
			depth++;
			for(int i = 0; i<depth; i++)
				System.out.print("-");
			kiir(temp.left);
			System.out.println(temp.value);
			kiir(temp.right);
		}
	}
	
}

class alap {
	
	public static void main(String[] args)
	{
		BinaryTree bintree = new BinaryTree();
		bintree.add(12);
		bintree.add(3);
		bintree.add(6);
		bintree.add(15);
		bintree.add(32);
		bintree.add(4);
		
		bintree.kiir(bintree.root);
	}
}