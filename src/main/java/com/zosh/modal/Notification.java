package com.zosh.modal;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "NOTIFICATION")
@SequenceGenerator(name = "notification_seq",
        sequenceName = "NOTIFICATION_SEQ",
        allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "notification_seq")
    private Long id;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "IS_READ", nullable = false, columnDefinition = "NUMBER(1)")
    private Boolean isRead = false;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @Column(name = "SALON_ID")
    private Long salonId;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
