//package com.mvcdb.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.ldap.core.LdapTemplate;
//import org.springframework.ldap.core.support.LdapContextSource;
//
//@Configuration
//public class LdapConfig {
//
//    @Bean
//    public LdapContextSource contextSource() {
//        LdapContextSource contextSource = new LdapContextSource();
//        contextSource.setUrl("ldap://localhost:8389");
//        contextSource.setBase("dc=springframework,dc=org");
//        contextSource.setUserDn("uid=admin,ou=system");
//        contextSource.setPassword("secret");
//        return contextSource;
//    }
//
//    @Bean
//    public LdapTemplate ldapTemplate() {
//        return new LdapTemplate(contextSource());
//    }
//}
