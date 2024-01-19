# CHALLENGE AUTOMATIZACIÓN YAPE

---

## Herramientas implementadas:
* Serenity BDD
* Serenity Rest
* Appium
* Selenium
* Cucumber
* JUnit
* Lombok

### Patron de diseño:
* Screenplay

### Lenguaje de programación:
* Java

### Gestor de dependencias:
* Gradle

---

## Pre-Condiciones:
* Tener instalado el [JDK](https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html) de Java con una versión igual o superior a 1.8.
* Tener instalado y configurado [GRADLE](https://gradle.org/releases/).
* Tener instalado [Appium](https://github.com/appium/appium-desktop/releases) en el sistema. 
* Clona el proyecto desde la rama principal **`main`** utilizando el siguiente comando:
    * `git clone https://github.com/dfmerchan2/challenge-yape.git`
---

## Integración Continua

En GitHub Actions, se ha implementado el archivo `pipeline.yml` para llevar a cabo la compilación, ejecución de pruebas y generar el informe de Serenity.

---
## Compilar y ejecutar
* ### Ejecución Mobile
  * Asegúrate de tener el Appium Server en ejecución.
  * En la clase **`MyDriver`** ubicada en `src/main/java/co/com/yape/mobile/utilities/MyDriver.java` configura los datos del dispositivo o emulador donde se llevará a cabo la ejecución de la prueba.
    * **`deviceName:`** Nombre del dispositivo.
    * **`platformVersion:`** Versión de Android del dispositivo.
* ### Comandos Gradle
```
gradle build -x test                                                        (Compila el proyecto, excluyendo la ejecución de pruebas.)
gradle test --tests *ConsultBookingRunner* =>                               (Ejecuta un Runner específico llamado)
gradle test --tests *ConsultBookingRunner* --tests *CreateBookingRunner*    (Ejecuta varios Runners específicos)
gradle test aggregate                                                       (Ejecuta toda la suite de pruebas en el proyecto y genera un informe de Serenity.)
gradle clean test --tests "co.com.yape.backend.runner.*" aggregate -i       (Ejecutar un paquete de Runners, limpia el proyecto, y genera un informe de Serenity, mostrando información detallada)
```

---
## Reporte Serenity
* Una vez completada la ejecución de las pruebas, dirígete a la ruta **"target/site/serenity"** y abre el archivo **index.html** en tu navegador para visualizar el informe generado por Serenity.

![img.png](src/main/resources/images/img.png)
![img_1.png](src/main/resources/images/img_1.png)
---



## Autor 🤖

* Diego Fernando Merchan Jimenez
    