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
    public static final int DETAILS_TO_SPLIT = 2;
    public static final int FLAG_INDEX_IN_DETAILS = 0;
    public static final int DETAIL_INDEX_IN_DETAILS = 1;

    public static final String NAME_FLAG = "n";
    public static final String GITHUB_FLAG = "g";

    public abstract String[] parseContactDetails(String userInput) throws InvalidFlagException,
            MissingArgException, MissingDetailException;

    /**
     * This method takes in the contactDetails array and populates it with contact details.
     * It will sift out the flags to decide what details to populate, using the
     * enumeration from DetailType.
     *
     * @param contactDetails String array containing contact details
     * @param detail         Unparsed detail
     * @throws InvalidFlagException If the flag given is not recognised
     */
    public void parseDetail(String[] contactDetails, String detail) throws InvalidFlagException {
        String[] destructuredDetails = detail.split(" ", NUMBER_OF_EDIT_DETAILS);
        int indexToStore;
        switch (destructuredDetails[FLAG_INDEX_IN_DETAILS]) {
        case NAME_FLAG:
            indexToStore = DetailType.NAME.getIndex();
            break;
        case GITHUB_FLAG:
            indexToStore = DetailType.GITHUB.getIndex();
            break;
        default:
            throw new InvalidFlagException();
        }
        contactDetails[indexToStore] = destructuredDetails[DETAIL_INDEX_IN_DETAILS];
    }
}
