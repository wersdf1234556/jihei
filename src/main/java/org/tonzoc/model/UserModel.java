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
    @Column(value = "departmentName")
    private String departmentName;
    @Column(value = "projectId")
    private String projectId;
    @Column(value = "mobile")
    private String mobile;
    @Column(value = "outSideColor")
    private String outSideColor;
    @Column(value = "inSideColor")
    private String inSideColor;
    @Column(value = "backgroundImg")
    private String backgroundImg;
    @Column(value = "tenderId")
    private String tenderId;

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOutSideColor() {
        return outSideColor;
    }

    public void setOutSideColor(String outSideColor) {
        this.outSideColor = outSideColor;
    }

    public String getInSideColor() {
        return inSideColor;
    }

    public void setInSideColor(String inSideColor) {
        this.inSideColor = inSideColor;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public String getTenderId() {
        return tenderId;
    }

    public void setTenderId(String tenderId) {
        this.tenderId = tenderId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", staffName='" + staffName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", projectId='" + projectId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", outSideColor='" + outSideColor + '\'' +
                ", inSideColor='" + inSideColor + '\'' +
                ", backgroundImg='" + backgroundImg + '\'' +
                ", roleModels=" + roleModels +
                '}';
    }
}
