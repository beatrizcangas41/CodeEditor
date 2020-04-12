package model;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class ProgrammingLanguage {
    private String programmingLanguageName;
    private SimpleIntegerProperty programmingLanguageID;
    public List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();

    public ProgrammingLanguage(String programmingLanguageName, SimpleIntegerProperty programmingLanguageID,
                               List<ProgrammingLanguage> programmingLanguages) {

        this.programmingLanguageName = programmingLanguageName;
        this.programmingLanguageID = programmingLanguageID;
        this.programmingLanguages = programmingLanguages;
    }

    public String getProgrammingLanguageName() {
        return programmingLanguageName;
    }

    public void setProgrammingLanguageName(String programmingLanguageName) {
        this.programmingLanguageName = programmingLanguageName;
    }

    public int getProgrammingLanguageID() {
        return programmingLanguageID.get();
    }

    public SimpleIntegerProperty programmingLanguageIDProperty() {
        return programmingLanguageID;
    }

    public void setProgrammingLanguageID(int programmingLanguageID) {
        this.programmingLanguageID.set(programmingLanguageID);
    }

    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<ProgrammingLanguage> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
}
