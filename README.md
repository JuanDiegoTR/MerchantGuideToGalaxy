# Merchant Guide to Galaxy

Este proyecto es una aplicación de consola escrita en Java que ayuda a los comerciantes intergalácticos a convertir unidades intergalácticas en números romanos, crear metales con valores asignados en créditos y realizar consultas sobre el valor de estos metales.

## Funcionalidades

- Conversión de unidades intergalácticas a números romanos.
- Creación de metales con sus valores en créditos.
- Consultas sobre el valor de metales específicos.

## Instrucciones de uso

1. Clona el repositorio o descarga el código fuente.
2. Abre el proyecto en tu entorno de desarrollo preferido.
3. Compila y ejecuta la clase `MerchantGuideToGalaxy.java`.
4. Sigue las instrucciones en la consola para interactuar con la aplicación.

## Uso de la aplicación

El programa proporciona un menú de opciones donde el usuario puede seleccionar qué acción realizar:

- **Convertir unidades intergalácticas:** Esta opción permite al usuario ingresar unidades intergalácticas y convertirlas en números romanos.
- **Crear metal:** Permite al usuario ingresar el nombre de un metal y su valor en créditos para agregarlo al sistema.
- **Realizar consulta sobre el valor de un metal:** Esta opción permite al usuario realizar consultas sobre el valor de un metal específico ingresando sus unidades intergalácticas correspondientes.

## Ejemplos de entrada y salida

A continuación se muestran ejemplos de entrada y salida para el uso de la aplicación:

*Entrada: opción 1*
Menu:
1. Convertir unidades intergalácticas a números romanos.
2. Crear metal.
3. Realizar consulta sobre el valor de un metal.
4. Salir.
Ingrese su opción: 1
Ingrese las unidades intergalácticas: pish tegj glob glob

*Salida:*
El valor en números romanos es: XLII
El valor decimal es: 62

*Entrada: opción 2*
Menu:
1. Convertir unidades intergalácticas a números romanos.
2. Crear metal.
3. Realizar consulta sobre el valor de un metal.
4. Salir.
Ingrese su opción: 2

*Salida:*
Ingrese el nombre del metal o 'done' para terminar: Hierro
Ingrese el valor en créditos para Hierro: 10
El metal Hierro ha sido creado con un valor de 10 créditos.
Ingrese el nombre del metal o 'done' para terminar: done

*Entrada: opción 3*
Menu:
1. Convertir unidades intergalácticas a números romanos.
2. Crear metal.
3. Realizar consulta sobre el valor de un metal.
4. Salir.
Ingrese su opción: 3

*Salida:*
glob I
prok V
pish X
tegj L
Ingrese las unidades intergalácticas: pish
Ingrese el nombre del metal: Hierro
pish
Hierro
El valor en números romanos es: XX. El valor en créditos es: 10

## Requisitos
- **Java JDK 17 o superior.
- **IDE Itellij.

## Comando
Para generar el archivo JAR del proyecto, ejecuta el siguiente comando en la terminal o símbolo del sistema:
```bash
mvn clean install
Para correr las pruebas Unitarias:
mvn test
