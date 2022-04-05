package music.business;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

public class Invoice implements Serializable {

    private User user;
    private List<LineItem> lineItems;
    private Date invoiceDate;
    private Long invoiceNumber;
    private boolean isProcessed;

    public Invoice() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceDateDefaultFormat() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        String invoiceDateFormatted = dateFormat.format(invoiceDate);
        return invoiceDateFormatted;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public boolean isIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public double getInvoiceTotal() {
        double invoiceTotal = 0.0;
        for (LineItem item : lineItems) {
            invoiceTotal += item.getTotal();
        }
        return invoiceTotal;
    }

    public String getInvoiceTotalCurrencyFormat() {
        double total = this.getInvoiceTotal();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedTotal = currency.format(total);
        return formattedTotal;
    }
}