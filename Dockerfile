# First stage, SBT, identifer named `builder`
FROM mozilla/sbt:8u232_1.3.13 AS builder

# ADD all source
ADD . /
# Run SBT clean and test, if tests fail, the docker image will not build
RUN sbt clean test

# Build uber-jar, skipping tests --- I already ran them above
RUN sbt 'set test in assembly := {}' assembly

# Second stage, OpenJDK for JVM runtime
FROM adoptopenjdk/openjdk11:jdk-11.0.7_10-debian-slim

# COPY the jar built in the first stage into this stage, I am intentionally removing the version from the JAR filename
COPY --from=builder ./target/scala-2.12/multistagedocker-assembly-*jar /multistagedocker.jar

# Set ENTRYPOINT to uberjar
ENTRYPOINT ["java", "-jar", "/multistagedocker.jar"]