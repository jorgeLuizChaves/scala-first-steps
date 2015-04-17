package fileSearcher

import java.io.File
import fileSearcher.FileConverter
/**
 * Created by Jorge on 4/13/15.
 */
case class DirectoryObject(file: File) extends IOObject{



  def getChildren() =
    try{
      file.listFiles().toList map(file => FileConverter convertToIOObject(file))
    } catch{
      case _ : NullPointerException => List()
    }
}