package evento

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action: "delete")
        get "/$controller(.$format)?"(action: "index")
        get "/$controller/$id(.$format)?"(action: "show")
        post "/$controller(.$format)?"(action: "save")
        put "/$controller/$id(.$format)?"(action: "update")
        patch "/$controller/$id(.$format)?"(action: "patch")

        "/"(controller: 'application', action: 'index')
        "/evento/mispedidos/$id"(controller: 'servicio', action: 'mispedidos', method: 'GET')
        "/evento/checkout/$id"(controller: 'servicio', action: 'checkout', method: 'GET')
        "/evento/payment"(controller: 'servicio', action: 'payment', method: 'POST')
        "/evento/crearfactura"(controller: 'servicio', action: 'crearfactura', method: 'POST')
        "/evento/pedidosempleado"(controller: 'servicio', action: 'pedidosempleado', method: 'GET')
        "/evento/asignar"(controller: 'servicio', action: 'asignar', method: 'POST')
        "/evento/crearfactura"(controller: 'servicio', action: 'crearfactura', method: 'POST')
        "/evento/estadistica/"(controller: 'servicio', action: 'pedidoshoy', method: 'GET')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
