FROM gradle:4.10.0-jdk10 AS builder
COPY --chown=gradle:gradle . ./
RUN gradle bootJar --info

FROM openjdk:10-jre-slim
COPY --from=builder /home/gradle/build/libs/kwaf.jar /kwaf.jar
