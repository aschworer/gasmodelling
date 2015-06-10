/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.forms;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.model.Department;
import ifmo.diploma.model.Employee;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created: 25.10.2007 || 16:22:49
 *
 *
 */
public class SearchForm extends ValidatorForm {
    private String lastname;
    private String firstname;
    private String middlename;
    private String departmentID;
    private List<Department> departments;

    private List<Employee> result;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Employee> getResult() {
        return result;
    }

    public void setResult(List<Employee> result) {
        this.result = result;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        ActionErrors errors = super.validate(actionMapping, httpServletRequest);
        if (date != null) {
            if (date.length() != 0) {
                try {

                    java.sql.Date.valueOf(date);

                } catch (Exception e) {
                    ApplicationActionServlet.bindError(errors, ApplicationActionServlet.ERROR_DATE);
                }
            }
        }
        return errors;
    }

}
