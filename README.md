# Aplikasi Simple Note Backend #

Prasyarat :
- Java SDK 11
- Maven

## Cara Menjalankan Aplikasi ##

1. Jalankan aplikasi dengan perintah berikut di Terminal/Git-Bash

    ```
    mvn clean spring-boot:run
    ```
2.  Cek Endpoint

    ```
    curl http://localhost:8000/api/notes
    ```

[![postman 1](img/createNote.png)](img/createNote.png)
[![postman 2](img/getAllNote.png)](img/getAllNote.png)
[![postman 2](img/deleteNote.png)](img/deleteNote.png)