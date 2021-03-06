package org.playwithscala

import java.io.File

object ControlStructures {
  
  def main(args: Array[String]) {
    grep(".*which.*")

    val filesHere = (new java.io.File(".")).listFiles

    def textFiles = 
      for {
        file <- filesHere if file.getName.endsWith(".txt")
      } yield file

    textFiles.foreach(println)
  }

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines.toList

  def grep(pattern: String) { 
    val filesHere = (new java.io.File(".")).listFiles
    for {                                  // nested loops
      file <- filesHere if file.getName.endsWith(".txt")
      line <- fileLines(file) if line.trim.matches(pattern)
    } println(file + ": " + line.trim)
  }

}
