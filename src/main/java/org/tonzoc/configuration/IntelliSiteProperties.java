package org.tonzoc.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IntelliSiteProperties.class)
@ConfigurationProperties(prefix = "intellisite")
public class IntelliSiteProperties {

    private String clientId = "intellisite";

    private String clientSecret = "20531901";

    private String loginProcessingUrl = "/auth/login";

    private Boolean permitAll;

    private String defaultUserPassword = "123456";

    private String filePath = "D:/intellisite/jihei/upload";
    // private String filePath = "D:/tool/file/jihei";

    private String ip = "123.57.220.90:";

    private String fileUrl = "/";

    public IntelliSiteProperties() {
    }

    public Boolean getPermitAll() {
        return permitAll;
    }

    public void setPermitAll(Boolean permitAll) {
        this.permitAll = permitAll;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getLoginProcessingUrl() {
        return loginProcessingUrl;
    }

    public void setLoginProcessingUrl(String loginProcessingUrl) {
        this.loginProcessingUrl = loginProcessingUrl;
    }

    public String getDefaultUserPassword() {
        return defaultUserPassword;
    }

    public void setDefaultUserPassword(String defaultUserPassword) {
        this.defaultUserPassword = defaultUserPassword;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
