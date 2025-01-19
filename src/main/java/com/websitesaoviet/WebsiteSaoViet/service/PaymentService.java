package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.PaymentCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.PaymentUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.PaymentResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Payment;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.mapper.PaymentMapper;
import com.websitesaoviet.WebsiteSaoViet.repository.PaymentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentService {
    PaymentRepository paymentRepository;
    PaymentMapper paymentMapper;

    public PaymentResponse createPayment(PaymentCreationRequest request) {
        Payment payment = paymentMapper.createPayment(request);

        return paymentMapper.toPaymentResponse(paymentRepository.save(payment));
    }

    public List<PaymentResponse> getPayments() {
        return paymentMapper.toListPaymentsResponse(paymentRepository.findAll());
    }

    public PaymentResponse getPaymentById(String id) {
        return  paymentMapper.toPaymentResponse(paymentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_NOT_EXITED)));
    }

    public PaymentResponse updatePayment(String id, PaymentUpdateRequest request) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PAYMENT_NOT_EXITED));

        if (payment == null) {
            throw new AppException(ErrorCode.PAYMENT_NOT_EXITED);
        }

        return paymentMapper.toPaymentResponse(paymentRepository.save(payment));
    }
}