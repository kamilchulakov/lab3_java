package project.time;

import project.time.Season;

public interface Timer {
    public Season getSeason();
    public void setSeason(Season season);
    public void process();

}
