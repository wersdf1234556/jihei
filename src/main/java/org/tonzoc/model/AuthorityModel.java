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
    @Column(value = "parentId")
    private String parentId;
    @Column(value = "name")
    private String name;
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "icon")
    private String icon;
    @Column(value = "isDefault")
    private Integer isDefault;
    @Column(value = "flag")
    private Integer flag;

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


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "AuthorityModel{" +
                "guid='" + guid + '\'' +
                ", targetUrl='" + targetUrl + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", icon='" + icon + '\'' +
                ", isDefault='" + isDefault + '\'' +
                ", children=" + children +
                '}';
    }
}
