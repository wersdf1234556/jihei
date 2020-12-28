package org.tonzoc.model.support;

public class ProgressStatModel {

    private String progressNameGuid;
    private String progressName;
    private String currentMonthNum;//本月数量
    private String currentMonthPercent; //本月百分比
    private String cumulantNum;     //累计数量
    private String cumulantPercent;     //累计百分比
    private String totalNum;        //总计数量
    private String totalPercent;        //总计百分比

    public ProgressStatModel() {
    }

    public String getProgressNameGuid() {
        return progressNameGuid;
    }

    public void setProgressNameGuid(String progressNameGuid) {
        this.progressNameGuid = progressNameGuid;
    }

    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }

    public String getCurrentMonthPercent() {
        return currentMonthPercent;
    }

    public void setCurrentMonthPercent(String currentMonthPercent) {
        this.currentMonthPercent = currentMonthPercent;
    }

    public String getCumulantPercent() {
        return cumulantPercent;
    }

    public void setCumulantPercent(String cumulantPercent) {
        this.cumulantPercent = cumulantPercent;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getTotalPercent() {
        return totalPercent;
    }

    public void setTotalPercent(String totalPercent) {
        this.totalPercent = totalPercent;
    }

    public String getCurrentMonthNum() {
        return currentMonthNum;
    }

    public void setCurrentMonthNum(String currentMonthNum) {
        this.currentMonthNum = currentMonthNum;
    }

    public String getCumulantNum() {
        return cumulantNum;
    }

    public void setCumulantNum(String cumulantNum) {
        this.cumulantNum = cumulantNum;
    }

    @Override
    public String toString() {
        return "ProgressStatModel{" +
                "progressNameGuid='" + progressNameGuid + '\'' +
                ", progressName='" + progressName + '\'' +
                ", currentMonthNum='" + currentMonthNum + '\'' +
                ", currentMonthPercent='" + currentMonthPercent + '\'' +
                ", cumulantNum='" + cumulantNum + '\'' +
                ", cumulantPercent='" + cumulantPercent + '\'' +
                ", totalNum='" + totalNum + '\'' +
                ", totalPercent='" + totalPercent + '\'' +
                '}';
    }
}
