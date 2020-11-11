package webapp

class User {
    String username
    String password
    String nombre
    String email
    String rol

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany = [pedidos: Pedido, asignaciones:Asignacion]
}
