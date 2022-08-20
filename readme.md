API Rest utilizando Spring Boot (Java), Maven y MySQL - Facundo Guerrero

Version de Java - 11
Version de Sprig-Boot - 2.7.3
Version de Maven -  3.8.6
Editor utilizado - VSCode

Para la correcta ejecucion de este programa se debe crear un DataBase Schema en MySQL con el nombre 'api'

No se deben crear tablas. Se crearan automaticamente con la primer ejecucion del codigo.

Para la creacion de 3 registros en la BDD, luego de correr la primer vez el codigo y verificar que las tablas se crearon, se debe cambiar el valor de 'spring.sql.init.mode' en el archivo application.properties de never a always. Correr nuevamente el codigo.

Luego de que estos registros se hayan creado, se debe volver la propiedad a never, ya que sino intentara generar nuevamente los registros y generara conflicto con los registros anteriores.

Para la ejecucion del codigo, debemos ir a la clase R1GuerreroApplication y apretar en el boton de Run Java.
Para la detencion de ejecucion como alternativa puede usar la combinacion de teclas CTRL + C en la terminal.
