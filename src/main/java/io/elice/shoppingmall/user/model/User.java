package io.elice.shoppingmall.user.model;

import io.elice.shoppingmall.audit.BaseEntity;
<<<<<<< HEAD
=======
import io.elice.shoppingmall.order.model.Order;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
import jakarta.persistence.*;
import lombok.*;



@Entity
<<<<<<< HEAD
=======
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
>>>>>>> 3f15225515fdc2375fbd8e029de668426184e9c7
=======
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long user_id;
=======
    @Column(name = "user_id")
    private Long id;
<<<<<<< HEAD
>>>>>>> 3f15225515fdc2375fbd8e029de668426184e9c7
=======
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_roles")
    private String roles;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_phone_number")
    private String phoneNumber;

    @Column(name = "user_address")
    private String address;

    @Column(name = "is_deleted")
    private boolean idDeleted;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Getter
    public enum Role {
        USER("ROLE_USER","일반 사용자"), ADMIN("ROLE_ADMIN","관리자");

        private final String key;
        private final String title;

        Role(String key, String title) {
            this.key = key;
            this.title = title;
        }
    }
}
