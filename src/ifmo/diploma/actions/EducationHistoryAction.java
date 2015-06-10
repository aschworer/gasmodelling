/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.actions;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.forms.EducationHistoryForm;
import ifmo.diploma.model.EducationHistoryItem;
import ifmo.diploma.model.EducationPlace;
import ifmo.diploma.model.Employee;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created: 30.10.2007 || 17:32:11
 *
 *
 */
public class EducationHistoryAction extends DispatchAction {
    public ActionForward unspecified(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        EducationHistoryForm form = (EducationHistoryForm) actionForm;

        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
        form.getNewHistoryItem().setEmployee(employee);
        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationHistory(employee.getId()));

        form.setPlaces(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationPlaces());
        form.setTypes(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationTypes());
        return actionMapping.findForward("View");
    }

    public ActionForward addHistoryItem(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        EducationHistoryForm form = (EducationHistoryForm) actionForm;
        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
//        form.getNewHistoryItem().setEmployee(employee);

        FormFile documentFile = form.getDocumentCopy();
        if (!"".equals(documentFile.getFileName())) {
            form.getNewHistoryItem().setDocumentCopyFilename(documentFile.getFileName());
            ApplicationActionServlet.copyFileToServer(String.valueOf(employee.getId()), documentFile);
        }

        if ("on".equals(form.getAddPlace())) {
            Integer newPlaceId = ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().addEducationPlace(new EducationPlace(form.getNewPlaceName()));
            form.getNewHistoryItem().setPlace(new EducationPlace(newPlaceId));
        }
        form.getNewHistoryItem().initDates();
        ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().addEducationHistoryItem(form.getNewHistoryItem());

        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationHistory(employee.getId()));
        form.setPlaces(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationPlaces());
        form.setTypes(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationTypes());
        return actionMapping.findForward("View");
    }

    public ActionForward updateList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        EducationHistoryForm form = (EducationHistoryForm) actionForm;

        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }

        for (EducationHistoryItem historyItem : form.getHistory()) {
            if (historyItem.getDocumentCopy().getFileName() != null) {
                if (!"".equals(historyItem.getDocumentCopy().getFileName())) {
                    ApplicationActionServlet.copyFileToServer(String.valueOf(employee.getId()), historyItem.getDocumentCopy());
                    historyItem.setDocumentCopyFilename(historyItem.getDocumentCopy().getFileName());
                }
            }
        }
        ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().updateEducationList(form.getHistory());

        /*form.getNewHistoryItem().setEmployee(employee);*/
        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationHistory(employee.getId()));
        form.setPlaces(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationPlaces());
        form.setTypes(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeEducationDAO().getEducationTypes());
        return actionMapping.findForward("View");
    }

}

