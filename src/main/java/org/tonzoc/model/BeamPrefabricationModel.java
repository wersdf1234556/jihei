package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

// 预制梁
@Table("beamPrefabrications")
public class BeamPrefabricationModel extends BaseModel{

    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "leftAndRight")
    private String leftAndRight; // 左右幅
    @Column(value = "cross")
    private String cross; // 跨
    @Column(value = "sortId")
    private Integer sortId;

    public BeamPrefabricationModel() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "BeamPrefabricationModel{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", leftAndRight='" + leftAndRight + '\'' +
                ", cross='" + cross + '\'' +
                ", sortId=" + sortId +
                '}';
    }
}
