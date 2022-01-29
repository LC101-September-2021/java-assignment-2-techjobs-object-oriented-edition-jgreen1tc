package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

}
