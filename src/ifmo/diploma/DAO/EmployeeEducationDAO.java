/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.DAO;

import ifmo.diploma.model.EducationHistoryItem;
import ifmo.diploma.model.EducationPlace;
import ifmo.diploma.model.EducationType;

import java.util.List;

/**
 * Created: 30.10.2007 || 17:38:49
 *
 *
 */
public interface EmployeeEducationDAO {

    public abstract List<EducationHistoryItem> getEducationHistory(int employeeID) throws GettingDataFailedException;

    public abstract Integer addEducationHistoryItem(EducationHistoryItem educationHistoryItem) throws GettingDataFailedException;

    public abstract Integer addEducationPlace(EducationPlace educationPlace) throws GettingDataFailedException;

    public abstract List<EducationPlace> getEducationPlaces() throws GettingDataFailedException;

    public abstract List<EducationType> getEducationTypes() throws GettingDataFailedException;

    public abstract void updateEducationList(List<EducationHistoryItem> list) throws GettingDataFailedException;

}
