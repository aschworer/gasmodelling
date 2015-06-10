/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.DAO;

import ifmo.diploma.model.Position;
import ifmo.diploma.model.PositionHistoryItem;
import ifmo.diploma.model.UserGroup;

import java.util.List;

/**
 * Created: 24.10.2007 || 16:40:06
 *
 *
 */
public interface PositionDAO {

    public abstract List<Position> getPositions() throws GettingDataFailedException;

    public abstract List<UserGroup> getAllGroups() throws GettingDataFailedException;

    public abstract List<Position> getVacancies() throws GettingDataFailedException;

    public abstract List<PositionHistoryItem> getPositionHistory(int employeeID) throws GettingDataFailedException;

    public abstract Integer addPositionHistoryItem(PositionHistoryItem positionHistoryItem) throws GettingDataFailedException;

    public abstract void updatePositionHistoryList(List<PositionHistoryItem> list) throws GettingDataFailedException;

    public abstract Integer addPosition(Position position) throws GettingDataFailedException;

    public abstract void deletePosition(int positionID) throws GettingDataFailedException;

    public abstract void updatePosition(Position position) throws GettingDataFailedException;

}
