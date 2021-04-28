package org.minbox.framework.oauth.response;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;

/**
 * Request response definition for request token error
 *
 * @author 恒宇少年
 */
public interface AccessTokenInvalidResponse {
    /**
     * Provide the response HttpStatus, default is 401
     *
     * @return {@link HttpStatus}
     */
    default HttpStatus getHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

    /**
     * Serialize the response content
     *
     * @param e       The {@link AuthenticationException} instance
     * @param request The http request instance
     */
    String serializeResponse(HttpServletRequest request, AuthenticationException e);
}
