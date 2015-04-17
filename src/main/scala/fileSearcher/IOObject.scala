package fileSearcher

/**
 * Created by Jorge on 4/13/15.
 */
import java.io.File

trait IOObject {
  val file: File
  val name = file.getName()
}