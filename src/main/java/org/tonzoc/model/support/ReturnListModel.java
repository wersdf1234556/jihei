package org.tonzoc.model.support;

import org.tonzoc.model.ReturnModel;

import java.util.List;

public class ReturnListModel {

    private String name;
    private List<ReturnModel> listReturn;
    private List<ReturnMachineModel> listMachine;

    public ReturnListModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReturnModel> getListReturn() {
        return listReturn;
    }

    public void setListReturn(List<ReturnModel> listReturn) {
        this.listReturn = listReturn;
    }

    public List<ReturnMachineModel> getListMachine() {
        return listMachine;
    }

    public void setListMachine(List<ReturnMachineModel> listMachine) {
        this.listMachine = listMachine;
    }

    @Override
    public String toString() {
        return "ReturnListModel{" +
                "name='" + name + '\'' +
                ", listReturn=" + listReturn +
                ", listMachine=" + listMachine +
                '}';
    }
}
