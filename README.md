# TPI5

### Link de Swagger UI

https://tpi5-mvctp5.herokuapp.com/swagger-ui/index.html#/

### Lista de curl´s para testeo de la API REST en Heroku

Get estudiantes(https://tpi5-mvctp5.herokuapp.com/Estudiantes/)
- curl --location --request GET 'https://tpi5-mvctp5.herokuapp.com/Estudiantes/'

Post estudiante(https://tpi5-mvctp5.herokuapp.com/Estudiantes/)
- curl --location --request POST 'https://tpi5-mvctp5.herokuapp.com/Estudiantes/' \
  --header 'Content-Type: application/json' \
  --data-raw '{
          "nroLibreta": 7,
          "nombre": "Roberto",
          "apellido": "Sanchez",
          "edad": 23,
          "genero": "masculino",
          "dni": "53255627",
          "residencia": "Tandil"
      }'
      
Post carrera(https://tpi5-mvctp5.herokuapp.com/Carreras/)
- curl --location --request POST 'https://tpi5-mvctp5.herokuapp.com/Carreras/' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "idCarrera":3,
      "nombre":"Profesorado de Informática"
  }'
