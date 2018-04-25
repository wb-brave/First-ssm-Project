package cn.wb.ssm.entity;

public class User {
    private Integer userId;

    private String userLogin;

    private String userName;

    private String userPass;

    private String userPhone;

    private String userAddress;

    private String userRemark;

    private String userType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userLogin=" + userLogin + ", userName=" + userName + ", userPass="
				+ userPass + ", userPhone=" + userPhone + ", userAddress=" + userAddress + ", userRemark=" + userRemark
				+ ", userType=" + userType + "]";
	}
    
    
}