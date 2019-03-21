package service.competition;

import com.company.domain.Person;
import com.company.domain.enemy.Enemy;
import com.company.enums.UserAction;
import com.company.service.competition.CompetitionServiceDispatcher;
import com.company.service.competition.FightService;
import com.company.service.competition.QuietKillService;
import com.company.service.competition.TheftService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CompetitionServiceDispatcherTest {
    @Mock
    private FightService fightService;
    @Mock
    private TheftService theftService;
    @Mock
    private QuietKillService quietKillService;
    @InjectMocks
    private CompetitionServiceDispatcher competitionServiceDispatcher;

    @Test
    public void getBountyTest_shouldExecutesFightService() {
        competitionServiceDispatcher.getBounty(UserAction.FIGHT, any(Person.class), any(Enemy.class));
        verify(fightService).compete(any(Person.class), any(Enemy.class));
    }

    @Test
    public void getBountyTest_shouldExecutesTheftService() {
        competitionServiceDispatcher.getBounty(UserAction.THEFT, any(Person.class), any(Enemy.class));
        verify(theftService).compete(any(Person.class), any(Enemy.class));
    }

    @Test
    public void getBountyTest_shouldExecutesQuietKillService() {
        competitionServiceDispatcher.getBounty(UserAction.KILL, any(Person.class), any(Enemy.class));
        verify(quietKillService).compete(any(Person.class), any(Enemy.class));
    }
}
