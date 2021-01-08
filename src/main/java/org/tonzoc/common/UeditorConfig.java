package org.tonzoc.common;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 *
 * @author Administrator
 * {state：”状态”，url：”回显路径”，size：”大小”，type：”类型”，title：”文件title”，original：”名称”}
 */

@EntityScan
public class UeditorConfig {
    private String state;
    private String url;
    private long size;
    private String type;
    private String title;
    private String original;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
