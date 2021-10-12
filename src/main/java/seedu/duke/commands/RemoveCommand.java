package seedu.duke.commands;

import seedu.duke.data.item.Catalogue;
import seedu.duke.data.item.Item;
import seedu.duke.ui.TextUI;

import static seedu.duke.common.Messages.RM_INVALID_FORMAT;
import static seedu.duke.common.Messages.RM_INVALID_ID;

public class RemoveCommand extends Command {
    public static final String COMMAND_REMOVE = "rm";
    protected String args;

    public RemoveCommand(String input) {
        args = input;
    }

    @Override
    public void execute(TextUI ui, Catalogue catalogue) {
        try {
            String[] argList = args.split(" ");
            if (argList.length == 2) {
                Item removed = catalogue.removeItem(argList[1]);
                // print removed item details
            } else {
                ui.print(RM_INVALID_ID);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.print(RM_INVALID_FORMAT);
        } catch (NullPointerException e) {
            ui.print(RM_INVALID_ID);
        }
    }

}
