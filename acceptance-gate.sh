#!/bin/bash
echo "Ejecutando Acceptance Gate..."
RESPUESTA=$(curl -s http://localhost:8080/sumar)
echo "Respuesta obtenida: $RESPUESTA"

if echo "$RESPUESTA" | grep -q "Resultado: 5"; then
    echo "✅ Acceptance Gate PASADO"
    exit 0
else
    echo "❌ Acceptance Gate FALLIDO"
    exit 1
fi