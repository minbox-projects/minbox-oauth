package org.minbox.framework.oauth.response;

import org.minbox.framework.oauth.exception.OAuth2Exception;
import org.minbox.framework.oauth.translator.DefaultWebResponseExceptionTranslator;
import org.minbox.framework.util.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * The default {@link AccessTokenInvalidResponse} support
 * Provide default OAuth2Exception exception response content
 *
 * @author 恒宇少年
 * @see DefaultWebResponseExceptionTranslator
 * @see OAuth2Exception
 */
public class DefaultAccessTokenInvalidResponse implements AccessTokenInvalidResponse {
    @Override
    public String serializeResponse(HttpServletRequest request, AuthenticationException e) {
        String message = e.getMessage();
        if (message != null) {
            message = HtmlUtils.htmlEscape(message);
        }
        DefaultResponseEntity entity = new DefaultResponseEntity();
        entity.setErrorCode(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        entity.setErrorMessage(message);
        return JsonUtils.toJsonString(entity);
    }
}
