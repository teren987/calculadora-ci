package cl.evaluacion.calculadora;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        String version = System.getenv().getOrDefault("APP_VERSION", "v1");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/health", exchange -> {
            String response = "OK - version " + version;
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.createContext("/sumar", exchange -> {
            Calculadora calc = new Calculadora();
            int resultado = calc.sumar(2, 3);
            String response = "Resultado: " + resultado + " (version " + version + ")";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Servidor corriendo en puerto 8080, version=" + version);
    }
}
