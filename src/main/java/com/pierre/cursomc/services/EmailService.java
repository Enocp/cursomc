package com.pierre.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.pierre.cursomc.domain.Pedido;

public interface EmailService {
  void sendOrderConfirmationEmail(Pedido pedido);
  void sendEmail(SimpleMailMessage msg);
}
