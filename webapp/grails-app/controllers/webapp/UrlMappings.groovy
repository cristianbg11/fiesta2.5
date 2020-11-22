package webapp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "evento", action: "index")
        "/login"(controller: "login", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
