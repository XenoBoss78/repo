package application;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface{
	TreeNode rootNode ;
	
	public MorseCodeTree() {
		rootNode = new TreeNode(" ");
		this.buildTree();
	}
	
	@Override
	public TreeNode getRoot() {
		return rootNode;
	}

	@Override
	public void setRoot(TreeNode newNode) {
		rootNode = newNode;
	}

	@Override
	public LinkedConverterTreeInterface insert(Object code, Object result) {
		addNode(this.getRoot(),(String) code,(String) result);
		return this;
	}

	public void addNode(TreeNode<String> root, String code, String letter) {
		
		TreeNode newNode = new TreeNode(letter);
		if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				root.setL(newNode);
			} else {
				root.setR(newNode);
			}
		} else {
			TreeNode newRoot;
			if (code.charAt(0) == '.') {
				newRoot = root.getL();
			} else {
				newRoot = root.getR();
			}
			addNode(newRoot, code.substring(1), letter);
		}
	}

	@Override
	public Object fetch(String code) {
		return fetchNode(this.getRoot(), code);
	}

	public Object fetchNode(TreeNode root, String code) {
		if (code.length() == 1) {
			TreeNode temp;
			if (code.charAt(0) == '.') {
				temp = root.getL();
			} else {
				temp = root.getR();
			}
			return temp.getData();
		} else {
			TreeNode newRoot;
			if (code.charAt(0) == '.') {
				newRoot = root.getL();
			} else {
				newRoot = root.getR();
			}
			return fetchNode(newRoot, code.substring(1));
		}
	}

	@Override
	public LinkedConverterTreeInterface delete(Object data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildTree() {
		insert(".", "e"); 
		insert("-", "t");

		insert("..", "i"); 
		insert(".-", "a"); 
		insert("-.", "n");
		insert("--", "m"); 
		
		insert("...", "s");
		insert("..-", "u"); 
		insert(".-.", "r");
		insert(".--", "w"); 
		insert("-..", "d");
		insert("-.-", "k"); 
		insert("--.", "g");
		insert("---", "o"); 
		
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f"); 
		insert(".-..", "l");
		insert(".--.", "p"); 
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c"); 
		insert("-.--", "y");
		insert("--..", "z"); 
		insert("--.-", "q");
		
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> treeList = new ArrayList();
		treeList = LNRoutputTraversal(this.getRoot(),treeList);
		return treeList;
	}

	@Override
	public ArrayList LNRoutputTraversal(TreeNode root, ArrayList list) {
		String answer = LNRoutputTraversal(root);
		for (char a: answer.toCharArray()) {
			list.add(a);
		}
		return list;
	}
	
	public String LNRoutputTraversal(TreeNode root) {
		
		if (root.hasChildren()) {
			if (root.lChild == null) {
				return (String) (root.getData() + LNRoutputTraversal(root.getR()));
			} else if (root.rChild == null) {
				return (String) (LNRoutputTraversal(root.getL()) + root.getData());
			} else { 
				return (String) (LNRoutputTraversal(root.getL()) + root.getData() + LNRoutputTraversal(root.getR()));
			}
		} else {
			return (String) root.getData();
		}
	}


	@Override
	public void addNode(TreeNode root, Object code, Object letter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object fetchNode(TreeNode root, Object code) {
		// TODO Auto-generated method stub
		return null;
	}

}
