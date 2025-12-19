package com.ibkWeb.auto.config;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentManager {

    // Ambiente por defecto si no se pasa nada (uat)
    private static final String DEFAULT_ENV = "uat";

    // Objeto Properties donde se cargan las configuraciones
    private static Properties props = new Properties();

    // Método que carga el archivo de propiedades según el ambiente
    public static void load() {
        // Primero busca el parámetro de sistema (-Denv=dev) o la variable de entorno ENV,
        // si no encuentra nada usa "uat" como valor por defecto
        String env = System.getProperty("env", System.getenv().getOrDefault("ENV", DEFAULT_ENV));

        // Construye la ruta del archivo dentro de resources/config
        String path = String.format("/config/%s.properties", env);

        try (InputStream is = EnvironmentManager.class.getResourceAsStream(path)) {
            // Carga el archivo de propiedades
            props.load(is);

            // Reemplaza valores que estén definidos como ${VAR} con variables de entorno reales
            props.forEach((k, v) -> {
                String val = String.valueOf(v);
                if (val.startsWith("${") && val.endsWith("}")) {
                    String envVar = val.substring(2, val.length() - 1);
                    String resolved = System.getenv(envVar);
                    if (resolved != null) props.setProperty((String) k, resolved);
                }
            });

            // Configura propiedades del sistema para Serenity/WebDriver
            System.setProperty("webdriver.base.url", props.getProperty("app.url"));
            System.setProperty("webdriver.driver", props.getProperty("browser", "chrome"));

        } catch (Exception e) {
            // Si no encuentra o no puede cargar el archivo, lanza excepción clara
            throw new RuntimeException("No se pudo cargar configuración: " + path, e);
        }
    }

    // Obtener una propiedad (prioriza System Properties sobre archivo)
    public static String get(String key) {
        // Primero busca en System Properties (-Dkey=value)
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.trim().isEmpty()) {
            return systemValue;
        }
        // Si no existe, busca en el archivo de propiedades
        return props.getProperty(key);
    }


    public static String get(String key, String defaultValue) {
        // Primero busca en System Properties (-Dkey=value)
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.trim().isEmpty()) {
            return systemValue;
        }
        // Si no existe, busca en el archivo de propiedades
        return props.getProperty(key, defaultValue);
    }
}

