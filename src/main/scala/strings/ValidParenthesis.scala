package strings

import scala.annotation.tailrec

object ValidParenthesis {
    def main(args: Array[String]): Unit = {
      val str = "()()(())"
      areParenthesisValid(str) match {
        case Left(exception) => println(s"Error: $exception")
        case Right(isParenthesisValid) => println(s"Does $str have valid parenthesis: $isParenthesisValid")
      }
    }

    def areParenthesisValid(str: String): Either[Exception, Boolean] = if (str.isEmpty)
      Left(throw new Exception("String is empty."))
    else areParenthesisValid(str, 0, 0)

    @tailrec
    private def areParenthesisValid(str: String, currIndex: Int, score: Int): Either[Exception, Boolean] = {
      if (score < 0)
        Right(false)
      else if (currIndex == str.length)
       Right(score == 0)
      else if (str.charAt(currIndex) == '(')
        areParenthesisValid(str, currIndex + 1, score + 1)
      else if (str.charAt(currIndex) == ')')
        areParenthesisValid(str, currIndex + 1, score - 1)
      else
        Left(throw new Exception("String contains invalid character"))
    }
}
