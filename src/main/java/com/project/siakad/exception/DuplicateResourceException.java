    package com.project.siakad.exception;

    public class DuplicateResourceException extends RuntimeException {
        public DuplicateResourceException () {
            super();
        }
        public DuplicateResourceException(String message) {
            super(message);
        }
    }
    
