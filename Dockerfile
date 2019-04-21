FROM gradle:5.4.0-jdk11-slim AS builder
COPY --chown=gradle:gradle . ./
RUN gradle bootJar --info

FROM openjdk:11.0.3-jre-slim
RUN mkdir -p /app
WORKDIR /app
COPY --from=builder /home/gradle/build/libs/kwaf.jar /app/kwaf.jar
