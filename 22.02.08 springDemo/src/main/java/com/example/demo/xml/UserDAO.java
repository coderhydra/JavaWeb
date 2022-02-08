package com.example.demo.xml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Repository
public class UserDAO 
{
	@Autowired
	private UserXMLMapper userMapper;

	public int insert(User u) {
		return userMapper.insertUser(u);
	}
	
    public int addAndGetKey(User u) {
        return userMapper.addAndGetKey(u);
    }
	public User selectById(int num) {
		return userMapper.getUserById(num);
    }
	
	public List<User> getUserList() {
		return userMapper.getUserList();
    }

	public int update(User u) {
		return userMapper.updateUser(u);
	}
	
	public int delete(int num) {
		return userMapper.deleteUser(num);
	}
	
	public User findWithoutId(User user) {
		return userMapper.findWithoutId(user);
	}

  /** Open Source, MyBatis PageHelper 사용 예
   * @param int pageNum : 추출하고자 하는 목록의 페이지 번호
   * @param int pageSize : 한 페이지(화면)에 보여줄 목록의 아이템 수
   * @return PageInfo : 목록의 한 페이지 아이템들과 페이징 관련 정보를 저장한 객체
   */
	/*
	//PageHelper 페이지 를 넣어주는 클래스
	//다오위치
	 * 리스트를 받아온다음 페이지 정보를 추가 그담 jsp로....
	 * 1.마이바티스에서 리스트를 받는다.
	 * 2. 페이지 인포를 추가한다.
	 * 	1.몇페이지인가? int pageNum
	 * 	2.한페이지에 몇개를 보여줄 것인가? int pageSize
	 * 3. 리턴한다.
	 * 스타트 페이지 는 페이지 넘버와 페이지 사이즈 
	*/
  public PageInfo<User> getUserListPage(int pageNum, int pageSize){
     PageHelper.startPage(pageNum, pageSize);
     PageInfo<User> pageInfo = new PageInfo<>( userMapper.getUserList());
     return pageInfo;
  }

}
