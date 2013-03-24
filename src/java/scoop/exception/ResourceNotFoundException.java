/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.exception;

/**
 *
 * @author Rahul
 */
public class ResourceNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ResourceNotFoundException</code> without detail message.
     */
    public ResourceNotFoundException() {
    }


    /**
     * Constructs an instance of <code>ResourceNotFoundException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
