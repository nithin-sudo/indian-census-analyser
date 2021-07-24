package com.bridgelabz.census;

public class CSVUserException extends Throwable {
        enum ExceptionType{
            FILE_NOT_FOUND,BINDING_PROBLEM_AT_RUNTIME,NULL_DATA_FOUND,FIELD_NOT_FOUND;
        }
        ExceptionType type;

        public CSVUserException(ExceptionType type, String message ) {
            super(message);
            this.type = type;
        }

        public CSVUserException(ExceptionType type, String message,  Throwable cause) {
            super(message, cause);
            this.type = type;
        }
}
