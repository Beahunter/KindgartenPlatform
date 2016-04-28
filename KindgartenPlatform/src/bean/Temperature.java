package bean;

import java.util.Date;

/**
 * Temperature entity. @author MyEclipse Persistence Tools
 */

public class Temperature implements java.io.Serializable {

	// Fields

	private Long id;
	private Long teacherId;
	private Float temperature;
	private Date date;
	private String remark;
	private Long childId;

	// Constructors

	/** default constructor */
	public Temperature() {
	}

	/** minimal constructor */
	public Temperature(Long teacherId, Float temperature, Long childId) {
		this.teacherId = teacherId;
		this.temperature = temperature;
		this.childId = childId;
	}

	/** full constructor */
	public Temperature(Long teacherId, Float temperature, Date date,
			String remark, Long childId) {
		this.teacherId = teacherId;
		this.temperature = temperature;
		this.date = date;
		this.remark = remark;
		this.childId = childId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public Float getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getChildId() {
		return this.childId;
	}

	public void setChildId(Long childId) {
		this.childId = childId;
	}

}