package org.tonzoc.model;

import org.tonzoc.annotation.*;

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
    @Column(value = "flag")
    private Integer flag;

    @Column(value = "roleGuid")
    private String roleGuid;
    @JoinColumn(value = "name", type = RoleModel.class, leftColumn = "roleGuid", rightColumn = "guid")
    private String roleName;
    @Column(value = "projectGuid")
    private String projectGuid;
    @JoinColumn(value = "name", type = ProjectModel.class, leftColumn = "projectGuid", rightColumn = "guid")
    private String projectName;
    @Column(value = "tenderGuid")
    private String tenderGuid;
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName; //标段
    @Column(value = "accounType")
    private String accounType;  //账户类型
    @Column(value = "tenderManage")
    private String tenderManage;  //管理标段
    @Column(value = "industryCategoryGuid")
    private String industryCategoryGuid;
    @Column(value = "managementPowerGuid")
    private String managementPowerGuid;
    @JoinColumn(value = "name", type = IndustryCategoryModel.class, leftColumn = "industryCategoryGuid", rightColumn = "guid")
    private String industryCategoryName; //标段
    @JoinColumn(value = "name", type = ManagementPowerModel.class, leftColumn = "managementPowerGuid", rightColumn = "guid")
    private String managementPowerName; //标段

    @JoinColumn(value = "mappingTenderGuid", type = LabTenderModel.class, leftColumn = "tenderGuid", rightColumn = "tenderGuid")
    private String sectionId;

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getAccounType() {
        return accounType;
    }

    public void setAccounType(String accounType) {
        this.accounType = accounType;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTenderManage() {
        return tenderManage;
    }

    public void setTenderManage(String tenderManage) {
        this.tenderManage = tenderManage;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", staffName='" + staffName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", flag=" + flag +
                ", roleGuid='" + roleGuid + '\'' +
                ", roleName='" + roleName + '\'' +
                ", projectGuid='" + projectGuid + '\'' +
                ", projectName='" + projectName + '\'' +
                ", tenderGuid='" + tenderGuid + '\'' +
                ", tenderName='" + tenderName + '\'' +
                ", accounType='" + accounType + '\'' +
                ", tenderManage='" + tenderManage + '\'' +
                ", industryCategoryGuid='" + industryCategoryGuid + '\'' +
                ", managementPowerGuid='" + managementPowerGuid + '\'' +
                ", industryCategoryName='" + industryCategoryName + '\'' +
                ", managementPowerName='" + managementPowerName + '\'' +
                '}';
    }

    public String getIndustryCategoryGuid() {
        return industryCategoryGuid;
    }

    public void setIndustryCategoryGuid(String industryCategoryGuid) {
        this.industryCategoryGuid = industryCategoryGuid;
    }

    public String getManagementPowerGuid() {
        return managementPowerGuid;
    }

    public void setManagementPowerGuid(String managementPowerGuid) {
        this.managementPowerGuid = managementPowerGuid;
    }

    public String getIndustryCategoryName() {
        return industryCategoryName;
    }

    public void setIndustryCategoryName(String industryCategoryName) {
        this.industryCategoryName = industryCategoryName;
    }

    public String getManagementPowerName() {
        return managementPowerName;
    }

    public void setManagementPowerName(String managementPowerName) {
        this.managementPowerName = managementPowerName;
    }
}
