grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain
        [
                pattern: '/**',
                filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ],

        //Traditional, stateful chain
        [
                pattern: '/stateful/**',
                filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
        ]
]

grails {
        mail {
                host = "smtp.gmail.com"
                port = 465
                username = "medusascompany@gmail.com"
                password = "cristianfa"
                props = [
                        "mail.smtp.auth": "true",
                        "mail.smtp.socketFactory.port": "465",
                        "mail.smtp.socketFactory.class": "javax.net.ssl.SSLSocketFactory",
                        "mail.smtp.socketFactory.fallback": "false",
                ]
        }
}
//jasper.dir.reports='./webapp/reports'
