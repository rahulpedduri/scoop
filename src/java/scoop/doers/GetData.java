/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.doers;

import java.sql.SQLException;
import scoop.exception.BeanIncompleteException;

/**
 *
 * @author Rahul
 */
public interface GetData {
    public void fetch()throws SQLException, BeanIncompleteException;

}
