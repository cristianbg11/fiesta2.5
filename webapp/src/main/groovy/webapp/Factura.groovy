package webapp

class Factura {

    double monto
    String estado

    static belongsTo = [pedido: Pedido]

    static constraints = {
    }
}
