package com.test.spring.aop.real.filter;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

	public Account getAccount(int id) {
		if (id == 42) {
			return new Account("Eberhard", "Wolff", 42);
		} else {
			return new Account("Juergen", "Hoeller", id);
		}
	}

}
