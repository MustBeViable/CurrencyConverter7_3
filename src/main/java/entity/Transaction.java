package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    double amount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tx_source"))
    private Currency source;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tx_destination"))
    private Currency destination;

    public Transaction(double amount, Currency source, Currency destination) {
        this.amount = amount;
        this.source = source;
        this.destination = destination;
    }

    public Transaction() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getSource() {
        return source;
    }

    public void setSource(Currency source) {
        this.source = source;
    }

    public Currency getDestination() {
        return destination;
    }

    public void setDestination(Currency destination) {
        this.destination = destination;
    }
}
