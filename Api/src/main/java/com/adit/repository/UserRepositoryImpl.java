package com.adit.repository;

import com.adit.entity.User;
import com.adit.util.CastListElements;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(User user) {
		getSession().saveOrUpdate(user);
	}

	@Override
	public void delete(long id) {
		getSession().delete(getById(id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Criteria criteria = getSession().createCriteria(User.class);
		return CastListElements.castList(User.class, criteria.list());
	}

	@Override
	public User getById(long id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User) criteria.uniqueResult();
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void update(User user) {
		getSession().update(user);
		return;
	}

}
