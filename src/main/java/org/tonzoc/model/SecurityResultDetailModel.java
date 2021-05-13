package org.tonzoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.tonzoc.annotation.Column;
import org.tonzoc.annotation.NotInsertColumn;
import org.tonzoc.annotation.PrimaryKey;
import org.tonzoc.annotation.Table;

@Table(value = "securityResultDetails")
public class SecurityResultDetailModel extends BaseModel {
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "posLeft")
    private Integer posLeft;
    @Column(value = "posTop")
    private Integer posTop;
    @Column(value = "posRight")
    private Integer posRight;
    @Column(value = "posBottom")
    private Integer posBottom;
    @Column(value = "score")
    private Integer score;
    @Column(value = "securityResultGuid")
    private String securityResultGuid;

    public String getSecurityResultGuid() {
        return securityResultGuid;
    }

    public void setSecurityResultGuid(String securityResultGuid) {
        this.securityResultGuid = securityResultGuid;
    }

    public SecurityResultDetailModel() {
    }

    public String getGuid() {
        return guid;
    }

    public Integer getPosLeft() {
        return posLeft;
    }

    public Integer getPosTop() {
        return posTop;
    }

    public Integer getPosRight() {
        return posRight;
    }

    public Integer getPosBottom() {
        return posBottom;
    }

    public Integer getScore() {
        return score;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty(value = "left")
    public void setPosLeft(Integer posLeft) {
        this.posLeft = posLeft;
    }

    @JsonProperty(value = "top")
    public void setPosTop(Integer posTop) {
        this.posTop = posTop;
    }

    @JsonProperty(value = "right")
    public void setPosRight(Integer posRight) {
        this.posRight = posRight;
    }

    @JsonProperty(value = "bottom")
    public void setPosBottom(Integer posBottom) {
        this.posBottom = posBottom;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SecurityResultDetailModel{" +
                "guid='" + guid + '\'' +
                ", posLeft=" + posLeft +
                ", posTop=" + posTop +
                ", posRight=" + posRight +
                ", posBottom=" + posBottom +
                ", score=" + score +
                ", securityResultGuid='" + securityResultGuid + '\'' +
                '}';
    }
}
