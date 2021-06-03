package com.codetest.model;

import java.sql.Time;
import java.util.Date;

import com.codetest.entity.SubjectEnt;

public class Subject {

	private String subjectCode;
	private String subjectDesc;
	private Date weekStartDate;
	private Date weekEndDate;
	private Date exactClassDate;
	private String dateOfWeek;
	private float roomNumber;
	private float room;
	private String gpsCoordinates;
	private Time startTime;
	private Time endTime;
	private String campusCode;
	private boolean hasStandardRoomDescription;
	private short duration;
	private Character durationCode;
	private boolean isHoliday;
	
	public String getSubjectCode() {
		return subjectCode;
	}
	
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	public String getSubjectDesc() {
		return subjectDesc;
	}
	
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	
	public Date getWeekStartDate() {
		return weekStartDate;
	}
	
	public void setWeekStartDate(Date weekStartDate) {
		this.weekStartDate = weekStartDate;
	}
	
	public Date getWeekEndDate() {
		return weekEndDate;
	}
	
	public void setWeekEndDate(Date weekEndDate) {
		this.weekEndDate = weekEndDate;
	}
	
	public Date getExactClassDate() {
		return exactClassDate;
	}
	
	public void setExactClassDate(Date exactClassDate) {
		this.exactClassDate = exactClassDate;
	}
	
	public String getDateOfWeek() {
		return dateOfWeek;
	}
	
	public void setDateOfWeek(String dateOfWeek) {
		this.dateOfWeek = dateOfWeek;
	}
	
	public float getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(float roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public float getRoom() {
		return room;
	}
	
	public void setRoom(float room) {
		this.room = room;
	}
	
	public String getGpsCoordinates() {
		return gpsCoordinates;
	}
	
	public void setGpsCoordinates(String gpsCoordinates) {
		this.gpsCoordinates = gpsCoordinates;
	}
	
	public Time getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	
	public Time getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	public String getCampusCode() {
		return campusCode;
	}
	
	public void setCampusCode(String campusCode) {
		this.campusCode = campusCode;
	}
	
	public boolean isHasStandardRoomDescription() {
		return hasStandardRoomDescription;
	}
	
	public void setHasStandardRoomDescription(boolean hasStandardRoomDescription) {
		this.hasStandardRoomDescription = hasStandardRoomDescription;
	}
	
	public short getDuration() {
		return duration;
	}
	
	public void setDuration(short duration) {
		this.duration = duration;
	}
	
	public Character getDurationCode() {
		return durationCode;
	}
	
	public void setDurationCode(Character durationCode) {
		this.durationCode = durationCode;
	}
	
	public boolean isHoliday() {
		return isHoliday;
	}
	
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	
	public static Subject fromSubjectEnt(SubjectEnt sEnt) {
		Subject s = new Subject();
		s.setCampusCode(sEnt.getCampusCode());
		s.setDateOfWeek(sEnt.getDateOfWeek());
		s.setDuration(sEnt.getDuration());
		s.setDurationCode(sEnt.getDurationCode());
		s.setEndTime(sEnt.getEndTime());
		s.setExactClassDate(sEnt.getExactClassDate());
		s.setGpsCoordinates(sEnt.getGpsCoordinates());
		s.setHasStandardRoomDescription(sEnt.getHasStandardRoomDescription());
		s.setHoliday(sEnt.isHoliday());
		s.setRoom(sEnt.getRoom());
		s.setRoomNumber(sEnt.getRoomNumber());
		s.setStartTime(sEnt.getStartTime());
		s.setSubjectCode(sEnt.getSubjectCode());
		s.setSubjectDesc(sEnt.getSubjectDesc());
		s.setWeekEndDate(sEnt.getWeekEndDate());
		s.setWeekStartDate(sEnt.getWeekStartDate());
		return s;
	}
	
}
