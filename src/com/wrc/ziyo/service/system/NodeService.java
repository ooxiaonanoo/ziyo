package com.wrc.ziyo.service.system;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wrc.ziyo.dao.system.NodeDao;
import com.wrc.ziyo.pojo.Node;
import com.wrc.ziyo.service.BaseService;

@Service
@Component("nodeService")
public class NodeService extends BaseService<Node> {

	@Autowired
	private NodeDao nodeDao;

	@Override
	public Node get(Serializable id) throws Exception {
		return this.nodeDao.get(id);
	}
	
	@Override
	public List<Node> findByExample(Node t, int offset, int size)
			throws Exception {
		return this.nodeDao.findByExample(t, offset, size);
	}
	
	@Override
	public List<Node> findAll() throws Exception {
		return this.nodeDao.findAll();
	}
	
	@Override
	public void save(Node t) throws Exception {
		this.nodeDao.save(t);
	}
	
	@Override
	public void update(Node t) throws Exception {
		this.nodeDao.update(t);
	}
	
	public NodeDao getNodeDao() {
		return this.nodeDao;
	}

	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}
}
