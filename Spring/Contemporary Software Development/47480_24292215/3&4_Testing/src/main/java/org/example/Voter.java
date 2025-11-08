package org.example;

public interface Voter {
    Vote vote();  // Method to get the voter's vote
    void inform(Result result);  // Method to inform the voter of the result
}