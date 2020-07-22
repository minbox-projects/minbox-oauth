package org.minbox.framework.oauth.response;

import com.fasterxml.jackson.core.JsonGenerator;
import org.minbox.framework.oauth.exception.OAuth2Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.HtmlUtils;

/**
 * The default {@link AuthorizationDeniedResponse} support
 * Provide default OAuth2Exception exception response content
 *
 * @author 恒宇少年
 * @see org.minbox.framework.oauth.translator.WebResponseExceptionTranslator
 * @see org.minbox.framework.oauth.exception.OAuth2Exception
 */
public class DefaultAuthorizationDeniedResponse implements AuthorizationDeniedResponse {
    @Override
    public void serializeResponse(OAuth2Exception e, JsonGenerator generator) {
        try {
            String message = e.getMessage();
            if (message != null) {
                message = HtmlUtils.htmlEscape(message);
            }
            generator.writeObjectField("errorMessage", message);
            generator.writeObjectField("errorCode", HttpStatus.UNAUTHORIZED.getReasonPhrase());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
