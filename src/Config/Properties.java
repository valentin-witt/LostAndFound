package Config;

import java.util.List;

public class Properties {

    private String ressourcesPath;

    private List<Riddle> riddles;

    public String getRessourcesPath() {
        return ressourcesPath;
    }

    public void setRessourcesPath(String ressourcesPath) {
        this.ressourcesPath = ressourcesPath;
    }

    public List<Riddle> getRiddles() {
        return riddles;
    }

    public void setRiddles(List<Riddle> riddles) {
        this.riddles = riddles;
    }


}
