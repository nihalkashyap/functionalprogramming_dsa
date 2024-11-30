package trees

class TreeSpec extends UnitSpec {
  "A BTree inorder traversal" should "traverse nodes in the order root -> leftChildTree -> rightChildTree" in {

    val n2 = Node(4, None, None)
    val n4 = Node(5, None, None)
    val n3 = Node(7, Some(n4), None)
    val n1 = Node(2, Some(n2), Some(n3))

    val root = n1
    val bTree = BTree(Some(root))

    val traversedNodes: List[Int] = Tree.traverseInPreOrder(bTree.root.toList, Nil)
    assert(traversedNodes == List(2,4,7,5))
  }
}
