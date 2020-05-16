package com.javafx.ourproject.appgestionscolarite;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitialiser implements ApplicationListener<HomeStartup.StageReadyEvent> {

    @Override
    public void onApplicationEvent(HomeStartup.StageReadyEvent stageReadyEvent) {
        stageReadyEvent.getStage();
    }
}
