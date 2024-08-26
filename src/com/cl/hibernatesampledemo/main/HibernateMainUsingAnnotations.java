package com.cl.hibernatesampledemo.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cl.hibernatesampledemo.operations.Operations;

public class HibernateMainUsingAnnotations {
	public static void main(String[] args) {
		
		Operations op = new Operations();
		op.BladeRunner();
	}

	

	
}
