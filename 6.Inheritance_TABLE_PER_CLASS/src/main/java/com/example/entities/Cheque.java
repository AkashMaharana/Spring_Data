package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bankcheck")
public class Cheque extends Payment{

	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

}
