package lzc.demo.algorithm;


/**
 * @author liuzongchang
 * @create 2019-06-05 13:47
 **/
public class BinaryTree {

	// 根节点
	private TreeNode root;

	public BinaryTree(){

	}

	public BinaryTree(TreeNode root){
		this.root = root;
	}

	public static void main(String[] args) {
		TreeNode l21 = new TreeNode("left21",null,null);
		TreeNode r21 = new TreeNode("right21",null,null);
		TreeNode l22 = new TreeNode("left22",null,null);
		TreeNode r22 = new TreeNode("right22",null,null);

		TreeNode l11 = new TreeNode("left11",l21,r21);
		TreeNode r11 = new TreeNode("right1",l22,r22);
		TreeNode root = new TreeNode("root",l11,r11);

		BinaryTree binaryTree = new BinaryTree(root);
		System.out.println("=======先序遍历======");
		binaryTree.preOrder(root);
		System.out.println("=======中序遍历======");
		binaryTree.inOrder(root);
		System.out.println("=======后序遍历======");
		binaryTree.postOrder(root);

		System.out.println();
		System.out.println("===================");
		System.out.println("树的高度为" + binaryTree.getHeight());
		System.out.println("树的大小为" + binaryTree.getSize());

	}

	// 返回父节点
	public TreeNode getParent(TreeNode element){
		return (root == null || root == element) ? null : parent(root,element);
	}

	// 从subTreeRoot开始寻找父节点
	private TreeNode parent(TreeNode subTreeRoot, TreeNode element) {
		if(subTreeRoot == null){
			return null;
		}

		if(subTreeRoot.getLeft() == element || subTreeRoot.getRight() == element){
			return subTreeRoot;
		}

		TreeNode p;
		if((p=parent(subTreeRoot.getLeft(),element)) !=null){
			return p;
		}
		else {
			return parent(subTreeRoot.getRight(),element);
		}
	}

	public int getSize(){
		return getNum(root);
	}

	//递归获取子树的节点个数
	public int getNum(TreeNode subTreeRoot) {
		if(subTreeRoot == null){
			return 0;
		}else {
			int i = getNum(subTreeRoot.getLeft());
			int j = getNum(subTreeRoot.getRight());
			return  i + j + 1;
		}
	}

	//获取二叉树的总高度
	public int getHeight(){
		return getHeight(root);
	}

	//获取二叉树子树的高度
	public int getHeight(TreeNode subTreeRoot) {
		if(subTreeRoot == null){
			return 0;
		}else {
			int i = getHeight(subTreeRoot.getLeft());
			int j = getHeight(subTreeRoot.getRight());
			return (i<j)? (j +1) :(i+1);
		}
	}

	//前序遍历
	public void  preOrder(TreeNode subTreeRoot){
		if(subTreeRoot != null){
			System.out.println(subTreeRoot.getData());
			preOrder(subTreeRoot.getLeft());
			preOrder((subTreeRoot.getRight()));
		}
	}

	//中序遍历
	public void inOrder(TreeNode subTreeRoot){
		if (subTreeRoot != null){
			inOrder(subTreeRoot.getLeft());
			System.out.println(subTreeRoot.getData());
			inOrder(subTreeRoot.getRight());
		}
	}

	//后续遍历
	public void postOrder(TreeNode subTreeRoot){
		if(subTreeRoot != null){
			postOrder(subTreeRoot.getLeft());
			postOrder(subTreeRoot.getRight());
			System.out.println(subTreeRoot.getData());
		}
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}


	/**
	  * 内部节点类
	  * @version 1.0  2019/6/5 13:55
	  */
	private static class TreeNode{
		private String data = null;
		//坐节点的引用
		private TreeNode left;
		//右节点的引用
		private TreeNode right;

		public TreeNode(){

		}

		public TreeNode(String data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}
	}
}
