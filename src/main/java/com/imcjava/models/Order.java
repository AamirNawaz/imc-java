package com.imcjava.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "imc_orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customerId;

    @OneToMany(mappedBy = "imcOrder", cascade = CascadeType.ALL)
    private List<ServiceModel> services = new ArrayList<>();

    private Integer orderQty;
    private Boolean orderStatus;
    private Integer amount;
    private Boolean isPaid;
    private String paymentMode;
    private Boolean isDeleted;
    private Integer contact;
    private String address;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
