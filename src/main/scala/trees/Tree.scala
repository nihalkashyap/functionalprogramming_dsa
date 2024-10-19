package trees

import scala.annotation.tailrec

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
      case Some(root) =>
        val traversedNodes = traverse(List(root), Nil)
        println(traversedNodes)
      case None => println(s"The Binary tree is empty.")
    }

    @tailrec
    def traverse(nodes: List[Node], acc: List[Int]): List[Int] = {
      nodes match {
        case ::(head, next) =>
          val left = head.left
          val right = head.right
          traverse(left.toList ++ right.toList ++ next, head.value :: acc) // append new value to the beginning of the list to keep run time complexity O(1)

        case Nil => acc.reverse
      }
    }
  }
}