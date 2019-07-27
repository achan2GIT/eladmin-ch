package me.zhengjie.security;

import org.springframework.security.test.context.support.WithUserDetails;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithUserDetails(value = "admin", userDetailsServiceBeanName = "jwtUserDetailsService")//启动时依懒redis-server
public @interface WithMockAdminUserDetails {
}
