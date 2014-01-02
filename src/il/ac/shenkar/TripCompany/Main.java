package il.ac.shenkar.TripCompany;

import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {	
	public static void main(String [] args){
		
		DAO instance = DAO.getInstance();
		System.out.println("instance="+instance);
	}
}
