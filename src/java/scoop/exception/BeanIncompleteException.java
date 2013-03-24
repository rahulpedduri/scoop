/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.exception;

/**
 *
 * @author Rahul
 */
public class BeanIncompleteException extends Exception {

    /**
     * Creates a new instance of <code>BeanIncompleteException</code> without detail message.
     */
    public BeanIncompleteException() {
    }

    /**
     * Constructs an instance of <code>BeanIncompleteException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BeanIncompleteException(String msg) {
        super(msg);
    }
}
