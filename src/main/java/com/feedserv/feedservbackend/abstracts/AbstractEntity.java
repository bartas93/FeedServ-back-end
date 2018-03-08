package com.feedserv.feedservbackend.abstracts;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue
	protected Long id;
	// TODO wersja? dodac gettery i settery + construktor zmienic
	// @Version
	// @Column(columnDefinition = "bigint DEFAULT 0")
	// private long version;

	public AbstractEntity(Long id) {
		this.id = id;
	}

	public AbstractEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// TODO czy dodać tutaj version?

}