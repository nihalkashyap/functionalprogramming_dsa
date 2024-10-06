package trees

case class Node(value: Int, left: Option[Node], right: Option[Node])
case class BTree(root: Option[Node])

object Tree {

  def main(args: Array[String]): Unit = {
    /*
    *           n1
    *         /   \
    *        n2    n3
    *             /
    *            n4
    * */

    val n2 = Node(4, None, None)
    val n4 = Node(5, None, None)
    val n3 = Node(7, Some(n4), None)
    val n1 = Node(2, Some(n2), Some(n3))

    val root = n1
    val bTree = BTree(Some(root))
    dfTraverse(bTree)
  }

  // Depth First Traversal
  private def dfTraverse(bTree: BTree): Unit = {

    bTree.root match {
      case Some(root) => traverse(Some(root))
      case None => println(s"The Binary tree is empty.")
    }

    // TODO Make it tail recursive
    def traverse(node: Option[Node]): Unit = {
      node.foreach { node =>
        println(node.value)
        traverse(node.left)
        traverse(node.right)
      }
    }
  }
}