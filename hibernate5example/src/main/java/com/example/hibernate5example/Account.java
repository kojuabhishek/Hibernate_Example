package com.example.hibernate5example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accounts")



public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	long id;
	@Column(name="account_number")
	long accountNo;
	@Column(name="account_holders_name")
	String accountHoldersName;
	@Column(name="cash_balance")
	float balance;
	
	
	public Account(long accountNo, String accountHoldersName, float balance) {
		super();
		this.accountNo = accountNo;
		this.accountHoldersName = accountHoldersName;
		this.balance = balance;
	}

	
	
}
