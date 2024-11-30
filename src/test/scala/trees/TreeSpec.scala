package trees

class TreeSpec extends UnitSpec {
  val n2: Node = Node(4, None, None)
  val n4: Node = Node(5, None, None)
  val n3: Node = Node(7, Some(n4), None)
  val n1: Node = Node(2, Some(n2), Some(n3))

  val root: Node = n1
  val bTree: BTree = BTree(Some(root))

  "A BTree inorder traversal" should "traverse nodes in the order root -> leftChildTree -> rightChildTree" in {
    val traversedNodes: List[Int] = Tree.traverseInPreOrder(bTree.root.toList, Nil)
    assert(traversedNodes == List(2,4,7,5))
  }

  "A BTree check leaves" should "check if a node is a leaf" in {
    val isn2Leaf: Boolean = Tree.isNodeLeave(n2)
    val isn1Leaf: Boolean = Tree.isNodeLeave(n1)
    assert(isn2Leaf)
    assert(!isn1Leaf)
  }

  "A BTree leaves collection" should "collect leaves" in {
    val leaves: List[Int] = Tree.collectLeaves(bTree.root.toList, Nil)
    assert(leaves == List(4,5))
  }
}
