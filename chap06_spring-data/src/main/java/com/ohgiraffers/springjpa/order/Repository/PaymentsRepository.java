package com.ohgiraffers.springjpa.order.Repository;

import com.ohgiraffers.springjpa.order.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {
    
}
