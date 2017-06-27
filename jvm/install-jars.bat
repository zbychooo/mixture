@echo off

call:install-tt-jar "jvm-classloading-v1.jar"
call:install-tt-jar "jvm-classloading-v2.jar"
call:install-tt-jar "jvm-classloading-v3.jar"

goto:eof

:install-tt-jar
call mvn install:install-file -Dfile=libs\%~1 -DgroupId=pl.com.tt -DartifactId=%~1 -Dversion=1.0-SNAPSHOT -Dpackaging=jar

::mvn exec:java -Dexec.mainClass="com.transition.technologies.classloaders.Example2"
::java -cp "..\..\libs\jvm-classloading-v3.jar;." com.technologies.transition.classloaders.Example2