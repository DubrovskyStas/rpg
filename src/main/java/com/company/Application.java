package com.company;

import com.company.service.GameService;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        GameService gameService = new GameService();
        gameService.loop();
    }
}
