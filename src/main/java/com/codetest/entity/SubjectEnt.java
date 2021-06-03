package com.codetest.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static com.codetest.entity.SubjectEnt.FIND_ALL_SUBJECTS;
import static com.codetest.entity.SubjectEnt.TABLE_NAME;

@Entity
@Table(name=TABLE_NAME)
@NamedQuery(name = FIND_ALL_SUBJECTS, query = "select s from subjectEnt")
public class SubjectEnt {
	
	public static final String TABLE_NAME = "SUBJECTS";
	public static final String FIND_ALL_SUBJECTS = "subjects.findAll";

	@Id
	@Column(name="SUBJECT_CODE")
	private String subjectCode;
	
	@Column(name="SUBJECT_DESC")
	private String subjectDesc;
	
	@Temporal(TemporalType.DATE)
	@Column(name="WEEK_START_DATE")
	private Date weekStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="WEEK_END_DATE")
	private Date weekEndDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="")
	private Date exactClassDate;
	
	@Column(name="DAY_OF_WEEK")
	private String dateOfWeek;
	
	@Column(name="ROOM_NUMBER")
	private float roomNumber;
	
	@Column(name="ROOM")
	private float room;
	
	@Column(name="GPS_COORDINATES")
	private String gpsCoordinates;
	
	@Temporal(TemporalType.TIME)
	@Column(name="START_TIME")
	private Time startTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name="END_TIME")
	private Time endTime;
	
	@Column(name="CAMPUS_CODE")
	private String campusCode;
	
	@Column(name="HAS_STANDARD_ROOM_DESC")
	private boolean hasStandardRoomDescription;
	
	@Column(name="DURATION")
	private short duration;
	
	@Column(name="DURATION_CODE")
	private Character durationCode;
	
	@Column(name="IS_HOLIDAY")
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
	
	public boolean getHasStandardRoomDescription() {
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
	
}
