package org.minbox.framework.oauth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.minbox.framework.oauth.response.AuthorizationDeniedResponse;

/**
 * Custom implementation of OAuth2Exception
 *
 * @author 恒宇少年
 * @see org.springframework.security.oauth2.common.exceptions.OAuth2Exception
 */
@JsonSerialize(using = OAuth2ExceptionSerializer.class)
@Getter
public class OAuth2Exception extends org.springframework.security.oauth2.common.exceptions.OAuth2Exception {

    private AuthorizationDeniedResponse response;

    public OAuth2Exception(String message, Throwable t, AuthorizationDeniedResponse response) {
        super(message, t);
        this.response = response;
    }
}
