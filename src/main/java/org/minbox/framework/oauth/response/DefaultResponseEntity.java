package org.minbox.framework.oauth.response;

import lombok.Data;

/**
 * The default response entity
 *
 * @author 恒宇少年
 */
@Data
public class DefaultResponseEntity {
    /**
     * error code
     */
    private String errorCode;
    /**
     * error message
     */
    private String errorMessage;
}
