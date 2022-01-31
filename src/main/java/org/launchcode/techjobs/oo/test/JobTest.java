package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    private Job jobA;
    private Job jobB;
    private Job jobC;
    private Job jobD;
    @Before
    public void createTestJobs(){
        jobA = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        jobB = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        jobC = new Job("LaunchCoder",
                new Employer("LaunchCode"),
                new Location("St. Louis, MO"),
                new PositionType("Web Developer"),
                new CoreCompetency(""));
        jobD = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));
    }
    @Test
    public void testSettingJobId(){
        int jobAId = jobA.getId();
        int jobBId = jobB.getId();
        assertFalse(jobAId == jobBId); //job ids are not the same
        assertTrue(jobBId - jobAId == 1); //job ids differ by 1

    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(jobA.getName() instanceof String);
        assertTrue(jobA.getName() == "Product tester");
        assertTrue(jobA.getEmployer() instanceof Employer);
        assertTrue(jobA.getEmployer().toString() == "ACME");
        assertTrue(jobA.getLocation() instanceof Location);
        assertTrue(jobA.getLocation().toString() == "Desert");
        assertTrue(jobA.getPositionType() instanceof PositionType);
        assertTrue(jobA.getPositionType().toString() == "Quality control");
        assertTrue(jobA.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(jobA.getCoreCompetency().toString() == "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(jobA.equals(jobB));
    }

    @Test
    public void testPrintJobFormatting(){
        String[] jobBArray = jobB.toString().split("\n", -1); //verifies each item is separated by a newline char
        String[] jobCArray = jobC.toString().split("\n", -1);
        String jobBIdStr = Integer.toString(jobB.getId()); //type change needed for comparison
        String jobCIdStr = Integer.toString(jobC.getId());
        assertSame(jobBArray.length , 8); //formatting implies 8 total lines per job
        assertSame(jobA.toString().indexOf("\n") , 0); //starts with newline char
        assertTrue(jobA.toString().lastIndexOf("\n")==  jobA.toString().length()-1); //ends with newline char
        assertTrue(jobBArray[1].contains("ID: " + jobBIdStr));
        assertTrue(jobBArray[2].contains("Name: " + jobB.getName()));
        assertTrue(jobBArray[3].contains("Employer: " + jobB.getEmployer()));
        assertTrue(jobBArray[4].contains("Location: " + jobB.getLocation()));
        assertTrue(jobBArray[5].contains("Position Type: " + jobB.getPositionType()));
        assertTrue(jobBArray[6].contains("Core Competency: " + jobB.getCoreCompetency()));
        assertTrue(jobCArray[6].contains("Core Competency: Data not available"));
        assertTrue(jobD.toString()=="OOPS! This job does not seem to exist.");
    }


}
