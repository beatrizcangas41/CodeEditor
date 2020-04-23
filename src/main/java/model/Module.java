package model;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class Module extends Question {

    private String moduleName;
    private SimpleIntegerProperty moduleID;
    public List<Question> moduleQuestions = new ArrayList<>();

    public Module(String moduleName) {
        this.moduleName = null;
    }

    public Module(String bModuleName, SimpleIntegerProperty ID) {
        this.moduleName = bModuleName;
        this.moduleID = ID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getModuleID() {
        return moduleID.get();
    }

    public SimpleIntegerProperty moduleIDProperty() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID.set(moduleID);
    }

    public List<Question> getModuleQuestions() {
        return moduleQuestions;
    }

    public void setModuleQuestions(List<Question> moduleQuestions) {
        this.moduleQuestions = moduleQuestions;
    }

    public String getID(String moduleName) {
        if(this.moduleName.equals(moduleName)) return this.moduleName;
        else return null;
    }

    @Override
    public String toString() {
        return "Module: " + this.moduleName + "\t\t\tID: " + this.moduleID;
    }
}
