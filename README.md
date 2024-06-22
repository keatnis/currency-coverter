 # Conversor de Monedas 

## Indice
## Descripción del Proyecto:
  Este es un Conversor de monedas usando el API ExchangeRape para realizar las solicitudes de las tasas de cambio.
 Al finalizar su uso genera un archivo .json con el historial de las conversiones realizadas.
  
## Estado del proyecto:
  🚧 En desarrollo 🚧
  
## Caracteristicas y funciones

A continuacion se muestra el menu del conversor de monedas, el cual muestra varias opciones:
![Menu conversor](https://github.com/keatnis/currency-coverter/assets/95552515/fd71e44e-99c2-422f-96b9-b944421b9013)

La primera opcion del menu permite realizar conversiones de monedas predefinidas, al pulsar 1 del menu se muestra  un submenu en el cual se puede elegir  el tipo de monedas se va realizar la conversion     y el monto que se quiere convertir.
![Submenu](https://github.com/keatnis/currency-coverter/assets/95552515/d71597bf-2891-42a0-8d37-2e97243a871e)

`Soporte para mas monedas : ` Permite a los usuarios a convertir entre una gran variedad de opciones monetarias. Solo se debe de conocer el codigo de las monedas para realizar la conversion.
![image](https://github.com/keatnis/currency-coverter/assets/95552515/186db2a7-60fb-44d3-898d-5ff5269984d6)

`Historial de conversiones:` Muestra el historial de las ultimas conversiones realizadas durante la ejecucion del programa.
![image](https://github.com/keatnis/currency-coverter/assets/95552515/4b0dba34-5184-49ad-aa69-a68c66c9e9be)

`Registros con marcas de tiempo: ` Al realizar las conversiones se guardan la informacion de las monedas y tambien el momento en que se realizo la conversion. Se usó la biblioteca java.time para 						marcar       el tiempo.

Al salir del programa o mostrar el historial se genera un archivo json de las conversiones realizadas.
   ![image](https://github.com/keatnis/currency-coverter/assets/95552515/63bce57b-40af-4ed0-9ad3-ae8519d1855d)
	 

## Tecnologías utilizadas:
Gson
Java

