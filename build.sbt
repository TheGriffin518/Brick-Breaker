name := "cs1302-fxgame"

version := "1.0"

autoScalaLibrary := false

unmanagedSourceDirectories in Compile <<= Seq(javaSource in Compile).join

unmanagedSourceDirectories in Test <<= Seq(javaSource in Test).join

libraryDependencies += "com.novocode" % "junit-interface" % "0.8" % "test->default"

fork in run := true

