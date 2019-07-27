package me.zhengjie.security;

import org.springframework.security.test.context.support.WithMockUser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//todo org.springframework.security.access.AccessDeniedException: Access is denied
@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "admin", password = "123456",roles = "ADMIN")
public @interface WithMockAdmin {
}
