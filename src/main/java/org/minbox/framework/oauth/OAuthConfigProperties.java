package org.minbox.framework.oauth;

import lombok.Data;

/**
 * OAuth2相关的配置属性定义
 *
 * @author 恒宇少年
 */
@Data
public class OAuthConfigProperties {
    /**
     * The refresh token validity seconds，Expires within 30 days
     */
    private int refreshTokenValiditySeconds = 2592000;
    /**
     * The access token validity seconds，Expires within 2 hours
     */
    private int accessTokenValiditySeconds = 7200;
    /**
     * Configuration support refresh token
     */
    private boolean supportRefreshToken = true;
    /**
     * Configure to reuse refresh token
     */
    private boolean reuseRefreshToken = true;
    /**
     * Whether to consistently create a new token every time the "/oauth/token" interface is called
     */
    private boolean alwaysCreateToken = false;
}
