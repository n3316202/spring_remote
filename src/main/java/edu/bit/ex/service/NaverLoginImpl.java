package edu.bit.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.ex.dao.EmpDao;
import edu.bit.ex.vo.EmpVO;

@Service
public class NaverLoginImpl implements LoginService {

	@Override
	public void login() {
		System.out.println("네이버 로그인 완료");		
	}


}