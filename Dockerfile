FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} superchat.jar
ENTRYPOINT ["java", "-jar", "superchat.jar"]