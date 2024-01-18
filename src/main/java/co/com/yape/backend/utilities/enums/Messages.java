package co.com.yape.backend.utilities.enums;

public enum Messages {
    DECRYPT_ERROR("An error occurred while decrypting"),
    ENCRYPT_ERROR("An error occurred while encrypting"),
    NOT_SEARCH_RESULTS("No results found in the search"),
    UNEXPECTED_MESSAGE_ERROR("The message presented is not what was expected."),
    WELCOME_MESSAGE("%s, %s");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
