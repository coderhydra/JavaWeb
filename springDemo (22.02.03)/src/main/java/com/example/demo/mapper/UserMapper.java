package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.User;

@Mapper/*매퍼 어노테이션*/
/*인터페이스이기에 구현 클래스가 필요하지만 
 * 마이바티스가 자동으로 해줌 따라서 인터페이스만 만들면된다!*/
public interface UserMapper 
{
	/*마이바티스 어노테이션*/
   @Insert
   /*JDBC template == ? 를 대신함 셋겟 필요*/
   ("INSERT INTO user VALUES(NULL,#{name},#{phone},#{email})")
   /*리턴되는값 추상매소드*/
   int insertUser(User user);

   /* 행을 추가하고 자동증가필드의 값을 파라미터로 전달된 UserVO 의 num 변수에 저장*/
   @Insert("INSERT INTO user VALUES(NULL,#{name},#{phone},#{email})")
   /*키를 가져올때는 넣어줘야하는 로직
    * 한행을 삽입하고 프라이머리키를 가져온다*/
   @Options(useGeneratedKeys = true, keyProperty = "num")
   int addAndGetKey(User user);

   /*파라미터의 넘을 sql에서 찾아준다. new User 필요 없다.*/
   @Select("SELECT * FROM user WHERE num = #{num}")
   User getUserById( int num);
   
   @Select("SELECT * FROM user WHERE num = #{num} AND name=#{name}")
   User getUser(User user);
   
   /*다수횅을 찾아줌*/
   @Select("SELECT * FROM user")
   List<User> getUserList();

   /*업데이트*/
   @Update("UPDATE user SET phone=#{phone}, email=#{email} "+
         "WHERE num=#{num}")
   int updateUser(User u);
   
   /*삭제*/
   @Delete("DELETE FROM user WHERE num=#{num}")
   int deleteUser( int num);
}