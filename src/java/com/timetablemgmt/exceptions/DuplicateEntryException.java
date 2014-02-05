package com.timetablemgmt.exceptions;

public class DuplicateEntryException extends RuntimeException {

    private static final long serialVersionUID = 4376247054260375625L;

    public DuplicateEntryException() {
        // TODO Auto-gen constructor stub
    }

    public DuplicateEntryException(String message) {
        super(message);
        // TODO Auto-gen constructor stub
    }

    public DuplicateEntryException(Throwable cause) {
        super(cause);
        // TODO Auto-gen constructor stub
    }

    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-gen constructor stub
    }
}
