package org.tonzoc.model;

import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "beamStatus")
public class BeamStatusModel extends BaseModel{

    @NotInsertColumn
    @PrimaryKey
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name;
    @Column(value = "status")
    private String status;
    @Column(value = "color")
    private String color;
    @Column(value = "sortId")
    private Integer sortId;

    public BeamStatusModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
