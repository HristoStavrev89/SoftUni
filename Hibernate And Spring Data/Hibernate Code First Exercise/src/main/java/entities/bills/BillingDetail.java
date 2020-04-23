package entities.bills;

import entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "billing_detail")
public class BillingDetail extends BaseEntity {
    private String number;
    private User user;
    private BankAccount bankAccount;
    private CreditCard creditCard;

    public BillingDetail() {
    }

    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToOne(mappedBy = "billingDetail", targetEntity = User.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @OneToOne
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id")
    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
