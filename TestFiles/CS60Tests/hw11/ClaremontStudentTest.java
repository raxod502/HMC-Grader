import static org.junit.Assert.*;

import org.junit.Test;

public class ClaremontStudentTest {

  @Test
  public void testConstructor() {
    ClaremontStudent student1 = new ClaremontStudent(
        ClaremontStudent.School.CMC, new String("Taylor"));
    assertEquals("Taylor",  student1.getName());
  }

  @Test
  public void testEquals() {
    ClaremontStudent student1 = new ClaremontStudent(
        ClaremontStudent.School.PITZER, new String("Taylor"));
    assertEquals("Taylor",  student1.getName());
    ClaremontStudent student2 = new ClaremontStudent(
        ClaremontStudent.School.PITZER, new String("Taylor"));
    assertEquals("Taylor",  student2.getName());
    assertEquals(student1, student2);
  }
  @Test
  public void testCheer() {
    ClaremontStudent student1 = new ClaremontStudent(
        ClaremontStudent.School.HMC, "Taylor");
    assertEquals("Taylor",  student1.getName());
    assertEquals("Go Stags and Athenas!", student1.cheer());
  }

}