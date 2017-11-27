package lt.jonas.project.service;

/**
 * Created by ramunas on 02/10/2017.
 */
public interface SecurityService {
    String findLogginUsername();
    void login(String username, String passw);

}
