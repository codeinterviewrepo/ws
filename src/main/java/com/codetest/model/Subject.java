package com.codetest.model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import com.codetest.entity.SubjectEnt;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject {
	
	@JsonProperty("subject_code")
	private String subjectCode;
	
	@JsonProperty("subject_desc")
	private String subjectDesc;
	
	@JsonProperty("week_start_date")
	private Date weekStartDate;
	
	@JsonProperty("week_end_date")
	private Date weekEndDate;
	
	@JsonProperty("exact_class_date")
	private Date exactClassDate;
	
	@JsonProperty("day_of_week")
	private String dateOfWeek;
	
	@JsonProperty("room_number")
	private Double roomNumber;
	
	@JsonProperty("room")
	private Double room;
	
	@JsonProperty("gps_coordinates")
	private String gpsCoordinates;
	
	@JsonProperty("start_time")
	private String startTime;
	
	@JsonProperty("end_time")
	private String endTime;
	
	@JsonProperty("campus_code")
	private String campusCode;
	
	@JsonProperty("hasStandardRoomDescription")
	private Boolean hasStandardRoomDescription;
	
	@JsonProperty("duration")
	private Short duration;
	
	@JsonProperty("duration_code")
	private Character durationCode;
	
	@JsonProperty("isHoliday")
	private Boolean isHoliday;
	
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
	
	public Double getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Double roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Double getRoom() {
		return room;
	}
	
	public void setRoom(Double room) {
		this.room = room;
	}
	
	public String getGpsCoordinates() {
		return gpsCoordinates;
	}
	
	public void setGpsCoordinates(String gpsCoordinates) {
		this.gpsCoordinates = gpsCoordinates;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getCampusCode() {
		return campusCode;
	}
	
	public void setCampusCode(String campusCode) {
		this.campusCode = campusCode;
	}
	
	public Boolean isHasStandardRoomDescription() {
		return hasStandardRoomDescription;
	}
	
	public void setHasStandardRoomDescription(Boolean hasStandardRoomDescription) {
		this.hasStandardRoomDescription = hasStandardRoomDescription;
	}
	
	public Short getDuration() {
		return duration;
	}
	
	public void setDuration(Short duration) {
		this.duration = duration;
	}
	
	public Character getDurationCode() {
		return durationCode;
	}
	
	public void setDurationCode(Character durationCode) {
		this.durationCode = durationCode;
	}
	
	public Boolean isHoliday() {
		return isHoliday;
	}
	
	public void setHoliday(Boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	
	public static Subject fromSubjectEnt(SubjectEnt sEnt) {
		Subject s = new Subject();
		s.setCampusCode(sEnt.getCampusCode());
		s.setDateOfWeek(sEnt.getDateOfWeek());
		s.setDuration(sEnt.getDuration());
		s.setDurationCode(sEnt.getDurationCode());
		s.setEndTime(sEnt.getEndTime().toString());
		s.setExactClassDate(sEnt.getExactClassDate());
		s.setGpsCoordinates(sEnt.getGpsCoordinates());
		s.setHasStandardRoomDescription(sEnt.getHasStandardRoomDescription());
		s.setHoliday(sEnt.isHoliday());
		s.setRoom(sEnt.getRoom());
		s.setRoomNumber(sEnt.getRoomNumber());
		s.setStartTime(sEnt.getStartTime().toString());
		s.setSubjectCode(sEnt.getSubjectCode());
		s.setSubjectDesc(sEnt.getSubjectDesc());
		s.setWeekEndDate(sEnt.getWeekEndDate());
		s.setWeekStartDate(sEnt.getWeekStartDate());
		return s;
	}
	
	public SubjectEnt toSubjectEnt() {
		SubjectEnt sEnt = new SubjectEnt();
		this.mapFields(sEnt);
		return sEnt;
	}
	
	public void mapFields(SubjectEnt sEnt) {
		sEnt.setCampusCode(this.campusCode);
		sEnt.setDateOfWeek(this.dateOfWeek);
		sEnt.setDuration(this.duration);
		sEnt.setDurationCode(this.durationCode);
		sEnt.setEndTime(Time.valueOf(LocalTime.parse(startTime)));
		sEnt.setExactClassDate(exactClassDate);
		sEnt.setGpsCoordinates(gpsCoordinates);
		sEnt.setHasStandardRoomDescription(hasStandardRoomDescription);
		sEnt.setHoliday(isHoliday);
		sEnt.setRoom(room);
		sEnt.setRoomNumber(roomNumber);
		sEnt.setStartTime(Time.valueOf(LocalTime.parse(startTime)));
		sEnt.setSubjectCode(subjectCode);
		sEnt.setSubjectDesc(subjectDesc);
		sEnt.setWeekEndDate(weekEndDate);
		sEnt.setWeekStartDate(weekStartDate);
	}
	
}
