#!/bin/bash

# Configuración de pantalla virtual
export DISPLAY=:1
export RESOLUTION=1920x1080
# Nota: Bajé la resolución a 720p para asegurar que se vea bien en laptops
# Si prefieres 1080p, cámbialo a 1920x1080

mkdir -p ~/.vnc

echo "--- Iniciando Xochilotito en Docker ---"

# 1. Iniciar servidor VNC (Sin contraseña para facilidad de uso local)
echo "1. Iniciando servidor VNC..."
vncserver :1 -geometry $RESOLUTION -depth 24 -localhost no -SecurityTypes None --I-KNOW-THIS-IS-INSECURE

# Esperar a que VNC esté listo
sleep 3

# 2. Iniciar puente Web (noVNC)
echo "2. Iniciando interfaz web (puerto 80)..."
/opt/noVNC/utils/novnc_proxy --vnc localhost:5901 --listen 80 &

# 3. Iniciar Gestor de Ventanas (Fluxbox)
# (Necesario para poder mover la ventana y tener bordes)
echo "3. Iniciando gestor de ventanas..."
DISPLAY=:1 fluxbox &

sleep 2

# 4. Ejecutar tu Aplicación JavaFX
echo "4. Ejecando Maven JavaFX Run..."
cd /app
DISPLAY=:1 mvn javafx:run

# Mantener el contenedor vivo si la app falla o se cierra
# tail -f /dev/null