package org.tonzoc.model;

import org.tonzoc.annotation.*;

@Table(value = "persons")
public class PersonModel extends BaseModel{
    @PrimaryKey
    @NotInsertColumn
    @Column(value = "guid")
    private String guid;
    @Column(value = "name")
    private String name; // 名称
    @Column(value = "tenderGuid")
    private String tenderGuid; //标段
    @Column(value = "personTypeGuid")
    private String personTypeGuid; //工种guid
    @JoinColumn(value = "name", type = TenderModel.class, leftColumn = "tenderGuid", rightColumn = "guid")
    private String tenderName; //标段
    @JoinColumn(value = "name", type = PersonTypeModel.class, leftColumn = "personTypeGuid", rightColumn = "guid")
    private String typeName; //工种
    @Column(value = "idCard")
    private String idCard;
    @Column(value = "password")
    private String password; //手机端密码，明文
    @Column(value = "categoryGuid")
    private String categoryGuid; //类别
    @JoinColumn(value = "name", type = PersonCategoryModel.class, leftColumn = "categoryGuid", rightColumn = "guid")
    private String categoryName; //类别
    @Column(value = "mobile")
    private String mobile; //手机号
    @Column(value = "enterAreaTime")
    private String enterAreaTime; //进场时间
    @Column(value = "nativePlace")
    private String nativePlace;//籍贯
    @Column(value = "certificateName")
    private String certificateName;//证书名称
    @Column(value = "certificatePic")
    private String certificatePic; //证书照片
    @Column(value = "photo")
    private String photo; //人员照片



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

    public String getTenderGuid() {
        return tenderGuid;
    }

    public void setTenderGuid(String tenderGuid) {
        this.tenderGuid = tenderGuid;
    }

    public String getPersonTypeGuid() {
        return personTypeGuid;
    }

    public void setPersonTypeGuid(String personTypeGuid) {
        this.personTypeGuid = personTypeGuid;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategoryGuid() {
        return categoryGuid;
    }

    public void setCategoryGuid(String categoryGuid) {
        this.categoryGuid = categoryGuid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEnterAreaTime() {
        return enterAreaTime;
    }

    public void setEnterAreaTime(String enterAreaTime) {
        this.enterAreaTime = enterAreaTime;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificatePic() {
        return certificatePic;
    }

    public void setCertificatePic(String certificatePic) {
        this.certificatePic = certificatePic;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
