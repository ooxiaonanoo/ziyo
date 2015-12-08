package com.wrc.ziyo.service.customer;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.customer.CustomerDao;
import com.wrc.ziyo.pojo.Customer;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("customerService")
public class CustomerService extends BaseService<Customer> {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public void save(Customer t) throws Exception {
		this.customerDao.save(t);
	}

	@Override
	public List<Customer> findByExample(Customer t, int offset, int size)
			throws Exception {
		return this.customerDao.findByExample(t, offset, size);
	}

	@Override
	public Customer get(Serializable id) throws Exception {
		return this.customerDao.get(id);
	}

	@Override
	public void update(Customer t) throws Exception {
		this.customerDao.update(t);
	}

	public List<Object[]> findBySql(String sql, Object object) {
		return this.customerDao.findBySql(sql, object);
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
