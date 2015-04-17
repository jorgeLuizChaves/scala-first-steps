package fileSearcher

import java.io.File
import org.scalatest.FlatSpec

/**
  * Created by Jorge on 4/16/15.
 */
class FileConverterTest extends FlatSpec{

  "passed a directory path" should "return a DirectoryObject instance" in {
    val directory  = FileConverter convertToIOObject(new File("."))
    assert(directory.isInstanceOf[DirectoryObject])
  }

  "passed a file path" should "return a FileObject instance" in {
    val file = FileConverter convertToIOObject(new File("build.sbt"))
    assert(file.isInstanceOf[FileObject])
  }

  "passed no path" should "return a Directory instance" in {
    val dir = FileConverter convertToIOObject()
    assert(dir.isInstanceOf[DirectoryObject])
  }
}
