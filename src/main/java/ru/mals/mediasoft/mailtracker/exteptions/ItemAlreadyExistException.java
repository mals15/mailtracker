package ru.mals.mediasoft.mailtracker.exteptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemAlreadyExistException extends RuntimeException {

    public ItemAlreadyExistException(String itemIdentifier) {
        super ("Item with identifier " + itemIdentifier + " already exist. ");
    }
}
