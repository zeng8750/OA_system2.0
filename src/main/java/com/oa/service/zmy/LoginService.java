package com.oa.service.zmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oa.dao.jpa.IOaEmpDao;
import com.oa.dao.jpa.IOaPassWordDao;
import com.oa.pojos.OaEmp;
import com.oa.pojos.OaPassword;

@Service
public class LoginService {

	@Autowired
	IOaEmpDao eDao;
	@Autowired
	IOaPassWordDao pDao;
	
	public OaEmp vaildatorLogin(String userName,String password){
		OaEmp emp = eDao.findOne(userName);
		if (emp==null) {
			return null;
		}
		OaPassword dbpassword = pDao.findOne(userName);
		if(password.equals(dbpassword.getPaPass())){
			return emp;
		}
		return null;
	}
}
