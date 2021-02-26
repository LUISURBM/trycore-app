# Angular & Spring Trycore Test application [![setup automated](https://img.shields.io/badge/Gitpod-ready_to_code-blue?logo=gitpod)](https://github.com/LUISURBM/)

Selección proceso Try [ready-to-code development environment](https://www.gitpod.io):

<a href="https://gitpod.io/from-referrer/" style="padding: 10px;">
    <img src="https://trycore.co/cms/wp-content/uploads/2018/05/logo-trycore-bpm-colombia.png" width="150" alt="Push" align="center">
</a>

##  Identificar los planetas y personas registrados en la base de datos.
<a href="https://github.com/LUISURBM/trycore-app">GITHUB</a>

<img width="1042" alt="planet-screenshot" src="https://raw.githubusercontent.com/luisurbm/trycore-app/master/ScreenShotV1.png">

● Un planeta puede ser habitado por muchas personas.
● Una persona solamente puede habitar un planeta a la vez.
● Tanto los planetas como las personas, deben contar con un campo “contador”, para conocer la cantidad de visitas de cada registro.

```
./mvnw package -DskipTests
java -jar target/*.jar
or 
./mvnw spring-boot:run
```

```
npm install -g @angular/cli@1.7.4 or npm install --save-dev @angular/cli@latest
ng serve --open
```
