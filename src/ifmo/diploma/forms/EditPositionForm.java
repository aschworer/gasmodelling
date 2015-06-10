/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.forms;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.DAO.ConnectionFailedException;
import ifmo.diploma.DAO.GettingDataFailedException;
import ifmo.diploma.model.Employee;
import ifmo.diploma.model.Position;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created: 14.11.2007 || 14:41:47
 *
 *
 */
public class EditPositionForm extends ValidatorForm {
    private String currentPositionID;
    private List<Position> positions;
    private Position currentPosition;

    private Position newPosition;


    public Position getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(Position newPosition) {
        this.newPosition = newPosition;
    }

    private String method;


    public String getCurrentPositionID() {
        return currentPositionID;
    }

    public void setCurrentPositionID(String currentPositionID) {
        this.currentPositionID = currentPositionID;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        currentPosition = new Position();
        currentPosition.setId(0);
        currentPosition.setName("");

        newPosition = new Position();
        newPosition.setId(0);
        newPosition.setName("");
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        ActionErrors errors = super.validate(actionMapping, httpServletRequest);
        try {
            if ("deletePosition".equals(httpServletRequest.getParameter("method"))) {
                for (Employee employee : ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployees()) {
                    if (employee.getCurrentPosition().getId() == Integer.parseInt(currentPositionID)) {
                        ApplicationActionServlet.bindArgumentError(errors, "error",
                                new String[]{"Position cannot be deleted cause it is in use by " + employee.getFullName() + " employee"});
                        return errors;
                    }
                }
            }
            if ("addPosition".equals(httpServletRequest.getParameter("method"))) {
                if (newPosition.getName() == null) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Position name"});
                    return errors;
                } else if (newPosition.getName().length() == 0) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Position name"});
                    return errors;
                }

                if (newPosition.getConditions() == null) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Conditions"});
                    return errors;
                } else if (newPosition.getConditions().length() == 0) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Conditions"});
                    return errors;
                }

                if (newPosition.getRequirements() == null) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Requirements"});
                    return errors;
                } else if (newPosition.getRequirements().length() == 0) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Requirements"});
                    return errors;
                }


                for (Position position : ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getPositions()) {
                    if (position.getName().equals(newPosition.getName())) {
                        ApplicationActionServlet.bindArgumentError(errors, "already.exists",
                                new String[]{"Position with this name"});
                        return errors;
                    }
                }
            }

            if ("updatePosition".equals(httpServletRequest.getParameter("method"))) {
                if (currentPosition.getName() == null) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Position name"});
                    return errors;
                } else if (currentPosition.getName().length() == 0) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Position name"});
                    return errors;
                }

                if (currentPosition.getConditions() == null) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Conditions"});
                    return errors;
                } else if (currentPosition.getConditions().length() == 0) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Conditions"});
                    return errors;
                }

                if (currentPosition.getRequirements() == null) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Requirements"});
                    return errors;
                } else if (currentPosition.getRequirements().length() == 0) {
                    ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED,
                            new String[]{"Requirements"});
                    return errors;
                }


                for (Position position : ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getPositions()) {
                    if (position.getName().equals(currentPosition.getName()) && currentPosition.getId() != position.getId()) {
                        ApplicationActionServlet.bindArgumentError(errors, "already.exists",
                                new String[]{"Position with this name"});
                        return errors;
                    }

                }
            }
        } catch (ConnectionFailedException e) {

        } catch (
                GettingDataFailedException e) {
        }
        return errors;
    }
}

