package evento

class Pedido {

    Date fecha
    double monto
    Evento evento
    String estado
    //TO DO
    //static belongsTo = [usuario:User]
    static hasMany = [asignaciones:Asignacion]
    static constraints = {
        estado inList: ["Pendiente","Finalizado"]
    }
    
}
