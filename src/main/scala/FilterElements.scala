object FilterElements {
    def main(args: Array[String]): Unit = {

        val nums: List[Int] = List(5,2,6,1,3,2,9)
        val evenNums: List[Int] = nums.filter(n => n % 2 == 0)
        evenNums.foreach(println)

        val agesNames: List[(Int, String)] = List((26, "Alex"), (29, "Max"), (24, "Jerry"), (32, "Mike"))
        val personsBelow30: List[String] = agesNames.filter(a => a._1 < 30).map(_._2)
        personsBelow30.foreach(println)

        val personsAbove30 = agesNames.filter { case (a: Int, n: String) =>
            a > 30
        }.map(_._2)
        personsAbove30.foreach(println)
    }
}