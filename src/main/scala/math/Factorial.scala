package math

/**
 * Created by Jorge on 4/18/15.
 */
class Factorial {

  def factorialNumber(num: Int): Int = {

    def factHelper(num: Int, acc: Int): Int = {
      if (num == 0){
        acc
      } else{
        factHelper(num - 1, acc * num)
      }
    }

    factHelper(num, 1)
  }
}
