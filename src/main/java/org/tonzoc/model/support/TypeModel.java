package org.tonzoc.model.support;

public class TypeModel {

    private String typeId;
    private String typeName;
    private String typeCount;
    private String typeBalance;

    public TypeModel() {
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeCount() {
        return typeCount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setTypeCount(String typeCount) {
        this.typeCount = typeCount;
    }

    public String getTypeBalance() {
        return typeBalance;
    }

    public void setTypeBalance(String typeBalance) {
        this.typeBalance = typeBalance;
    }

    @Override
    public String toString() {
        return "TypeModel{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeCount='" + typeCount + '\'' +
                ", typeBalance='" + typeBalance + '\'' +
                '}';
    }
}
