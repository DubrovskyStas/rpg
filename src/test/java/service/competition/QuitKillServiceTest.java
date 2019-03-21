package service.competition;

import com.company.domain.Person;
import com.company.domain.enemy.Enemy;
import com.company.service.competition.QuietKillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(Math.class)
@RunWith(PowerMockRunner.class)
public class QuitKillServiceTest {
    private QuietKillService quietKillService = new QuietKillService();

    @Test
    public void competeTest_shouldWinPerson() {
        PowerMockito.mockStatic(Math.class);
        Mockito.when(Math.random()).thenReturn(1.0);
        quietKillService.compete(new Person().setAttack(10).setQuietAttack(10).setTheft(10),
                new Enemy(null, 1, 1, 1));
    }

    @Test
    public void competeTest_shouldWinEnemy() {
        PowerMockito.mockStatic(Math.class);
        Mockito.when(Math.random()).thenReturn(1.0);
        quietKillService.compete(new Person().setAttack(1).setQuietAttack(1).setTheft(1),
                new Enemy(null, 10, 10, 10));
    }
}
