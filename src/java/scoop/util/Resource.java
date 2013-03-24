/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoop.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;

/**
 *
 * This class should take care of the activities like fetching a resource after
 * verifying the type of the resource. So that regardless of th type of resource, it can be fetched
 * @author Rahul
 */
public class Resource {

    /*
     * this method identifies resource type and renders that resouce for view
     * in HTML. It just returns the string of type 'text/html' that can be directly
     * printed on a web page. This function ensures that you needn't worry about
     * rendering the resource differently for every different resource type. This
     * method is static because it need not have any persistance.
     */
    public static String getResourceForHTML(String resource, String resource_type, String style_class, String id) throws Exception {
        String output = "";
        
        if (resource_type.equalsIgnoreCase("image")) {
            output += "<img src=\"" + resource + "\" "
                    + "class=\"" + style_class + "\""
                    + "id=\"" + id + "\"/>";
        } 
        return output;
    }
}
