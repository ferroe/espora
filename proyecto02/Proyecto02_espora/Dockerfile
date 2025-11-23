# Dockerfile para Xochilotito
# Utiliza Java 17 con soporte para JavaFX y VNC para acceso web

FROM eclipse-temurin:17

# 1. Instalación de dependencias del sistema (GUI, VNC, Maven)
RUN apt-get update && apt-get install -y \
    libx11-6 libxext6 libxrender1 libxtst6 libxi6 \
    libgtk-3-0 libgtk-3-dev libglib2.0-0 \
    libpango-1.0-0 libpangocairo-1.0-0 \
    libcairo2 libcairo-gobject2 \
    libgdk-pixbuf2.0-0 libfontconfig1 libfreetype6 \
    maven \
    tigervnc-standalone-server tigervnc-common \
    fluxbox xterm \
    wget git python3 python3-numpy net-tools \
    && rm -rf /var/lib/apt/lists/*

# 2. Instalar noVNC (El puente para ver la app en el navegador)
RUN git clone https://github.com/novnc/noVNC.git /opt/noVNC && \
    git clone https://github.com/novnc/websockify /opt/noVNC/utils/websockify && \
    ln -s /opt/noVNC/vnc.html /opt/noVNC/index.html

# 3. Configuración del Proyecto
WORKDIR /app

# Copiar pom.xml y descargar dependencias (Capa de caché)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Compilar el proyecto (Opcional: verifica que compile antes de correr)
RUN mvn clean package -DskipTests

# 4. Configuración de VNC
RUN mkdir -p /root/.vnc

# Copiar script de arranque
COPY start-vnc.sh /usr/local/bin/start-vnc.sh
RUN chmod +x /usr/local/bin/start-vnc.sh

# Variables de entorno necesarias para JavaFX
ENV _JAVA_OPTIONS="-Djava.awt.headless=false"
ENV DISPLAY=:1
ENV USER=root

# Exponer puerto 80 (Web)
EXPOSE 80

# Comando de inicio
CMD ["/usr/local/bin/start-vnc.sh"]