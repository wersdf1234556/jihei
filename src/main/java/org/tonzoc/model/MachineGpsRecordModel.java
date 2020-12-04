package org.tonzoc.model;

import org.tonzoc.annotation.*;

// 机械GPS表
@Table("machineGpsRecords")
public class MachineGpsRecordModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "lat")
    private String lat; // 纬度
    @Column(value = "lnt")
    private String lnt; // 经度
    @Column(value = "sortId")
    private Integer sortId;
    @Column(value = "machineGuid")
    private String machineGuid;
    @Column(value = "latest")
    private Integer latest; // 最新的

    @JoinColumn(value = "name", type = MachineModel.class, leftColumn = "machineGuid", rightColumn = "guid")
    private String machineName;

    public MachineGpsRecordModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLnt() {
        return lnt;
    }

    public void setLnt(String lnt) {
        this.lnt = lnt;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getMachineGuid() {
        return machineGuid;
    }

    public void setMachineGuid(String machineGuid) {
        this.machineGuid = machineGuid;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public Integer getLatest() {
        return latest;
    }

    public void setLatest(Integer latest) {
        this.latest = latest;
    }

    @Override
    public String toString() {
        return "MachineGpsRecordModel{" +
                "guid='" + guid + '\'' +
                ", lat='" + lat + '\'' +
                ", lnt='" + lnt + '\'' +
                ", sortId=" + sortId +
                ", machineGuid='" + machineGuid + '\'' +
                ", latest=" + latest +
                ", machineName='" + machineName + '\'' +
                '}';
    }
}
