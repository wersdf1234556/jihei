package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Table(value = "users")
public class UserModel extends BaseModel {

    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @NotEmpty
    @Column(value = "name")
    private String name;
    @Column(value = "password")
    private String password;
    @Column(value = "staffName")
    private String staffName;
    @Column(value = "mobile")
    private String mobile;

    private List<RoleModel> roleModels;

    public UserModel() {
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

    public String getPassword() {
        return password;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleModel> getRoleModels() {
        return roleModels;
    }

    public void setRoleModels(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
