# myip

### To test or run

* To test or run, clone this repo to get the project files locally and either:
1. To run the the unit tests, type `./gradlew test` in the project root (I'm on a unix like system)
2. To run the tiny sample application, type `./gradlew run`

Or one could import import into IDE (say intellij) to run the main class demo. 

### To use as library
To create a jar file to use as a dependency, type `./gradlew jar` in the project root. The jar file is then located at `build/libs/my.ip-1.0-SNAPSHOT.jar`. Please see the test or app for usage:
##### Construct:
`Ip ip = new Ip("192.168.0.1");`
##### Get numerical ip address
`ip.getIpAddress());`
>3232235521
##### Get string octet address back
`ip.toString();`
>192.168.0.1 


### Relevant files
Relevant files are in `src/main/java` and `src/test/java` (and the gradle build files is at the project root).
