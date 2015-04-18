package fileSearcher

/**
 * Created by Jorge on 4/14/15.
 */
import java.io.File
import javax.tools.FileObject

object FileConverter {


  def convertToIOObject(file: File = new File(".")) = {
  if (file.isDirectory()){
      DirectoryObject(file)
    }else{
      FileObject(file)
    }
  }
}