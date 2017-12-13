
package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clients {
    
    private Long clientsId;
    private String clientsName;
    private String clientsPhone;
    private String clientsMail;
    private List<Orders> orders;

    public Clients() {}
    
    @Id
    @Column(name = "clients_id")
    public Long getClientsId() {
        return clientsId;
    }

    public void setClientsId(Long clientsId) {
        this.clientsId = clientsId;
    }

    @Column(name = "clients_name")
    public String getClientsName() {
        return clientsName;
    }

    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    @Column(name = "clients_phone")
    public String getClientsPhone() {
        return clientsPhone;
    }

    public void setClientsPhone(String clientsPhone) {
        this.clientsPhone = clientsPhone;
    }

    @Column(name = "clients_mail")
    public String getClientsMail() {
        return clientsMail;
    }

    public void setClientsMail(String clientsMail) {
        this.clientsMail = clientsMail;
    }

    @OneToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orderses) {
        this.orders = orderses;
    }

    @Override
    public String toString() {
        return this.clientsName; 
    }
}
