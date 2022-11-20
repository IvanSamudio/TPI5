# TPI5

### Link de Swagger UI

https://tpi5-mvctp5.herokuapp.com/swagger-ui/index.html#/

### Lista de curl´s para testeo de la API REST en Heroku

Estos curl´s deben ser importados en postman para su testeo.



Get estudiantes
- curl --location --request GET 'https://tpi5-mvctp5.herokuapp.com/Estudiantes/'


Post estudiante
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


Post carrera
- curl --location --request POST 'https://tpi5-mvctp5.herokuapp.com/Carreras/' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "idCarrera":3,
      "nombre":"Profesorado de Informática"
  }'
  
  
Matricular estudiante en una carrera
- curl --location --request POST 'https://tpi5-mvctp5.herokuapp.com/DatosAcademicos/matricularEstudiante/2' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "idCarrera":1,
      "nombre":"Tudai"
  }'
