FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY src /app/src

RUN mkdir -p target \
    && javac -encoding UTF-8 -d target $(find src -name "*.java")

EXPOSE 1099
EXPOSE 1100

CMD ["java", "-cp", "target", "mx.unam.fciencias.espora.proyecto1.PumaBank"]