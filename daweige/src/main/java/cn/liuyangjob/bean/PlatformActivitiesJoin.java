package cn.liuyangjob.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户参加活动记录表
 */
@Entity
@Table(name="active_join")
public class PlatformActivitiesJoin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "active_id")
	private Long platformActivitiesId;//活动Id
	@JoinColumn(name = "user_id")
	private Long userId;//用户Id
	private Date addTime;//参加活动的时间
	@JoinColumn(name = "state")
	private Integer state;//状态  0  已参加  1 正在审核 2取消参加
	@JoinColumn(name = "gift")
	private String gift;//手机账号
	@JoinColumn(name = "nickname")
	private String nickname;// 用户昵称
	@Column(name = "mobile")
	private String mobile;
	@JoinColumn(name = "province_id")
	private Long provinceId;//省id
	@JoinColumn(name = "city_id")
	private Long cityId;//市id
	@JoinColumn(name = "town_id")
	private Long townId;//区id
	@JoinColumn(name = "address")
	private String address;//详细地址
	@JoinColumn(name = "describe")
	private String describe;//参赛宣言描述
	@JoinColumn(name = "imgsrcs")
	private String imgsrcs;//图片地址字段#拼接
	@JoinColumn(name = "albumcover")
	private String albumcover;//封面图片地址
	@JoinColumn(name = "index")
	private Long index;//序号
	@JoinColumn(name = "source_code")
	private String source_code;//报名渠道号

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlatformActivitiesId() {
		return platformActivitiesId;
	}

	public void setPlatformActivitiesId(Long platformActivitiesId) {
		this.platformActivitiesId = platformActivitiesId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getImgsrcs() {
		return imgsrcs;
	}

	public void setImgsrcs(String imgsrcs) {
		this.imgsrcs = imgsrcs;
	}

	public String getAlbumcover() {
		return albumcover;
	}

	public void setAlbumcover(String albumcover) {
		this.albumcover = albumcover;
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}


	public String getSource_code() {
		return source_code;
	}

	public void setSource_code(String source_code) {
		this.source_code = source_code;
	}


}