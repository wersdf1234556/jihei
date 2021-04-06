package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.math.BigDecimal;
import java.util.List;

// 项目表
@Table(value = "projects")
public class ProjectModel extends BaseModel {

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 项目名称
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "lng")
    private String lng; // 经度
    @Column(value = "lat")
    private String lat; // 纬度
    @Column(value = "alias")
    private String alias; // 别名
    @Column(value = "value")
    private Integer value; //缩放等级
    @Column(value = "startDate")
    private String startDate; //开工日期
    @Column(value = "completeDate")
    private String completeDate; //交工日期
    @Column(value = "tenderLength")
    private String tenderLength; // 建设规模
    @Column(value = "position")
    private String position; // 地理位置
    @Column(value = "bluePrint")
    private String bluePrint; // 平面图
    @Column(value = "tenderNum")
    private String tenderNum; //标段划分
    @Column(value = "isImportant")
    private Integer isImportant; // 1是 0否 是否是百大项目
    @Column(value = "winningAmount")
    private BigDecimal winningAmount; //批复总投资额
    @Column(value = "completeAmount")
    private BigDecimal completeAmount; // 完成投资额
    @Column(value = "completePercent")
    private BigDecimal completePercent; // 完成比例
    @Column(value = "quantity")
    private String quantity; // 主要工作量
    @Column(value = "constructionProgress")
    private String constructionProgress; // 进度情况
    @Column(value = "industryCategoryGuid")
    private String industryCategoryGuid; // 行业类别
    @Column(value = "managementPowerGuid")
    private String managementPowerGuid; // 管理权属
    @Column(value = "buildLevelGuid")
    private String buildLevelGuid; // 等级
    @Column(value = "projectStateGuid")
    private String projectStateGuid; // 项目状态
    @Column(value = "isStart")
    private String isStart; // 是否开工 1 开工 2 不开工
    @Column(value = "hasMap")
    private Integer hasMap;
    @Column(value = "mapCode")
    private String mapCode;
    @Column(value = "isImportantCount")
    private Integer isImportantCount;
    @Column(value = "currentYearPlanAmount")
    private BigDecimal currentYearPlanAmount;
    @Column(value = "currentYearStatAmount")
    private BigDecimal currentYearStatAmount;

    @JoinColumn(value = "name", type = IndustryCategoryModel.class, leftColumn = "industryCategoryGuid", rightColumn = "guid")
    private String industryCategoryName; //行业类别名称
    @JoinColumn(value = "name", type = ManagementPowerModel.class, leftColumn = "managementPowerGuid", rightColumn = "guid")
    private String managementPowerName; //管理权属名称
    @JoinColumn(value = "name", type = BuildLevelModel.class, leftColumn = "buildLevelGuid", rightColumn = "guid")
    private String buildLevelName; //等级名称
    @JoinColumn(value = "name", type = ProjectStateModel.class, leftColumn = "projectStateGuid", rightColumn = "guid")
    private String projectStateName; //项目状态名称

    public ProjectModel() {
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

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getTenderLength() {
        return tenderLength;
    }

    public void setTenderLength(String tenderLength) {
        this.tenderLength = tenderLength;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBluePrint() {
        return bluePrint;
    }

    public void setBluePrint(String bluePrint) {
        this.bluePrint = bluePrint;
    }

    public String getTenderNum() {
        return tenderNum;
    }

    public void setTenderNum(String tenderNum) {
        this.tenderNum = tenderNum;
    }

    public Integer getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Integer isImportant) {
        this.isImportant = isImportant;
    }

    public BigDecimal getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(BigDecimal winningAmount) {
        this.winningAmount = winningAmount;
    }

    public BigDecimal getCompleteAmount() {
        return completeAmount;
    }

    public void setCompleteAmount(BigDecimal completeAmount) {
        this.completeAmount = completeAmount;
    }

    public BigDecimal getCompletePercent() {
        return completePercent;
    }

    public void setCompletePercent(BigDecimal completePercent) {
        this.completePercent = completePercent;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getConstructionProgress() {
        return constructionProgress;
    }

    public void setConstructionProgress(String constructionProgress) {
        this.constructionProgress = constructionProgress;
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

    public String getBuildLevelGuid() {
        return buildLevelGuid;
    }

    public void setBuildLevelGuid(String buildLevelGuid) {
        this.buildLevelGuid = buildLevelGuid;
    }

    public String getProjectStateGuid() {
        return projectStateGuid;
    }

    public void setProjectStateGuid(String projectStateGuid) {
        this.projectStateGuid = projectStateGuid;
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

    public String getBuildLevelName() {
        return buildLevelName;
    }

    public void setBuildLevelName(String buildLevelName) {
        this.buildLevelName = buildLevelName;
    }

    public String getProjectStateName() {
        return projectStateName;
    }

    public void setProjectStateName(String projectStateName) {
        this.projectStateName = projectStateName;
    }

    public String getIsStart() {
        return isStart;
    }

    public void setIsStart(String isStart) {
        this.isStart = isStart;
    }

    public Integer getIsImportantCount() {
        return isImportantCount;
    }

    public void setIsImportantCount(Integer isImportantCount) {
        this.isImportantCount = isImportantCount;
    }

    public Integer getHasMap() {
        return hasMap;
    }

    public void setHasMap(Integer hasMap) {
        this.hasMap = hasMap;
    }

    public String getMapCode() {
        return mapCode;
    }

    public void setMapCode(String mapCode) {
        this.mapCode = mapCode;
    }

    public BigDecimal getCurrentYearPlanAmount() {
        return currentYearPlanAmount;
    }

    public void setCurrentYearPlanAmount(BigDecimal currentYearPlanAmount) {
        this.currentYearPlanAmount = currentYearPlanAmount;
    }

    public BigDecimal getCurrentYearStatAmount() {
        return currentYearStatAmount;
    }

    public void setCurrentYearStatAmount(BigDecimal currentYearStatAmount) {
        this.currentYearStatAmount = currentYearStatAmount;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", sortId=" + sortId +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", alias='" + alias + '\'' +
                ", value=" + value +
                ", startDate='" + startDate + '\'' +
                ", completeDate='" + completeDate + '\'' +
                ", tenderLength='" + tenderLength + '\'' +
                ", position='" + position + '\'' +
                ", bluePrint='" + bluePrint + '\'' +
                ", tenderNum='" + tenderNum + '\'' +
                ", isImportant=" + isImportant +
                ", winningAmount=" + winningAmount +
                ", completeAmount=" + completeAmount +
                ", completePercent=" + completePercent +
                ", quantity='" + quantity + '\'' +
                ", constructionProgress='" + constructionProgress + '\'' +
                ", industryCategoryGuid='" + industryCategoryGuid + '\'' +
                ", managementPowerGuid='" + managementPowerGuid + '\'' +
                ", buildLevelGuid='" + buildLevelGuid + '\'' +
                ", projectStateGuid='" + projectStateGuid + '\'' +
                ", isStart='" + isStart + '\'' +
                ", hasMap=" + hasMap +
                ", mapCode='" + mapCode + '\'' +
                ", isImportantCount=" + isImportantCount +
                ", currentYearPlanAmount='" + currentYearPlanAmount + '\'' +
                ", currentYearStatAmount='" + currentYearStatAmount + '\'' +
                ", industryCategoryName='" + industryCategoryName + '\'' +
                ", managementPowerName='" + managementPowerName + '\'' +
                ", buildLevelName='" + buildLevelName + '\'' +
                ", projectStateName='" + projectStateName + '\'' +
                '}';
    }
}
