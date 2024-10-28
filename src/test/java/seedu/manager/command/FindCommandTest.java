package seedu.manager.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.manager.event.EventList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindCommandTest {
    private EventList eventList;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @BeforeEach
    public void testSetUp() {
        eventList = new EventList();
        eventList.addEvent("Event 1", LocalDateTime.parse("2024-10-10 16:00", formatter),
                "Venue 1");
        eventList.addParticipantToEvent("John Doe", "Event 1");
        eventList.addParticipantToEvent("Jane Doe", "Event 1");
        eventList.addParticipantToEvent("Kuan Hsien", "Event 1");
    }

    @Test
    public void execute_findCommand_success() {
        FindCommand findCommand = new FindCommand("Event 1", "doe");

        findCommand.setData(eventList);
        findCommand.execute();

        String expectedMessage = "Person(s) found!\n" +
                "1. John Doe [ ]\n" +
                "2. Jane Doe [ ]\n";
        assertEquals(expectedMessage, findCommand.getMessage());
    }

    @Test
    public void execute_findCommand_failure() {
        FindCommand findCommand = new FindCommand("Event 1", "aly");

        findCommand.setData(eventList);
        findCommand.execute();

        String expectedMessage = "Person not found!";
        assertEquals(expectedMessage, findCommand.getMessage());
    }

    @Test
    public void execute_findCommand_eventNotFound() {
        FindCommand findCommand = new FindCommand("Event 2", "doe");

        findCommand.setData(eventList);
        findCommand.execute();

        String expectedMessage = "Event not found!";
        assertEquals(expectedMessage, findCommand.getMessage());
    }
}