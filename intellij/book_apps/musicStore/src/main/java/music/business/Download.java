package music.business;

import java.io.Serializable;
import java.util.Date;

public class Download implements Serializable {

    private Long downloadId;
    private User user;
    private Date downloadDate;
    private String productCode;

    public Download() {
        user = null;
        downloadDate = new Date();
        productCode = "";
    }

    public Long getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(Long downloadId) {
        this.downloadId = downloadId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date date) {
        downloadDate = date;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}