package seedu.parser;

import seedu.contact.DetailType;
import seedu.exception.InvalidFlagException;
import seedu.exception.MissingArgException;
import seedu.exception.MissingDetailException;

public abstract class ContactParser {
    public static final int CONTACT_PARAMS_START_INDEX = 1;
    public static final int NUMBER_OF_DETAILS = 2;
    public static final int NUMBER_OF_EDIT_DETAILS = 3;

    public static final String DETAIL_SEPARATOR = " -";
    public static final int FLAG_INDEX_IN_DETAILS = 0;
    public static final int DETAIL_INDEX_IN_DETAILS = 1;
    public static final int EDIT_USER_INDEX = 1;
    public static final int USER_INFO_INDEX = 2;

    public static final String NAME_FLAG = "n";
    public static final String GITHUB_FLAG = "g";

    public abstract String[] parseContactDetails(String userInput) throws InvalidFlagException,
            MissingArgException, MissingDetailException;

}