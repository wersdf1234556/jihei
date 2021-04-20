package org.tonzoc.model;

import org.tonzoc.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Table(value = "baida")
public class BaidaModel extends BaseModel {
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "categoryGuid")
    private String categoryGuid;
    @Column(value = "projectName")
    private String projectName;
    @Column(value = "constructionContent")
    private String constructionContent;
    @Column(value = "projectTypeGuid")
    private String projectTypeGuid;
    @Column(value = "planStartTime")
    private String planStartTime;
    @Column(value = "planCompleteTime")
    private String planCompleteTime;
    @Column(value = "totalInvestment")
    private BigDecimal totalInvestment;
    @Column(value = "currentYearPlan")
    private BigDecimal currentYearPlan;
    @Column(value = "complete3")
    private BigDecimal complete3;
    @Column(value = "complete4")
    private BigDecimal complete4;
    @Column(value = "complete5")
    private BigDecimal complete5;
    @Column(value = "complete6")
    private BigDecimal complete6;
    @Column(value = "complete7")
    private BigDecimal complete7;
    @Column(value = "complete8")
    private BigDecimal complete8;
    @Column(value = "complete9")
    private BigDecimal complete9;
    @Column(value = "complete10")
    private BigDecimal complete10;
    @Column(value = "complete11")
    private BigDecimal complete11;
    @Column(value = "complete12")
    private BigDecimal complete12;
    @Column(value = "currentYearComplete")
    private BigDecimal currentYearComplete;
    @Column(value = "totalCompleteInvestment")
    private BigDecimal totalCompleteInvestment;
    @Column(value = "projectProgress")
    private String projectProgress;
    @Column(value = "question")
    private String question;
    @Column(value = "address")
    private String address;
    @Column(value = "userGuid")
    private String userGuid;
    @JoinColumn(value = "name", type = IndustryCategoryModel.class, leftColumn = "categoryGuid", rightColumn = "guid")
    private String categoryName;
    @JoinColumn(value = "name", type = ProjectStateModel.class, leftColumn = "projectTypeGuid", rightColumn = "guid")
    private String projectTypeName;

    public BaidaModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCategoryGuid() {
        return categoryGuid;
    }

    public void setCategoryGuid(String categoryGuid) {
        this.categoryGuid = categoryGuid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getConstructionContent() {
        return constructionContent;
    }

    public void setConstructionContent(String constructionContent) {
        this.constructionContent = constructionContent;
    }

    public String getProjectTypeGuid() {
        return projectTypeGuid;
    }

    public void setProjectTypeGuid(String projectTypeGuid) {
        this.projectTypeGuid = projectTypeGuid;
    }

    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    public String getPlanCompleteTime() {
        return planCompleteTime;
    }

    public void setPlanCompleteTime(String planCompleteTime) {
        this.planCompleteTime = planCompleteTime;
    }

    public BigDecimal getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(BigDecimal totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public BigDecimal getCurrentYearPlan() {
        return currentYearPlan;
    }

    public void setCurrentYearPlan(BigDecimal currentYearPlan) {
        this.currentYearPlan = currentYearPlan;
    }

    public BigDecimal getComplete3() {
        return complete3;
    }

    public void setComplete3(BigDecimal complete3) {
        this.complete3 = complete3;
    }

    public BigDecimal getComplete4() {
        return complete4;
    }

    public void setComplete4(BigDecimal complete4) {
        this.complete4 = complete4;
    }

    public BigDecimal getComplete5() {
        return complete5;
    }

    public void setComplete5(BigDecimal complete5) {
        this.complete5 = complete5;
    }

    public BigDecimal getComplete6() {
        return complete6;
    }

    public void setComplete6(BigDecimal complete6) {
        this.complete6 = complete6;
    }

    public BigDecimal getComplete7() {
        return complete7;
    }

    public void setComplete7(BigDecimal complete7) {
        this.complete7 = complete7;
    }

    public BigDecimal getComplete8() {
        return complete8;
    }

    public void setComplete8(BigDecimal complete8) {
        this.complete8 = complete8;
    }

    public BigDecimal getComplete9() {
        return complete9;
    }

    public void setComplete9(BigDecimal complete9) {
        this.complete9 = complete9;
    }

    public BigDecimal getComplete10() {
        return complete10;
    }

    public void setComplete10(BigDecimal complete10) {
        this.complete10 = complete10;
    }

    public BigDecimal getComplete11() {
        return complete11;
    }

    public void setComplete11(BigDecimal complete11) {
        this.complete11 = complete11;
    }

    public BigDecimal getComplete12() {
        return complete12;
    }

    public void setComplete12(BigDecimal complete12) {
        this.complete12 = complete12;
    }

    public BigDecimal getCurrentYearComplete() {
        return currentYearComplete;
    }

    public void setCurrentYearComplete(BigDecimal currentYearComplete) {
        this.currentYearComplete = currentYearComplete;
    }

    public BigDecimal getTotalCompleteInvestment() {
        return totalCompleteInvestment;
    }

    public void setTotalCompleteInvestment(BigDecimal totalCompleteInvestment) {
        this.totalCompleteInvestment = totalCompleteInvestment;
    }

    public String getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(String projectProgress) {
        this.projectProgress = projectProgress;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    @Override
    public String toString() {
        return "BaidaModel{" +
                "guid='" + guid + '\'' +
                ", categoryGuid='" + categoryGuid + '\'' +
                ", projectName='" + projectName + '\'' +
                ", constructionContent='" + constructionContent + '\'' +
                ", projectTypeGuid='" + projectTypeGuid + '\'' +
                ", planStartTime='" + planStartTime + '\'' +
                ", planCompleteTime='" + planCompleteTime + '\'' +
                ", totalInvestment=" + totalInvestment +
                ", currentYearPlan=" + currentYearPlan +
                ", complete3=" + complete3 +
                ", complete4=" + complete4 +
                ", complete5=" + complete5 +
                ", complete6=" + complete6 +
                ", complete7=" + complete7 +
                ", complete8=" + complete8 +
                ", complete9=" + complete9 +
                ", complete10=" + complete10 +
                ", complete11=" + complete11 +
                ", complete12=" + complete12 +
                ", currentYearComplete=" + currentYearComplete +
                ", totalCompleteInvestment=" + totalCompleteInvestment +
                ", projectProgress='" + projectProgress + '\'' +
                ", question='" + question + '\'' +
                ", address='" + address + '\'' +
                ", userGuid='" + userGuid + '\'' +
                '}';
    }
}
