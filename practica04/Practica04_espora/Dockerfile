FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY src /app/src

RUN mkdir -p target \
    && javac -encoding UTF-8 -d target $(find src -name "*.java")

CMD ["java", "-cp", "target", "mx.unam.fciencias.espora.practica4.RockBuster"]