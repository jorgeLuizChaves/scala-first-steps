package fileSearcher

import java.io.File

/**
 * Created by Jorge on 4/14/15.
 */
class Matcher(filter: String, file: File = new File(".")) {

  import java.io.File

  val rootIOObject = FileConverter.convertToIOObject(file)

  def execute() = {
    val matchedFiles = rootIOObject match {
      case file : FileObject if FilterChecker(filter) matches file.name => List(file)
      case directory : DirectoryObject => directory.getChildren
      case _ => List()
    }
    matchedFiles map (IOObject => IOObject.name)
  }
}