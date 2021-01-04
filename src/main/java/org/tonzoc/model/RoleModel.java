package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import java.util.List;

@Table(value = "roles")
public class RoleModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "flag")
    private Integer flag;

    private List<AuthorityModel> authorityModels;

    public RoleModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorityModel> getAuthorityModels() {
        return authorityModels;
    }

    public void setAuthorityModels(List<AuthorityModel> authorityModels) {
        this.authorityModels = authorityModels;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", authorityModels=" + authorityModels +
                '}';
    }
}
