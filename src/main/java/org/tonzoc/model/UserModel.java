package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.JoinColumn;
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

    @Column(value = "roleGuid")
    private String roleGuid;
    @JoinColumn(value = "name", type = RoleModel.class, leftColumn = "roleGuid", rightColumn = "guid")
    private String roleName;
    @Column(value = "projectGuid")
    private String projectGuid;
    @JoinColumn(value = "name", type = ProjectModel.class, leftColumn = "projectGuid", rightColumn = "guid")
    private String projectName;

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


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRoleGuid() {
        return roleGuid;
    }

    public void setRoleGuid(String roleGuid) {
        this.roleGuid = roleGuid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
