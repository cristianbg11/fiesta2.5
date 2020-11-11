<%--
  Created by IntelliJ IDEA.
  User: Crist
  Date: 8/25/2020
  Time: 3:35 PM
--%>

<main class="page shopping-cart-page">
    <section class="clean-block clean-cart dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Lista de Pedidos</h2>
  </div>
            <div class="content">
                <div class="row no-gutters">
                    <div class="col-md-12 col-lg-8">
                        <div class="items">
                            <div class="product">
                                <div class="row justify-content-center align-items-center">
                                    <div class="col-md-3">
                                        <div class="product-image"><img class="img-fluid d-block mx-auto image" src="assets/img/tech/image2.jpg"></div>
                                    </div>
                                    <div class="col-md-5 product-info"><a class="product-name" href="#">${evento.nombre}</a>

                                    </div>

                                    <div class="col-6 col-md-2 price"><span>$${evento.costo}</span></div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-12 col-lg-4">
                        <div class="summary">
                            <h3>Summary</h3>
                            <h4><span class="text">Subtotal</span><span class="price">$${evento.costo}</span></h4>
                            <h4><span class="text">Discount</span><span class="price">$0</span></h4>
                            <h4><span class="text">Shipping</span><span class="price">$0</span></h4>
                            <h4><span class="text">Total</span><span class="price">$${evento.costo}</span></h4>
                            <a href="/servicios/payment/${evento.id}" class="btn btn-primary btn-block btn-lg">Checkout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>