package com.demo.solid.lsp;

class RefundService {
    public void issueRefund(RefundablePaymentProcessor processor, double amount, String account) {
        processor.refund(amount, account);
    }
}

public class LSPMain {
    public static void main(String[] args) {
        RefundService service = new RefundService();

        RefundablePaymentProcessor stripe = new StripeProcessor();
        service.issueRefund(stripe, 150, "acct-001");

        // ❌ This won't compile — and that's good!
        // PaymentProcessor crypto = new CryptoProcessor();
        // service.issueRefund(crypto, 100, "wallet-xyz");
    }
}