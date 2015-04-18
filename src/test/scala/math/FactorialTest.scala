package math

import org.scalatest.FlatSpec

/**
 * Created by Jorge on 4/18/15.
 */
class FactorialTest extends FlatSpec{

  "passed a number" should "return the factorial" in {
    val factorial = new Factorial()
    val result = factorial.factorialNumber(3)
    assert(result == 6)
  }
}
