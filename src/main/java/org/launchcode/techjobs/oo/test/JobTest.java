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
    @Before
    public void createTestJobs(){
        jobA = new Job();
        jobB = new Job();
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
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        System.out.println(job.getPositionType().toString());
        System.out.println(job.getEmployer().toString());
        assertTrue(job.getName() == "Product tester");
        assertTrue(job.getEmployer().toString() == "ACME");
        assertTrue(job.getLocation().toString() == "Desert");
        assertTrue(job.getPositionType().toString() == "Quality control");
        assertTrue(job.getCoreCompetency().toString() == "Persistence");
    }

}
