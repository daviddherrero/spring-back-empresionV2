package tfg.backend.empresion.dto;

import java.util.Date;

public class OrderDTO {

    private String orderOwner;
    private String status;
    private Date created_at;
    private Date completed_at;

    public OrderDTO(String name, String status, Date completed_at, Date created_at) {
        this.orderOwner = name;
        this.status = status;
        this.completed_at = completed_at;
        this.created_at = created_at;
    }

    public String getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(String orderOwner) {
        this.orderOwner = orderOwner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Date completed_at) {
        this.completed_at = completed_at;
    }
}
