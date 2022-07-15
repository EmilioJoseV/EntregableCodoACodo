# Practica final aplicacion Web con Java

#### Requerimientos para desplegar en local:

1.Java JDK 14 

2.Maven 3.3.3 

3.Apache TomCat 10.0.22 (Configurado correctamente)

#### Pasos a seguir para desplegar localmente:
1. Ejecutar en ruta de proyecto: mvn clean install
2. Verificar que se realizar un build successfully
3. Levantar servidor TomCat 10.0.22 atraves de comando: startup.bat (Estar situado en carpeta /bin del tomcat)
4. Escribir en raiz del proyecto comando: mvn tomcat:7redeploy
   (Se realizara un despliegue automatico en el servidor TomCat)
5. Si todo se realiza correctamente ingresar a: http://localhost:7080/AplicacionWeb/
6. Se debe mostrarla la aplicacion Web. 

