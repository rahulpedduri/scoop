/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.tags;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Rahul
 */
public class Fetch extends SimpleTagSupport {
    private String className;
    private Object instance;

    /**
     * Called by the container to invoke this tag. 
     * The implementation of this method is provided by the tag library developer,
     * and handles all tag processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
       
       
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

}
