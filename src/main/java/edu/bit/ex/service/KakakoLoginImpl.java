package edu.bit.ex.service;

import org.springframework.stereotype.Service;


@Service
public class KakakoLoginImpl implements LoginService {

	@Override
	public void login() {
		System.out.println("카카오 로그인 완료");		
	}


}