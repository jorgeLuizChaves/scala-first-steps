package fileSearcher

/**
 * Created by Jorge on 4/13/15.
 */
class FilterChecker(filter: String) {

  def matches(content: String) = content contains filter

  def findMatchedFiles(files: List[IOObject]) =
    for (file <- files
         if (file.isInstanceOf[FileObject])
         if (matches(file.name)))
      yield file
}

object FilterChecker{
  def apply(name: String) = new FilterChecker(name)
}