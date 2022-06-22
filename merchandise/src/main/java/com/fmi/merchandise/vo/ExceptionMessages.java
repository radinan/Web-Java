package com.fmi.merchandise.vo;

import java.util.Optional;

public enum ExceptionMessages {
    USERNAME_NOT_FOUND("User with name %s not found."),
    ITEM_ID_NOT_FOUND("Item with id %d not found."),
    COMMENT_ID_NOT_FOUND("Comment with id %d not found."),
    INVALID_DATA("Invalid data provided.");

    private final String description;

    ExceptionMessages(String description) {
        this.description = description;
    }


    public static Optional<ExceptionMessages> getValueByDescription(String description) {
        for (ExceptionMessages element : values()) {
            if (element.getDescription().equals(description)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    public String getDescription() {
        return description;
    }
}
