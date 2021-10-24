package seedu.duke.commands;

import seedu.duke.Status;
import seedu.duke.data.Catalogue;
import seedu.duke.data.Item;
import seedu.duke.ui.TextUI;

import static seedu.duke.common.Messages.LIST_ALL_MESSAGE;
import static seedu.duke.common.Messages.LIST_AVAILABLE_MESSAGE;
import static seedu.duke.common.Messages.LIST_LOANED_MESSAGE;
import static seedu.duke.common.Messages.DIVIDER;

/**
 * Command that lists out all items.
 */
public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";
    public static final String LIST_ALL_COMMAND = "list all";
    public static final String LIST_AVAILABLE_COMMAND = "list available";
    public static final String LIST_LOANED_COMMAND = "list loaned";
    public String input = "";

    /**
     * Single constructor, no parameters.
     */
    public ListCommand(String input) {
        this.input = input.strip();
    }

    /**
     * Prints out all items in the list.
     * Overrides method from parent class.
     * @param ui Object that handles user IO
     * @param catalogue Object that stores the list of all items
     */
    @Override
    public void execute(TextUI ui, Catalogue catalogue) {
        if (input.equals(LIST_ALL_COMMAND)) {
            ui.print(LIST_ALL_MESSAGE);
            ui.print(DIVIDER);
            for (Item temp : catalogue.getAllItems()) {
                ui.print(temp);
            }
        } else if (input.equals(LIST_AVAILABLE_COMMAND)) {
            ui.print(LIST_AVAILABLE_MESSAGE);
            ui.print(DIVIDER);
            for (Item temp : catalogue.getAllItems()) {
                if (temp.getStatus().equals(Status.AVAILABLE)) {
                    ui.print(temp);
                }
            }
        } else if (input.equals(LIST_LOANED_COMMAND)) {
            ui.print(LIST_LOANED_MESSAGE);
            ui.print(DIVIDER);
            for (Item temp : catalogue.getAllItems()) {
                if (temp.getStatus().equals(Status.LOANED)) {
                    ui.print(temp);
                }
            }
        }
        ui.print(DIVIDER);
    }
}