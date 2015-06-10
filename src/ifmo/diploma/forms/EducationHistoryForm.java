/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.forms;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.DAO.ConnectionFailedException;
import ifmo.diploma.DAO.GettingDataFailedException;
import ifmo.diploma.model.EducationHistoryItem;
import ifmo.diploma.model.EducationPlace;
import ifmo.diploma.model.EducationType;
import ifmo.diploma.model.Employee;
import org.apache.commons.logging.Log; import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created: 30.10.2007 || 17:27:00
 *
 *
 */
public class EducationHistoryForm extends ValidatorForm {
    private static Log logger = LogFactory.getLog(EducationHistoryForm.class);

    private List<EducationHistoryItem> history;
    private EducationHistoryItem newHistoryItem;
    private List<EducationType> types;
    private List<EducationPlace> places;

    private FormFile documentCopy;
    private String addPlace = "off";
    private String newPlaceName;


    public String getNewPlaceName() {
        return newPlaceName;
    }

    public void setNewPlaceName(String newPlaceName) {
        this.newPlaceName = newPlaceName;
    }

    public String getAddPlace() {
        return addPlace;
    }

    public void setAddPlace(String addPlace) {
        this.addPlace = addPlace;
    }

    public FormFile getDocumentCopy() {
        return documentCopy;
    }

    public void setDocumentCopy(FormFile documentCopy) {
        this.documentCopy = documentCopy;
    }

    public List<EducationHistoryItem> getHistory() {
        return history;
    }

    public void setHistory(List<EducationHistoryItem> history) {
        this.history = history;
    }


    public EducationHistoryItem getNewHistoryItem() {
        return newHistoryItem;
    }

    public void setNewHistoryItem(EducationHistoryItem newHistoryItem) {
        this.newHistoryItem = newHistoryItem;
    }

    public List<EducationType> getTypes() {
        return types;
    }

    public void setTypes(List<EducationType> types) {
        this.types = types;
    }

    public List<EducationPlace> getPlaces() {
        return places;
    }

    public void setPlaces(List<EducationPlace> places) {
        this.places = places;
    }


    public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        try {
            Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
            if (employee == null) {
                return;
            }
            if (newHistoryItem == null) {
                newHistoryItem = new EducationHistoryItem();
                newHistoryItem.setPlace(new EducationPlace());
                newHistoryItem.setType(new EducationType());
//            getNewHistoryItem().setTill("1985-11-20");
//            getNewHistoryItem().setFrom("1985-11-20");
                newHistoryItem.setEmployee(employee);
            }
            history = ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationHistory(employee.getId());
//            setPlaces(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationPlaces());
//            setTypes(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationTypes());
        } catch (GettingDataFailedException e) {
        } catch (ConnectionFailedException e) {
        }
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        ActionErrors errors = super.validate(actionMapping, httpServletRequest);

        for (EducationHistoryItem educationHistoryItem : history) {
            try {
                Integer.parseInt(educationHistoryItem.getDocumentNO());
            } catch (Exception e) {
                ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_INTEGER, new String[]{"Document No"});
                return errors;
            }

            try {
                java.sql.Date.valueOf(educationHistoryItem.getFrom());
                java.sql.Date.valueOf(educationHistoryItem.getTill());
            } catch (Exception e) {
                ApplicationActionServlet.bindError(errors, ApplicationActionServlet.ERROR_DATE);
            }

        }

        if ("addHistoryItem".equals(httpServletRequest.getParameter("method"))) {
            try {
                Integer.parseInt(newHistoryItem.getDocumentNO());
            } catch (Exception e) {
                ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_INTEGER, new String[]{"Document No"});
                return errors;
            }
            try {
                java.sql.Date.valueOf(newHistoryItem.getFrom());
                java.sql.Date.valueOf(newHistoryItem.getTill());
            } catch (Exception e) {
                ApplicationActionServlet.bindError(errors, ApplicationActionServlet.ERROR_DATE);
            }
        }

        return errors;
    }
}
