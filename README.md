# Instrucciones Ejecución


## Pre requisitos

- Android Studio dolphin
- Kotlin v1.7.20
- Emulador Android (Version minima Android 5 Lollipop)
- Memoria ram 16 GB (Minimo Recomendado)

## Instrucciones de ejecución

* Descargar repositorio de Git

    ```
    https://github.com/org-miso/mobile.git
    ```
    
- Sincronizar gradle desde el amdroid studio
    ![1](https://user-images.githubusercontent.com/3527273/200212909-def42257-58ec-4316-b3e8-fc6db2bff47e.jpg)
    
- Para instalar las librerias ejecutar - Instalar librerias requeridas (ver archivo requirement.txt)  (Cambiar python3 por pyp si usa windows)
    ```
    python3 -m pip install -r requirements.txt

- Ejecutar el componente api_gateway en el puerto 5000
    ```cd api_gateway/
    flask run -p 5000

- Ejecutar el componente administrar_usuarios en el puerto 5001
    ```cd administrar_usuarios/
    flask run -p 5001    

- Ejecutar el componente consultar_usuarios en el puerto 5002
    ```cd consultar_usuarios/
    flask run -p 5002  

- Ejecutar el componente autenticador en puerto 5003
    ```cd autenticador/
    flask run -p 5003

- Crear un request en postman usando la interfaz del gateway:
    Importar la colección de postman  Experimentoseguridad.postman_collection.json que esta en la raiz de esta carpeta
    O importar el proyecto en postman https://www.getpostman.com/collections/8690aeea30a6aae158eb


## Inconvenientes

No se presento algo que presentara problemas para ejecutar el proyecto si se siguen las indicaciones dadas.
