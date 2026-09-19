#!/bin/bash
echo "🔄 Fallo detectado. Ejecutando rollback a la última versión estable (v1)..."
docker stop calculadora-app && docker rm calculadora-app
docker run -d --name calculadora-app -p 8080:8080 -e APP_VERSION=v1 calculadora:v1
sleep 2
echo "Verificando estado tras rollback..."
curl -s http://localhost:8080/sumar