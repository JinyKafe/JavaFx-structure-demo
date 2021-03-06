package com.example.command;

import com.example.model.RaceCard;
import com.example.service.IRaceCardService;
import com.example.service.RaceCardService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class RaceCardCommand extends Service<RaceCard> {

    private int raceCardId;
    private final IRaceCardService raceCardService = RaceCardService.getInstance();

    public void setRaceCardId(int raceCardId) {
        this.raceCardId = raceCardId;
    }

    @Override
    protected Task<RaceCard> createTask() {
        return new Task<>() {
            @Override
            protected RaceCard call() {
                return raceCardService.getRaceCard(raceCardId);
            }
        };
    }
}
