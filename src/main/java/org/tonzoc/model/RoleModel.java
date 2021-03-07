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
    @Column(value = "sign")
    private Integer sign;//身份标识0：标段 1：监理/指挥部 2：管理员

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

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
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
