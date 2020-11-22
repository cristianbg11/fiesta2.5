<%--
  Created by IntelliJ IDEA.
  User: Enmanuel Bueno
  Date: 11/17/2020
  Time: 4:26 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<main class="page catalog-page">
    <section class="clean-block clean-catalog dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Usuarios</h2>
            </div>
            <div class="content">
                <div class="row">
                    <div class="col">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Nombe</th>
                                    <th>Email</th>
                                    <th>User</th>
                                    <th>Rol</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                            <g:each in="${usuarios}" var="usuario">
                                <tr>
                                    <td>${usuario.nombre}</td>
                                    <td>${usuario.email}</td>
                                    <td>${usuario.username}</td>
                                    <td>${usuario.rol}</td>
                                    <td style="width: 174px;">
                                        <button class="btn btn-primary btn-sm text-capitalize text-center border rounded" type="button"><a href="/usuario/editar/${usuario.id}" style="color: white">Editar</a></button>
                                        <button class="btn btn-danger btn-sm text-capitalize text-center border rounded" type="button">Eliminar</button>
                                    </td>
                                </tr>
                            </g:each>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>