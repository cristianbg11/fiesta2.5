package com.Usuarios

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
@Secured("ROLE_USER")
class BookController extends RestfulController<Book> {

    BookController() {
        super(Book)
    }
}