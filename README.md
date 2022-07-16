# Practica final aplicacion Web con Java

#### Requerimientos para desplegar en local:

1.Java JDK 1.8 (JAVA 8) 

2.Maven 3.3.3 

3.Apache TomCat 10.0.22 (Configurado correctamente)

4.MySQL 5.7.33 Win64

#### Pasos a seguir para desplegar localmente:
1. Ejecutar en ruta de proyecto: mvn clean install
2. Verificar que se realizar un build successfully
3. Levantar servidor TomCat 10.0.22 atraves de comando: startup.bat (Estar situado en carpeta /bin del tomcat)
4. Escribir en raiz del proyecto comando: mvn tomcat7:redeploy
   (Considerar configurar como ejecutor en IDE comando: tomcat7:redeploy)
   (Se realizara un despliegue automatico en el servidor TomCat)
5. Si todo se realiza correctamente ingresar a: http://localhost:7080/app/
6. Se debe mostrarla la aplicacion Web. 
7. Tener corriendo la base de datos MySQL corriendo en: localhost:3306

#### Visualizar paginas una vez levantado el servidor TomCat y desplegado el WAR correctamente:
http://localhost:7080/app

http://localhost:7080/app/signin

http://localhost:7080/app/signup

http://localhost:7080/app/dashboard

