
public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		int size = 9;
		CompliteBinaryTree<Character>tree = new CompliteBinaryTree(size);
		
		for (int i = 0; i < size; i++) {
			tree.add((char)('A' + i));
		}
		
		//tree.bfs3();

		tree.dfsByPreOrder(1);
		System.out.println();
		tree.dfsByInOrder(1);
		System.out.println();
		tree.dfsByInOrder(1);
		System.out.println();
		tree.dfs();
	}

}
