package edu.bit.ex.service
;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.ex.vo.EmpVO;


public interface EmpService {	
	public List<EmpVO> list();

}