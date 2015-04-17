package fileSearcher

import org.scalatest.{FlatSpec, FunSuite}
import java.io.File
/**
 * Created by Jorge on 4/13/15.
 */
class FileCheckerTest extends FlatSpec{

  "FilterChecker passed a list where one file matches the filter" should
    "return a list with that file" in {

    val matchingFile = FileObject(new File("match"))
    val listOfFiles = List(FileObject(new File("random")), matchingFile)

    val matchedFiles = FilterChecker("match") findMatchedFiles listOfFiles
    assert(matchedFiles == List(matchingFile))

  }

  "FilterChecker passed a list with a directory that matches the filter" should
    "not return the directory" in {
    val matchingDirectory =  DirectoryObject(new File("match"))
    val listOfFiles  = List(DirectoryObject(new File("random")), matchingDirectory)

    val matchedFiles = FilterChecker("match") findMatchedFiles listOfFiles
    assert(matchedFiles.size == 0)
  }
}