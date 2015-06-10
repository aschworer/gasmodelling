/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.DAO;

import ifmo.diploma.model.Department;
import ifmo.diploma.model.DepartmentHistoryItem;

import java.util.List;

/**
 * Created: 24.10.2007 || 16:40:14
 *
 
 */
public interface DepartmentDAO {

    public abstract List<Department> getDepartments() throws GettingDataFailedException;

    public abstract List<DepartmentHistoryItem> getDepartmentHistory(int employeeID) throws GettingDataFailedException;

    public abstract Integer addDepartmentHistoryItem(DepartmentHistoryItem departmentHistoryItem) throws GettingDataFailedException;

    public abstract void updateDepartmentHistoryList(List<DepartmentHistoryItem> list) throws GettingDataFailedException;

    public abstract Integer addDepartment(Department department) throws GettingDataFailedException;

    public abstract void deleteDepartment(int departmentID) throws GettingDataFailedException;

}
