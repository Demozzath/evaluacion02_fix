
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Competidores</title>
    </head>
    <body>
        <h1>Agregar competidor</h1>
        <form name="form" action="competidoresController" method="get">
        RUT
        <input name="rut" id="rut" > <br>
        Nombre:
        <input name="nombre" id="nombre" ><br>
        Apellido:
        <input name="apellido" id="apellido" ><br>
        Edad:
        <input name="edad" id="edad"><br>
        Genero: <br>
        <input type="radio" name="genero" id="si" value="hombre">
        <label for="si">Hombre</label> <br>
        <input type="radio" name="genero" id="no" value="mujer ">
        <label for="si">Mujer</label> <br>
        Peso:
        <input name="peso" id="peso" >KG<br>
        <button type="submit" name="registrar" value="registrar">Registrar Competidor</button>
            
            
        </form>
    </body>
</html>
