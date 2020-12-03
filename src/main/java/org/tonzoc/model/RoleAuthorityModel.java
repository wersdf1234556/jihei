package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "roleAuthorities")
public class RoleAuthorityModel extends BaseModel {

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "roleGuid")
    private String roleGuid;
    @Column(value = "authorityGuid")
    private String authorityGuid;

    public RoleAuthorityModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getRoleGuid() {
        return roleGuid;
    }

    public void setRoleGuid(String roleGuid) {
        this.roleGuid = roleGuid;
    }

    public String getAuthorityGuid() {
        return authorityGuid;
    }

    public void setAuthorityGuid(String authorityGuid) {
        this.authorityGuid = authorityGuid;
    }
}
