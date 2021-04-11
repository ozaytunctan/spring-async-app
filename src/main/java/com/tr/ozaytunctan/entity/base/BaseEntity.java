package com.tr.ozaytunctan.entity.base;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<ID> implements Serializable {

	@Id
	@GeneratedValue(generator = "idGenerator",strategy = GenerationType.SEQUENCE)
	private ID id;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3917020416875030587L;

	public BaseEntity() {
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

}
