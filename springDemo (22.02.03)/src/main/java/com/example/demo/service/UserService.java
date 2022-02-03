package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.vo.User;

@Service //서비스 어노테이션
public class UserService {

	private UserDAO dao;
	
	@Autowired 
	public UserService(@Qualifier("mysqlDao") UserDAO dao) {
		/*생성자에서 인터페이스형 객체 
		 *Qualifier(이름) 인터페이스를 구현한 많은 클래스중 하나를 선택하기 쉬움
		 *실행하려면 생성자를 만들어야한다.
		 *이름을 가지고 (컴포넌트)클래스를 찾는 어노테이션 퀄리파이어
		 *의 객체를 dao에 입력 왜냐면 UserDAO가 인터페이스
		 */
		this.dao = dao;
	}
	

	public boolean insert(User u) {
		return dao.insert(u);
	}
	
	public int insertAndGetId(User u) {
		return dao.insertAndGetId(u);
	}
	
	public User read(int num) {
		return dao.select(num);
	}

	public boolean update(User u) {
		return dao.update(u);
	}
	
	public boolean delete(int num) {
		return dao.delete(num);
	}

	public List<User> list(){
		return dao.getList();
	}

}
