package org.minbox.framework.oauth.entrypoint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.minbox.framework.oauth.response.AccessTokenInvalidResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthenticationEntryPoint's invalid token implementation
 *
 * @author 恒宇少年
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccessTokenInvalidAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final String JSON_RESPONSE_CONTENT_TYPE = "application/json;charset=UTF-8";
    private AccessTokenInvalidResponse tokenInvalidResponse;

    public AccessTokenInvalidAuthenticationEntryPoint(AccessTokenInvalidResponse tokenInvalidResponse) {
        this.tokenInvalidResponse = tokenInvalidResponse;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(tokenInvalidResponse.getHttpStatus().value());
        response.setContentType(JSON_RESPONSE_CONTENT_TYPE);
        String responseContent = tokenInvalidResponse.serializeResponse(request, e);
        response.getWriter().write(responseContent);
    }
}
