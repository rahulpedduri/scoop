/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.data;

import scoop.doers.GetComments;
import scoop.doers.GetCategoryMenu;
import scoop.doers.GetPermissions;
import scoop.database.ConnectionParameters;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scoop.doers.GetArticle;
import scoop.doers.GetUser;
import scoop.exception.BeanIncompleteException;

/**
 *
 * @author Rahul
 */
public class NewBean{
    public static void main(String a[]){
        ConnectionParameters cp= new ConnectionParameters("jdbc:mysql://localhost:3306/", "scoop", "com.mysql.jdbc.Driver", "root", "","?zeroDateTimeBehavior=convertToNull");
        User one=null;
        
            try {
                one = new GetUser("kiran", cp).getUser();
            } catch (SQLException ex) {
                Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BeanIncompleteException ex) {
                Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        System.out.println(one.toString());
       
        System.out.println("----------------------------------------------");
        Article two=null;
        try {
            two = new GetArticle("1", cp).getArticle();
        } catch (Exception ex) {
            Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception for two"+ex);
        }
       
       
        System.out.println(two);
        System.out.println("--------------------------------------------");
        
        GetComments comm=null;
        try {
            try {
                comm = new GetComments(two.getArticle_id(), cp);
            } catch (BeanIncompleteException ex) {
                Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception for comm"+ex);
        }
         System.out.println(comm);
        List list=comm.getList();
//        for(int i=0; i<list.size();i++){
//            System.out.println(list.elementAt(i).toString(Comment.ALL));
//        }
        System.out.println("--------------------------------------------");
        GetCategoryMenu items=null;
       
       
            try {
                items = new GetCategoryMenu(cp);
            } catch (SQLException ex) {
                Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex);

            } catch (BeanIncompleteException ex) {
            try {
                Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(items);
                GetPermissions p = new GetPermissions();
                p.setCp(cp);
                p.setUsername("rahuldon74");
                try {
                    p.fetch();
                } catch (SQLException ex1) {
                    Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex1);
                } catch (BeanIncompleteException ex1) {
                    Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex1);
                }
                //            HashMap<Object, Permission> h= p.getList();
                //            Permission perm=h.get("article_edit");
                //            System.out.println("..: "+ h);
                //            HashMap<Object, Permission> h= p.getList();
                //            Permission perm=h.get("article_edit");
                //            System.out.println("..: "+ h);
                System.out.println("------jhjhjhjh------------------------------------");
                GetPermissions g = new GetPermissions();
                g.setUsername("rahuldon74");
                g.setCp(cp);
                g.fetch();
                System.out.println(g.getHeader());
                //         try{
                ////   // String data= Resource.getResourceForHTML("http://localhost:8084/scoop_2/css/demo.css","text/html","abc","132");
                ////        String data= Resource.getResourceForHTML("C:\\Dropbox\\Dropbox\\scoop.in\\scoop trials\\scoop 2\\web\\css\\demo.css","text/html","abc","132");
                //
                //    System.out.println(data);
                //    }catch(Exception e){
                //             System.out.println("error in gettin file^");
                //             e.printStackTrace();
                //    }
                //
                //
            } catch (SQLException ex1) {
                Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (BeanIncompleteException ex1) {
                Logger.getLogger(NewBean.class.getName()).log(Level.SEVERE, null, ex1);
            }
       
    }

      
    }
}

