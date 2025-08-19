# SOLID Principles in Fintech: A Java Case Study

SOLID principles are a set of design principles that help developers create maintainable, scalable, and robust software. They are particularly important in the fintech industry, where software must be reliable, secure, and adaptable to changing regulations and technologies.

The SOLID acronym stands for:
- **S**ingle Responsibility Principle (SRP)
- **O**pen/Closed Principle (OCP)
- **L**iskov Substitution Principle (LSP)
- **I**nterface Segregation Principle (ISP)
- **D**ependency Inversion Principle (DIP)

These principles guide developers in creating software that is easy to understand, modify, and extend. By adhering to these principles, developers can reduce the risk of introducing bugs, improve code readability, and enhance collaboration among team members.
In the fintech domain, where software must handle sensitive financial data and comply with strict regulations, applying SOLID principles is crucial. They help ensure that the software is not only functional but also secure, maintainable, and adaptable to future changes.
This guide provides a practical example of how to apply the SOLID principles in a fintech context, specifically in a payment processing system. By following these principles, developers can create software that is not only efficient but also robust and secure, meeting the high standards required in the fintech industry.



---

## 🔧 Overview

We refactor a `com.demo.work.SmartPaymentSystem` class that originally:

- Handles multiple responsibilities (logging, notifying, fraud checking)
- Hardcodes business logic (risk evaluation, credit score)
- Couples high- and low-level modules

Each section below focuses on a specific SOLID principle, showing:

- 🔴 **Violations** in the original implementation
- ✅ **Refactor** to apply the principle

---

## 1. S — Single Responsibility Principle (SRP)

> A class should have one and only one reason to change.

### 🔴 Before SRP

```java
public boolean process(String paymentType, double amount, String account, String userId) {
    // Logging
    System.out.println("Logging to file: " + paymentType + " of $" + amount + " for " + account);
    // Notify
    System.out.println("Notification sent to " + account);
    // Fraud Check
    if (amount > 10000) {
        System.out.println("Fraud Alert: High value transaction");
    }
}
```

### ✅ After SRP

```java
class TransactionLogger {
    public void log(String paymentType, double amount, String account) {
        System.out.println("Logging to file: " + paymentType + " of $" + amount + " for " + account);
    }
}

class PaymentNotifier {
    public void notify(String account, double amount) {
        System.out.println("Notification sent to " + account + " for $" + amount);
    }
}

class BasicFraudChecker {
    public void check(double amount) {
        if (amount > 10000) {
            System.out.println("Fraud Alert: High value transaction");
        }
    }
}
```

---

## 2. O — Open/Closed Principle (OCP)

> Software entities should be open for extension but closed for modification.

### 🔴 Before OCP

```java
if ("transfer".equals(paymentType)) {
    riskOk = amount < 5000;
} else if ("loan".equals(paymentType)) {
    riskOk = amount < 20000;
}
```

### ✅ After OCP

```java
interface RiskRule {
    boolean isAllowed(double amount);
}

class TransferRiskRule implements RiskRule {
    public boolean isAllowed(double amount) {
        return amount < 5000;
    }
}

class LoanRiskRule implements RiskRule {
    public boolean isAllowed(double amount) {
        return amount < 20000;
    }
}
```

---

## 3. L — Liskov Substitution Principle (LSP)

> Subtypes must be substitutable for their base types.

LSP is preserved by ensuring consistent behavior in subclasses/interfaces. For instance, `TransferRiskRule` and `LoanRiskRule` can be used interchangeably via `RiskRule`.

---

## 4. I — Interface Segregation Principle (ISP)

> Clients should not be forced to depend on interfaces they do not use.

Though not explicit in the “before” code, the `com.demo.work.SmartPaymentSystem` class tried to do too much. We resolved this in the “after” code by **segregating interfaces**:

```java
interface Logger { void log(...); }
interface Notifier { void notify(...); }
interface FraudChecker { void check(...); }
```

---

## 5. D — Dependency Inversion Principle (DIP)

> High-level modules should not depend on low-level modules. Both should depend on abstractions.

### 🔴 Before DIP

```java
int score = 720; // hardcoded logic
boolean approved = score > 700;
```

### ✅ After DIP

```java
interface CreditScoreService {
    int getScore(String userId);
}

class ExperianCreditScoreService implements CreditScoreService {
    public int getScore(String userId) {
        return 720;
    }
}

class LoanApproval {
    private CreditScoreService creditService;

    public LoanApproval(CreditScoreService creditService) {
        this.creditService = creditService;
    }

    public boolean approve(String userId) {
        return creditService.getScore(userId) > 700;
    }
}
```

---

## ✅ Final Result: Fully SOLID-Compliant com.demo.work.SmartPaymentSystem

```java
public class com.demo.work.SmartPaymentSystem {
    private Logger logger;
    private Notifier notifier;
    private FraudChecker fraudChecker;
    private RiskEvaluator riskEvaluator;
    private LoanApproval loanApproval;

    public com.demo.work.SmartPaymentSystem(Logger logger, Notifier notifier, FraudChecker fraudChecker,
                              RiskEvaluator riskEvaluator, LoanApproval loanApproval) {
        this.logger = logger;
        this.notifier = notifier;
        this.fraudChecker = fraudChecker;
        this.riskEvaluator = riskEvaluator;
        this.loanApproval = loanApproval;
    }

    public boolean process(String paymentType, double amount, String account, String userId) {
        System.out.println("Processing " + paymentType + " of $" + amount + " for " + account);
        logger.log(paymentType, amount, account);
        notifier.notify(account, amount);
        fraudChecker.check(amount);
        boolean riskOk = riskEvaluator.evaluate(amount);
        boolean creditOk = loanApproval.approve(userId);
        return riskOk && creditOk;
    }
}
```

---

## 🎯 Conclusion

Applying SOLID principles to your fintech software architecture leads to:

- Cleaner code
- Easier testing
- Flexible maintenance
- High scalability

This transformation is especially important in the **fintech domain**, where regulatory compliance, security, and modular integration with third-party systems are essential.