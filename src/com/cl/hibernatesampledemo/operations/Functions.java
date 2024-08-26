package com.cl.hibernatesampledemo.operations;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cl.hibernatesampledemo.entity.HibernateUtil;
import com.cl.hibernatesampledemo.entity.Student;

public class Functions {

	public void insertValues(String name, String email) {
		Transaction transaction = null;
		Session dbSession = null;
		try {
			dbSession = HibernateUtil.getSessionFactory().openSession();
			Student st = new Student();
			st.setStudentName(name);
			st.setStudentEmail(email);
			transaction = dbSession.beginTransaction();
			dbSession.save(st);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void showStudents() {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Student> studentList = session.createQuery("from Student", Student.class).list();
			studentList.stream().forEach(System.out::println);
		}
	}

	public void deleteAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			Query deleteQuery = session.createQuery("delete from Student");
			int rowCount = deleteQuery.executeUpdate();
			if (rowCount != 0) {
				System.out.println("Rows deleted= " + rowCount);
			} else {
				System.out.println("No rows found.");
			}
			tx.commit();
		}
	}

	public void deleteOne(int nid) {
		try (

				Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			int id = nid;
			Query<Student> deleteQuery = session.createQuery("delete from Student where studentId =: id");
			deleteQuery.setInteger("id", id);
			int rowCount = deleteQuery.executeUpdate();
			if (rowCount != 0) {
				System.out.println("Rows deleted = " + rowCount);
			} else {
				System.out.println("No rows found");
			}
			tx.commit();
		}
	}
}
