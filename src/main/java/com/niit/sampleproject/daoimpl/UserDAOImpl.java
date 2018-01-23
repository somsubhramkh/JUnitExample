package com.niit.sampleproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.sampleproject.dao.UserDAO;
import com.niit.sampleproject.model.User;

@Repository("UserDAOImpl")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public List<User> list() {
		
		return getCurrentSession().createQuery("from User").list();
	}

	public User get(String username) {
		return (User)getCurrentSession().createQuery("from User where username='"+username+"'").uniqueResult();
	}

	public boolean save(User user) {
		
		getCurrentSession().save(user);
		getCurrentSession().flush();
		return true;
	}

	public boolean updateUser(User user) {
		getCurrentSession().update(user);
		getCurrentSession().flush();
		return true;
	}

	public boolean delete(User user) {
		getCurrentSession().delete(user);
		getCurrentSession().flush();
		return true;
	}
	
}
