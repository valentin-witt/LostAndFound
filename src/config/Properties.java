package config;

import java.util.List;

public class Properties {

    private String ressourcesPath;
    private int countdownTime;
    private List<Riddle> riddles;

    public int getCountdownTime() {
        return countdownTime;
    }

    public void setCountdownTime(int countdownTime) {
        this.countdownTime = countdownTime;
    }

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
