<main class="page payment-page">
    <section class="clean-block payment-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Payment</h2>
            </div>
            <form>
                <div class="products">
                    <h3 class="title">Checkout</h3>
                    <div class="item"><span class="price">$${pedido.evento.costo}</span>
                        <p class="item-name">${pedido.evento.nombre}</p>
                    </div>
                    <div class="total"><span>Total</span><span class="price">$${pedido.evento.costo}</span></div>
                </div>

                <div class="card-details">
                    <h3 class="title">Metodos de pago</h3>
                    <div id="paypal-button-container"></div>
                    <script src="https://www.paypal.com/sdk/js?client-id=AQmvu7t853Nb1PzRERgULVvsc55QKIPwxaq6uusjMeVOM7hBWS6lMGDlWj9G8KjmerrF_MysBwEL4ieZ&currency=USD" data-sdk-integration-source="button-factory"></script>
                    <script>
                        paypal.Buttons({
                            style: {
                                shape: 'rect',
                                color: 'gold',
                                layout: 'vertical',
                                label: 'paypal',

                            },
                            createOrder: function(data, actions) {
                                return actions.order.create({
                                    purchase_units: [{
                                        amount: {
                                            value: '${pedido.evento.costo}'
                                        }
                                    }]
                                });
                            },
                            onApprove: function(data, actions) {
                                var URL = "${createLink(controller:'evento',action:'paypal')}";
                                $.ajax({
                                    url: URL,
                                    type: "POST",
                                    data: {"id": ${pedido.id}}
                                }).done(function (data) {
                                    console.log(data);
                                });
                                /*return actions.order.capture().then(function(details) {
                                    alert('Transaction completed by ' + details.payer.name.given_name + '!');
                                });*/
                            }
                        }).render('#paypal-button-container');
                    </script>
                </div>
            </form>
        </div>
    </section>
</main>