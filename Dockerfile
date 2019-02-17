FROM gradle:5.2.1-jdk11 AS builder
COPY --chown=gradle:gradle . ./
RUN gradle bootJar --info

FROM openjdk:11.0.2-jre-slim
COPY --from=builder /home/gradle/build/libs/kwaf.jar /kwaf.jar
