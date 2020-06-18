package com.example.MessageMemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.Query;

@Repository
//ここでは、エンティティのクラスとエンティティIDのクラス、 CustomerEntity と String を指定します。
public interface MessageMemoRepository extends CrudRepository<MessageMemo, String> {
	
	@Query(value = "SELECT count(M_ID) from T_MESSAGE", nativeQuery = true)
	public int findT_message();
	
}

    


