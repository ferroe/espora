FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY src /app/src
COPY clientes.txt /app/
COPY cuentas.txt /app/
COPY cuentas_servicios.txt /app/

RUN mkdir -p target \
    && javac -encoding UTF-8 -d target $(find src -name "*.java")

EXPOSE 1099
EXPOSE 1100

CMD ["java", "-cp", "target", "mx.unam.fciencias.espora.proyecto1.PumaBank"]