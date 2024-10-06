object ZipWithIndex {

  def main(args: Array[String]): Unit = {

    val nums: List[Int] = List(5,2,6,1,3,2,9)
    val numsWithIndex: List[(Int, Int)] = nums.zipWithIndex
    numsWithIndex.foreach(println)

    val numsWithIndexOnly: List[Int] = nums.zipWithIndex.map(_._2)
    numsWithIndexOnly.foreach(println)
  }
}