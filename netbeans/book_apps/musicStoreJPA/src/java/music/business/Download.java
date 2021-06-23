package music.business;

import java.util.Date;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Download implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long downloadId;

    @ManyToOne(fetch=FetchType.EAGER)
    private User user;

    @Temporal(TemporalType.DATE)
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

    public void setUser(User u) {
        user = u;
    }

    public User getUser() {
        return user;
    }

    public void setDownloadDate(Date date) {
        downloadDate = date;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }
}