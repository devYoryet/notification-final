package com.zosh.modal;

import com.zosh.domain.PaymentMethod;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_orders") // nombre explícito para evitar nombres en plural automáticos
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_order_seq")
    @SequenceGenerator(
        name = "payment_order_seq",
        sequenceName = "payment_orders_seq",
        allocationSize = 1
    )
    private Long id;

    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    private String paymentLinkId;

    private Long userId;

    private Long bookingId;

    @Column(nullable = false)
    private Long salonId;
}
