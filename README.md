# TPI5

### Link de Swagger UI

https://tpi5.onrender.com/swagger-ui/index.html#/

### Lista de curl´s para testeo de la API REST en Render

Estos curl´s deben ser importados en postman para su testeo.



Get estudiantes
- curl --location --request GET 'https://tpi5.onrender.com/swagger-ui/index.html#/Estudiantes/'


Post estudiante
- curl --location --request POST 'https://tpi5.onrender.com/swagger-ui/index.html#/Estudiantes/' \
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
- curl --location --request POST 'https://tpi5.onrender.com/swagger-ui/index.html#/Carreras/' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "idCarrera":3,
      "nombre":"Profesorado de Informática"
  }'
  
  
Matricular estudiante en una carrera
- curl --location --request POST 'https://tpi5.onrender.com/swagger-ui/index.html#/DatosAcademicos/matricularEstudiante/2' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "idCarrera":1,
      "nombre":"Tudai"
  }'
