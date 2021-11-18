# DOCUMENTACION EN SWAGGER
Revisar documentación de Swagger
http://{host}:{port}/swagger-ui.html

Ejemplo:
http://localhost:8080/swagger-ui.html

# PROCESO PARA DETENER SERVICIOS
Entrar al home del usuario "ubuntu"
cd /home/ubuntu/

Buscar el proceso "java"
ps -e|grep java

Con el Id de proceso
kill -9 ${procesoId}


# PROCESO PARA SUBIR SERVICIOS
Entrar al home del usuario "ubuntu"
cd /home/ubuntu/

Ejecutar el comando
nohup java -jar mlc-api-services-1.0.0.jar &

nohup: para generar el log local
java -jar: para ejecutar el jar del servicio
&: para la ejecución en segundo plano

Eliminar el 

# PROCESO PARA SUBIR NUEVA VERSION DE SERVICIOS
Detener servicio ver proceso PROCESO PARA DETENER SERVICIOS

Respaldar el jar del servicio actual por si se requiere volver a restaurar
En el home de ubuntu, existe el directorio "backup"
Mover el jar actual dentro del directorio backup y renombrarlo con el siguiente formato
filejar.jar_back_aaaammdd_hhmm

Ejemplo:
mlc-api-services-1.0.0.jar_back_20210830_1300

Subir la nueva versión del jar dentro del home de ubuntu "/home/ubuntu/"

Asignar permisos de ejecución
chmod +x mlc-api-services-1.0.0.jar

Ejecutar el proceso PROCESO PARA SUBIR SERVICIOS

# PROCESO PARA LEVANTAR SERVICIOS DE BASE DE DATOS

Iniciar MYSQL: /etc/init.d/mysql start.
Reiniciar MYSQL: /etc/init.d/mysql restart.
Parar MYSQL: /etc/init.d/mysql stop. 


# PROCESO PARA LEVANTAR EL SERVICO DE NO-IP

Iniciar
/usr/local/bin/noip2
