package seedu.parser;

import seedu.contact.DetailType;
import seedu.exception.InvalidFlagException;
import seedu.exception.MissingArgException;
import seedu.exception.MissingDetailException;

public class AddContactParser extends ContactParser {
    /**
     * Returns a String[] containing the user's input and the arguments specified for
     * each detail flag. Each detail is parsed individually using parseDetail.
     * <p>
     * Eg. userInput => add -n andre -g ng-andre
     *     output => ["andre", "ng-andre"]
     * </p>
     * Note: Each index is properly identified by enumeration in contact/DetailType
     * @param userInput User's complete untouched input
     * @return String[] Returns an array of details
     * @throws InvalidFlagException If the flag given is not recognised
     */
    public String[] parseContactDetails(String userInput) throws InvalidFlagException, MissingArgException,
            MissingDetailException {
        String[] contactDetails = new String[NUMBER_OF_DETAILS];
        String[] destructuredInputs = userInput.split(DETAIL_SEPARATOR);
        if (destructuredInputs.length == 1) {
            throw new MissingArgException();
        }
        for (int i = CONTACT_PARAMS_START_INDEX; i < destructuredInputs.length; i++) {
            parseDetail(contactDetails, destructuredInputs[i]);
        }
        return contactDetails;
    }

    /**
     * This method takes in the contactDetails array and populates it with contact details.
     * It will sift out the flags to decide what details to populate, using the
     * enumeration from DetailType.
     *
     * @param contactDetails String array containing contact details
     * @param detail         Unparsed detail
     * @throws InvalidFlagException If the flag given is not recognised
     */
    public void parseDetail(String[] contactDetails, String detail) throws InvalidFlagException,
            MissingDetailException {
        String[] destructuredDetails = detail.split(" ", NUMBER_OF_DETAILS);
        if (destructuredDetails.length < 2) {
            throw new MissingDetailException();
        }
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