package com.java.basic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class StudentServiceImpl implements StudentService {

	static SessionFactory sfactory = null;

	public StudentServiceImpl() {
		this.sfactory=HibernateUtil.getSessionFactory();
	}

	@Override
	public String addNewStudent(Student std) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.save(std);
			System.out.println(STUDENT_SUCESS);
			return STUDENT_SUCESS;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(STUDENT_ERROR);
			return STUDENT_ERROR;

		} finally {
			CleanResource.CleanUpResource(session, tr);

		}
	}

	@Override
	public List<Student> listOfStudent() {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			Criteria cr = session.createCriteria(Student.class);
			return cr.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			CleanResource.CleanUpResource(session, tr);

		}
		return null;
	}

	@Override
	public List<Student> searchStudentByCategoryType(CategoriesType type, String val) {

		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();

			Criteria cr = session.createCriteria(Student.class);
			switch (type) {
			case Id:
				cr.add((Restrictions.eq("stdId", Integer.parseInt(val))));
				break;
			case Name:
				cr.add(Restrictions.eq("stdName", val));
				break;
			case Skill:
				cr.add(Restrictions.eq("stdSkill", val));
				break;
			case Fess:
				cr.add(Restrictions.eq("stdFess", Double.parseDouble(val)));
				break;
			case Address:
				cr.add(Restrictions.eq("stdAddress", val));
				break;
			default:
				break;
			}
			return cr.list();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			CleanResource.CleanUpResource(session, tr);

		}
		return null;
	}

	@Override
	public boolean deleteStudentById(int stdId) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			Student stddb = session.get(Student.class, stdId);
			if (stddb != null) {
				session.delete(stddb);
				System.out.println("Studetn deleted..");
				return true;
			}
			System.out.println("No Student found for Given Id.. so Cannot delete Student...");
		} catch (Exception e) {
			System.out.println("cannot delete");

			e.printStackTrace();

		} finally {
			CleanResource.CleanUpResource(session, tr);

		}
		return false;
	}

	@Override
	public Student updateStudent(int stdId, Student std) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();

			Student dbstd = session.get(Student.class, stdId);
			if (dbstd != null) {
				dbstd.setStdName(std.getStdName());
				dbstd.setStdSkill(std.getStdSkill());
				dbstd.setStdAddress(std.getStdAddress());
				dbstd.setStdAge(std.getStdAge());
				dbstd.setStdFees(std.getStdFees());
				dbstd.setStdGendor(std.getStdGendor());
				session.update(dbstd);
				System.out.println("Student updated sucessfully..");
				return dbstd;
			}

		} catch (Exception e) {
			System.out.println("Student cannot be updated....");
			e.printStackTrace();

		} finally {
			CleanResource.CleanUpResource(session, tr);

		}
		return null;
	}

	@Override
	public List<Student> checkRangeStudentFess(double startRange, double endEnd) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			Criteria cr = session.createCriteria(Student.class);
			cr.add(Restrictions.between("stdFess", startRange, endEnd));
			return cr.list();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			CleanResource.CleanUpResource(session, tr);

		}
		return null;
	}

}
