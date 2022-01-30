package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String name;
        if (this.getName().isEmpty()) {
            name = "Data not available";
        } else {
            name = getName();
        }
        String employer;
        if (getEmployer().toString().isEmpty()) {
            employer = "Data not available";
        } else {
            employer = getEmployer().toString();
        }
        String location;
        if (getLocation().toString().isEmpty()){
            location = "Data not available";
        } else {
            location = getLocation().toString();
        }
        String positionType;
        if (getPositionType().toString().isEmpty()) {
            positionType = "Data not available";
        } else {
            positionType = getPositionType().toString();
        }

        String coreCompetency;
        if(getCoreCompetency().toString().isEmpty()) {
            coreCompetency = "Data not available";
        } else {
            coreCompetency = getCoreCompetency().toString();
        }
        String jobString = "\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Employer: " + employer + "\n" +
                "Location: " + location + "\n" +
                "Position Type: " + positionType + "\n" +
                "Core Competency: " + coreCompetency +
                "\n";
        ArrayList<String> jobFields = new ArrayList<>(Arrays.asList(name, employer, location, positionType, coreCompetency));
        int count = 0;
        for(int i = 0; i < jobFields.size(); i++){
            if (jobFields.get(i) =="Data not available"){
                count++;
            }
        }
        if (count == jobFields.size()){
            jobString = "OOPS! This job does not seem to exist.";
        }

        return jobString;
    }

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
}
