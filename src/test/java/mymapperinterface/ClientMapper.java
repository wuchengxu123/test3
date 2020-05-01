package mymapperinterface;

import org.apache.ibatis.annotations.Param;

import com.wuchengxu.test.testdome1.LoginVO;
import com.wuchengxu.test.testdome1.client;

public interface ClientMapper {



	client login1(LoginVO vo);

	client login2(@Param("username")String username,@Param("password")String password);



}
