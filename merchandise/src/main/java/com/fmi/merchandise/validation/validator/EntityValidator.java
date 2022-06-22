package com.fmi.merchandise.validation.validator;

import com.fmi.merchandise.model.Comment;
import com.fmi.merchandise.model.Item;
import com.fmi.merchandise.model.User;
import com.fmi.merchandise.validation.exception.ApiBadRequestException;
import com.fmi.merchandise.validation.exception.ApiResourceNotFoundException;
import com.fmi.merchandise.vo.ExceptionMessages;

import java.util.Optional;

public class EntityValidator {
    public static void validateUserExists(Optional<User> user, String username) {
        if (!user.isPresent()) {
            String message = String.format(ExceptionMessages.USERNAME_NOT_FOUND.getDescription(), username);
            throw new ApiResourceNotFoundException(message);
        }
    }

    public static void validatePasswordMatches(String password, String actualPassword) {
        if (!actualPassword.equals(password)) {
            throw new ApiBadRequestException(ExceptionMessages.INVALID_DATA.getDescription());
        }
    }

    public static void validateItemExists(Optional<Item> item, Long itemId) {
        if (!item.isPresent()) {
            String message = String.format(ExceptionMessages.ITEM_ID_NOT_FOUND.getDescription(), itemId);
            throw new ApiResourceNotFoundException(message);
        }
    }

    public static void validateCommentExists(Optional<Comment> comment, Long commentId) {
        if (!comment.isPresent()) {
            String message = String.format(ExceptionMessages.COMMENT_ID_NOT_FOUND.getDescription(), comment);
            throw new ApiResourceNotFoundException(message);
        }
    }
}
