package org.tonzoc.model.support;

public class ProgressStatModel {

    private String progressNameGuid;
    private String progressName;
    private String currentMonth; //本月
    private String cumulant;     //累计
    private String total;        //总计

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

    public String getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }

    public String getCumulant() {
        return cumulant;
    }

    public void setCumulant(String cumulant) {
        this.cumulant = cumulant;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ProgressStatModel{" +
                "progressNameGuid='" + progressNameGuid + '\'' +
                ", progressName='" + progressName + '\'' +
                ", currentMonth='" + currentMonth + '\'' +
                ", cumulant='" + cumulant + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
