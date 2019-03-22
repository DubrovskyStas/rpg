package service.competition;

import com.company.domain.Bounty;
import com.company.domain.Person;
import com.company.domain.enemy.Enemy;
import com.company.service.competition.CompetitionService;
import com.company.service.competition.QuietKillService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Optional;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@PrepareForTest({QuietKillService.class, CompetitionService.class, Math.class})
@RunWith(PowerMockRunner.class)
public class QuitKillServiceTest {
    private QuietKillService quietKillService = new QuietKillService();

    @Test
    public void competeTest_shouldWinPerson() {
        mockStatic(Math.class);
        when(Math.round(Matchers.anyDouble())).thenReturn(1L);
        when(Math.random()).thenReturn(1.0);
        Bounty actual = quietKillService.compete(new Person().setAttack(10)
                        .setQuietAttack(10).setTheft(10),
                new Enemy(null, 1, 1, 1))
                .get();
        Bounty expected = new Bounty(1, 1, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void competeTest_shouldWinEnemy() {
        mockStatic(Math.class);
        Mockito.when(Math.random()).thenReturn(1.0);
        Optional<Bounty> actual = quietKillService
                .compete(new Person().setAttack(1).setQuietAttack(1).setTheft(1),
                new Enemy(null, 10, 10, 10));
        Assert.assertFalse(actual.isPresent());
    }
}
