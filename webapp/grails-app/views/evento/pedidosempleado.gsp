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
                <h2 class="text-info">Pedidos pendientes</h2>
            </div>
            <div class="content">
                <div class="row">
                    <div class="col">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Estado</th>
                                    <th>Fecha</th>
                                    <th>Monto</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <g:each in="${pedidosempleado}" var="pedido">
                                    <tr>
                                        <td>${pedido.evento.nombre}</td>
                                        <td>${pedido.estado}</td>
                                        <td>${pedido.fecha}</td>
                                        <td>${pedido.monto}</td>
                                        <td style="width: 174px;">
                                            <button <g:if test="${pedido.estado == "Finalizado"}">disabled</g:if> class="btn btn-primary btn-sm text-capitalize text-center border rounded" type="button"><a  href=<g:if test="${pedido.estado != "Finalizado"}">"/evento/asignar/${pedido.id+"f"+pedido.iduser}"</g:if><g:else>"#"</g:else> style="color: white">Tomar pedido</a></button>
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