import domain.Constants;
import enums.HomeOption;
import service.GameService;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> Constants.INPUT.close()));
        GameService gameService = new GameService();
        gameService.loop();
    }
}
