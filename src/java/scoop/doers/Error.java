/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.doers;

import java.util.ArrayList;

/**
 *
 * @author Rahul
 */
public class Error {

    public Error() {
        errors = new ArrayList();
    }
    public boolean merge(ArrayList ob){
        boolean result=this.errors.addAll(ob);
        ob=null;
        return result;
    }

    public boolean merge(ArrayList ob1, ArrayList ob2){
        return (merge(ob1) && merge(ob2));
    }

    public boolean add(String key){
        return errors.add(key);
    }

    public ArrayList getErrors() {
        return errors;
    }
    private ArrayList errors;
}
