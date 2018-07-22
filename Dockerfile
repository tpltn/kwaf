FROM gradle:4.9.0-jdk10 AS builder
COPY --chown=gradle:gradle . ./
RUN gradle build

FROM openjdk:10-jre-slim
COPY --from=builder /home/gradle/build/libs/kwaf-*.jar /kwaf.jar
