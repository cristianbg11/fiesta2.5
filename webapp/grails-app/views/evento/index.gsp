<%--
  Created by IntelliJ IDEA.
  User: Crist
  Date: 8/25/2020
  Time: 2:36 PM
--%>

<main class="page service-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Eventos</h2>
                <p>
                    Te ofrecemos los mejores servicios para Eventos. Solicita tu servicio aqui
                </p>
            </div>
            <div class="row">
                <g:each in="${eventos}" var="evento">
                <div class="col-md-6 col-lg-4">
                    <div class="card"><img class="card-img-top w-100 d-block" src="${evento.imagen}">
                        <div class="card-body">
                            <h4 class="card-title">${evento.nombre}</h4>
                            <p class="card-text">
                                Costo de Servicio $RD ${evento.costo}
                            </p>
                        </div>
                        <div><a href="/evento/checkout/${evento.id}" class="btn btn-outline-primary btn-sm" type="button">Comprar Servicio</a></div>
                    </div>
                </div>
                </g:each>


            </div>
        </div>
    </section>
</main>