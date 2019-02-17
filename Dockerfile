FROM gradle:5.2.1-jdk11 AS builder
COPY --chown=gradle:gradle . ./
RUN gradle bootJar --info

FROM openjdk:11.0.2-jre-slim
RUN mkdir -p /app
WORKDIR /app
COPY --from=builder /home/gradle/build/libs/kwaf.jar /app/kwaf.jar
