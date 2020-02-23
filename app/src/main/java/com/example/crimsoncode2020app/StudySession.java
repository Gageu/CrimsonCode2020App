package com.example.crimsoncode2020app;

public class StudySession {
    private String name, subject, locationDescription, instructor, assignment;
    private boolean privateSession, showName;

    public StudySession(String name, String subject, String locationDescription, String instructor,
                        String assignment, boolean privateSession, boolean showName)
    {
        this.name = name;
        this.subject = subject;
        this.locationDescription = locationDescription;
        this.instructor = instructor;
        this.assignment = assignment;
        this.privateSession = privateSession;
        this.showName = showName;

    }


}
