package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import java.io.Serializable;
import java.util.List;

@Table(value = "authorities")
public class AuthorityModel extends BaseModel implements Serializable {

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "targetUrl")
    private String targetUrl;
    @Column(value = "method")
    private String method;
    @Column(value = "type")
    private String type;
    @Column(value = "parentId")
    private String parentId;
    @Column(value = "visible")
    private Integer visible;
    @Column(value = "name")
    private String name;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "iconClass")
    private String iconClass;
    @Column(value = "isDefault")
    private Integer isDefault;

    private List<AuthorityModel> children;

    public AuthorityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public List<AuthorityModel> getChildren() {
        return children;
    }

    public void setChildren(List<AuthorityModel> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "AuthorityModel{" +
                "guid='" + guid + '\'' +
                ", targetUrl='" + targetUrl + '\'' +
                ", method='" + method + '\'' +
                ", type='" + type + '\'' +
                ", parentId='" + parentId + '\'' +
                ", visible=" + visible +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", iconClass='" + iconClass + '\'' +
                ", isDefault='" + isDefault + '\'' +
                ", children=" + children +
                '}';
    }
}
