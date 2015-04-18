package fileSearcher

import java.io.File
import fileSearcher.IOObject
/**
 * Created by Jorge on 4/14/15.
 */
class Matcher(filter: String, file: File = new File("."), checkSubFolders: Boolean = false) {

  val rootIOObject = FileConverter.convertToIOObject(file)

  def execute() = {

    def recursiveMatch(files: List[IOObject],resultList: List[FileObject]): List[FileObject] = {

      files match {
        case List() => resultList
        case iOObject :: rest =>
          iOObject match {
            case file: FileObject if FilterChecker(filter) matches file.name =>
              recursiveMatch(rest, file :: resultList)
            case dir: DirectoryObject => recursiveMatch(rest ::: dir.getChildren(), resultList)
            case _ => recursiveMatch(rest, List())
          }
      }
    }

    val matchedFiles = rootIOObject match {
      case file : FileObject if FilterChecker(filter) matches file.name => List(file)
      case directory : DirectoryObject =>
        if (checkSubFolders){
          recursiveMatch(directory.getChildren(), List())
        }else{
          directory.getChildren
        }

      case _ => List()
    }
    matchedFiles map (IOObject => IOObject.name)
  }
}