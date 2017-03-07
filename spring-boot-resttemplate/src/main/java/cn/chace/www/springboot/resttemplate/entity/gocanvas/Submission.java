package cn.chace.www.springboot.resttemplate.entity.gocanvas;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Model类：提交记录
 *
 * @author chenx
 * @date 2017/3/6
 */
@XStreamAlias("Submission")
public class Submission {
    @XStreamAlias("Form")
    private Form form;

    @XStreamAlias("Date")
    private String date;

    @XStreamAlias("DeviceDate")
    private String deviceDate;

    @XStreamAlias("UserName")
    private String userName;

    @XStreamAlias("FirstName")
    private String firstName;

    @XStreamAlias("LastName")
    private String lastName;

    @XStreamAlias("ResponseID")
    private String responseId;

    @XStreamAlias("WebAccessToken")
    private String webAccessToken;

    @XStreamAlias("Sections")
    private List<Section> sections;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(String deviceDate) {
        this.deviceDate = deviceDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getWebAccessToken() {
        return webAccessToken;
    }

    public void setWebAccessToken(String webAccessToken) {
        this.webAccessToken = webAccessToken;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "form=" + form +
                ", date='" + date + '\'' +
                ", deviceDate='" + deviceDate + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", responseId='" + responseId + '\'' +
                ", webAccessToken='" + webAccessToken + '\'' +
                ", sections=" + sections +
                '}';
    }
}
