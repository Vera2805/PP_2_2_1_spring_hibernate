package hiber.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public User getUser() {
        return user;
    }

    public String getCar() {
        return "model:" + model + "   series: " + series;
    }

    @Override
    public String toString() {
        return "model: " + model + ", " +
                "series: " + series;
    }


}
