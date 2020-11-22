<%--
  Created by IntelliJ IDEA.
  User: Enmanuel Bueno
  Date: 11/17/2020
  Time: 8:11 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<main class="page contact-us-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">User</h2>
            </div>
            <form action="edit" method="post">
                <div class="form-group"><label>Nombre</label><input class="form-control" type="text" name="nombre" value="${usuario.nombre}"></div>
                <div class="form-group"><label>Usuario</label><input class="form-control" type="text" name="username" value="${usuario.username}"></div>
                <div class="form-group"><label>Email</label><input class="form-control" type="email" name="email" value="${usuario.email}"></div>
                <div class="form-group"><label>Rol</label>
                    <select class="form-control">
                        <option <g:if test="${usuario.rol == "ROLE_ADMIN"}">selected </g:if> value="1">Admin</option>
                        <option <g:if test="${usuario.rol == "ROLE_EMPLEADO"}">selected </g:if> value="2">Empleado</option>
                        <option <g:if test="${usuario.rol == "ROLE_CLIENTE"}">selected </g:if> value="2">Cliente</option>
                    </select></div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Send</button></div>
            </form>
        </div>
    </section>
</main>