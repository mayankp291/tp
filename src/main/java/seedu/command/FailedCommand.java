package seedu.command;

import seedu.parser.FailedCommandType;
import seedu.ui.TextUi;

public class FailedCommand extends Command {
    private FailedCommandType type;

    public FailedCommand(FailedCommandType type) {
        this.type = type;
    }

    public void execute() {
        switch (type) {
        case GENERAL:
            TextUi.invalidCommandMessage();
            break;
        case INVALID_FLAG:
            TextUi.invalidFlagMessage();
            break;
        case MISSING_ARG:
            TextUi.missingArgMessage();
            break;
        case MISSING_DETAIL:
            TextUi.missingDetailMessage();
            break;
        case INVALID_NUM:
            TextUi.invalidNumMessage();
            break;
        case INVALID_FORMAT:
            TextUi.invalidFormatMessage();
            break;
        default:
            return;
        }
    }
}
