Running this for the first time will work, because total files < 65535 and zip64 = false
> ./gradlew clean bootRepackage; java -jar build/libs/app-0.1-SNAPSHOT.war

Running this for the second time will not work, because total files > 65535 and zip64 = false
> ./gradlew clean bootRepackage; java -jar build/libs/app-0.1-SNAPSHOT.war

Running this for the third time (equal to alternative one) will work, because total files < 65535 and zip64 = false
> rm src/main/resources/*; ./gradlew clean bootRepackage; java -jar build/libs/app-0.1-SNAPSHOT.war

At this point we have total files > 65535 and zip64 = false. We change zip64 property to true and try to bootPackage it again
> Set zip64 = true in build.gradle in jar and war tasks.
> ./gradlew clean bootRepackage; java -jar build/libs/app-0.1-SNAPSHOT.war

java.lang.IllegalStateException: No 'Start-Class' manifest entry specified in jar:file:../boot-repackage-test/build/libs/app-0.1-SNAPSHOT.war!/
        at org.springframework.boot.loader.archive.Archive.getMainClass(Archive.java:57)
        at org.springframework.boot.loader.ExecutableArchiveLauncher.getMainClass(ExecutableArchiveLauncher.java:69)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:61)
        at org.springframework.boot.loader.WarLauncher.main(WarLauncher.java:61)

