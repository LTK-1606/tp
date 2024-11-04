package seedu.manager.command;

//@@author glenn-chew
/**
 * Represents an executable menu command
 */
public class MenuCommand extends Command {
    public static final String COMMAND_WORD = "menu";
    private static final String MENU_MESSAGE = """
            Here are the possible commands:
           
            list: List events.
            view -e EVENT -y TYPE: View the list of participants or items of an event.
            add -e EVENT -t TIME -v VENUE -u PRIORITY: Add an event to the event list.
            add -m ITEM -e EVENT: Add an item to an even.
            add -p PARTICIPANT -n NUMBER -email EMAIL -e EVENT: Add a participant to an event.
            remove -e EVENT: Remove an event from the event list.
            remove -p PARTICIPANT -e EVENT: Remove a participant from an event.
            remove -m ITEM -e EVENT: Remove an item from an event.
            edit -e EVENT -name EVENT_NAME -t TIME -v VENUE -u PRIORITY: Edit event info.
            edit -m ITEM > NEW_ITEM -e EVENT: Edit an item in an event.
            edit -p PARTICIPANT -n NUMBER -email EMAIL -e EVENT: Edit participant contact info.
            mark -e EVENT -s STATUS: Mark an event as done or not done.
            mark -p PARTICIPANT -e EVENT -s STATUS: Mark a participant as present or absent.
            copy FROM_EVENT > TO_EVENT: Copies participant list from one event to another.
            sort -by KEYWORD: Sorts events by name/time/priority.
            filter -e/-d/-t/-x/-u FILTER_DESCRIPTION: Filters events by name/date/time/date-time/priority.
            find -e EVENT -p NAME: Finds all participants with specified name in an event.
            exit: Exit program.""";

    /**
     * Constructs a new MenuCommand
     */
    public MenuCommand() {
        super(false);
    }

    /**
     * Executes the menu command
     */
    @Override
    public void execute() {
        this.message = MENU_MESSAGE;
    }
}
