package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userr")
public class User {
        @Id
        public Long id;

        @Column(length = 256, nullable = false)
        public String name;

        @Column(name = "yearr")
        @Convert(converter = YearConverter.class)
        private Year year;

        protected User() {
        }

        public User(Long id, String name, Year year) {
                this.id = id;
                this.name = name;
                this.year = year;
        }

        @Override
        public String toString() {
                return "User{" + "id=" + id + '}';
        }
}
