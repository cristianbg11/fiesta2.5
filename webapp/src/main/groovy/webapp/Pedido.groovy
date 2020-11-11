package webapp

class Pedido {

    Date fecha
    double monto
    Evento evento
    String estado
    static belongsTo = [usuario:User]
    static hasMany = [asignaciones:Asignacion]
    static constraints = {
        estado inList: ["Pendiente","Finalizado"]
    }
}
