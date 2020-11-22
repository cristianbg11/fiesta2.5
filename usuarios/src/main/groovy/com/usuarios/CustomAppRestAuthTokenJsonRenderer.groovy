package com.usuarios

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.rest.token.AccessToken
import grails.plugin.springsecurity.rest.token.rendering.AccessTokenJsonRenderer
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority

@Transactional
class CustomAppRestAuthTokenJsonRenderer implements AccessTokenJsonRenderer  {

    @Override
    String generateJson(AccessToken accessToken){

        User user = User.get accessToken.principal.id as Long
        // Add extra custom parameters if you want in this map to be rendered in login response
        Map response = [
                id           : user.id,
                email        : user.email,
                usuario     : user.username,
                nombre       : user.nombre,
                access_token : accessToken.accessToken,
                //token_type   : "Bearer",
                //refresh_token: accessToken.refreshToken,
                rol        : accessToken.authorities.first().authority
        ]

        return new JsonBuilder( response ).toPrettyString()
    }
}
