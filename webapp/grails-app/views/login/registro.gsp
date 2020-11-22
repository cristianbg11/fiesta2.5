<%--
  Created by IntelliJ IDEA.
  User: Enmanuel Bueno
  Date: 11/15/2020
  Time: 2:37 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<main class="page registration-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Registro</h2>
            </div>
            <form action="registrar" method="post">
                <div class="form-group"><label for="nombre">Nombre</label><input class="form-control item" type="text" id="nombre" name="nombre"></div>
                <div class="form-group"><label for="usuario">Usuario</label><input class="form-control item" type="text" id="usuario" name="usuario"></div>
                <div class="form-group"><label for="contrasena">Password</label><input class="form-control item" type="password" id="contrasena" name="contrasena"></div>
                <div class="form-group"><label for="email">Email</label><input class="form-control item" type="email" id="email" name="email"></div>
                <g:if test="${flash.error}">
                    <p style="color: red">${flash.error}</p>
                </g:if>
                <button class="btn btn-primary btn-block" type="submit" >Sign Up</button>
            </form>
        </div>
    </section>
</main>