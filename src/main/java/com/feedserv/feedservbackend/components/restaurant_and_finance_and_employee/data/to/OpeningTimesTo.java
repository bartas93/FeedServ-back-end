package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to;

import java.time.LocalTime;

import com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.enums.DayOfWeek;

public class OpeningTimesTo {
	private Long id;
	private DayOfWeek dayOfWeek;
	private LocalTime openFrom;
	private LocalTime openTo;

	public OpeningTimesTo() {
	}

	public OpeningTimesTo(Long id, DayOfWeek dayOfWeek, LocalTime openFrom, LocalTime openTo) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.openFrom = openFrom;
		this.openTo = openTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getOpenFrom() {
		return openFrom;
	}

	public void setOpenFrom(LocalTime openFrom) {
		this.openFrom = openFrom;
	}

	public LocalTime getOpenTo() {
		return openTo;
	}

	public void setOpenTo(LocalTime openTo) {
		this.openTo = openTo;
	}

}
