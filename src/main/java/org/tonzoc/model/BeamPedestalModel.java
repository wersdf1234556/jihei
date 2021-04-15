package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

// 梁台座
@Table("beamPedestals")
public class BeamPedestalModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "pedestalNum")
    private Integer pedestalNum;
    @Column(value = "sortId")
    private Integer sortId;

    public BeamPedestalModel() {
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

    public Integer getPedestalNum() {
        return pedestalNum;
    }

    public void setPedestalNum(Integer pedestalNum) {
        this.pedestalNum = pedestalNum;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "BeamPedestalModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", pedestalNum=" + pedestalNum +
                ", sortId=" + sortId +
                '}';
    }
}
