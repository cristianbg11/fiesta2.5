package webapp

class Asignacion {

    String estado
    //static hasOne = [pedido:Pedido,usuario:User]
    Pedido pedido
    User usuario
    static constraints = {
    }
}
