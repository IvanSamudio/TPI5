# TPI5

##Lista de curl´s para testeo de la API REST en Heroku

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
