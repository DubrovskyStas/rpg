package service;

import com.company.domain.Person;
import com.company.service.IoService;
import com.company.service.PersonService;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @Mock
    IoService ioService;
    @InjectMocks
    private PersonService personService;

    @Test
    public void testSerializationDeserialization() throws IOException, ClassNotFoundException {
        Path tempDirWithPrefix = Files.createTempDirectory("prefix");
        System.setProperty("backup.path", tempDirWithPrefix.toString());

        when(ioService.getBackupPath()).thenReturn(tempDirWithPrefix.toString());
        Person expected = new Person().setAttack(10).setQuietAttack(12).setTheft(15).setName("test");
        personService.createBackup(expected);

        Person actual = personService.restoreFromBackup();

        FileUtils.deleteDirectory(tempDirWithPrefix.toFile());
        Assert.assertEquals(expected, actual);
    }
}
