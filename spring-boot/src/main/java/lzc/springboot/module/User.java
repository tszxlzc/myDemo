package lzc.springboot.module;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzongchang
 * @create 2018-10-19 9:53
 **/
@Component
@ConfigurationProperties(prefix = "user")
public class User {

	@Value("${name:lzc}")
	private String name;

	@Value(("${age}"))
	private Integer age;

	@Value(("${remark}"))
	private String remark;

	private String address;

	private Address detailAddress;

	private List<Address> allAddress = new ArrayList<Address>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(Address detailAddress) {
		this.detailAddress = detailAddress;
	}

	public List<Address> getAllAddress() {
		return allAddress;
	}

	public void setAllAddress(List<Address> allAddress) {
		this.allAddress = allAddress;
	}

	@Override public String toString() {
		return "User{" + "name='" + name + '\'' + ", age=" + age + ", remark='" + remark + '\'' + ", address='"
				+ address + '\'' + ", detailAddress=" + detailAddress + ", allAddress=" + allAddress + '}';
	}
}
