package fileSearcher

import org.scalatest.FlatSpec
import java.io.File

/**
  * Created by Jorge on 4/14/15.
 */
class MatcherTests extends FlatSpec{

  "Matcher that is passed a file matching the filter" should
  "return a list with that file name" in {
    val file = new File("/Users/Jorge/dev/workspace/scala/fileSearcher/build.sbt")
    val matcher = new Matcher("build", file)

    val result = matcher execute

    assert(result == List("build.sbt"))
  }

  "Matcher using a directory containing one file matching the filter" should
  "return a list with that file name" in {
    val file = new File("/Users/Jorge/dev/workspace/scala/fileSearcher/testfiles")
    val matcher = new Matcher("txt", file)
    val result = matcher execute()
    assert(result == List())
  }

}