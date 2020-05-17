package com.act4new.backend.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.act4new.backend.model.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.model.StripeObject;
import com.stripe.net.StripeResponse;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CheckoutController {

	@Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
 
	@RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", "pk_test_4ktQ8UJ0RkFjckEX8Ag4i7hu00BUMtFlcv");
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}
