package org.tonzoc.model.support;

import org.tonzoc.model.ReturnModel;

import java.util.List;

public class ReturnListModel {

    private String name;
    private List<ReturnModel> list;

    public ReturnListModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReturnModel> getList() {
        return list;
    }

    public void setList(List<ReturnModel> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ReturnListModel{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
