package application;

public class TreeNode<T> {
	TreeNode rChild;
	TreeNode lChild;
	T data;
	
	public TreeNode(T dataNode) {
		rChild = null;
		lChild = null;
		data = dataNode;
	}
	
	public TreeNode TreeNode(TreeNode<T> node) {
		TreeNode copyNode = new TreeNode(node.getData());
		return copyNode;
	}
	
	public boolean hasChildren() {
		return (rChild != null || lChild != null);
	}

	public TreeNode getR() {
		return rChild;
	}

	public void setR(TreeNode rChild) {
		this.rChild = rChild;
	}

	public TreeNode getL() {
		return lChild;
	}

	public void setL(TreeNode lChild) {
		this.lChild = lChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
