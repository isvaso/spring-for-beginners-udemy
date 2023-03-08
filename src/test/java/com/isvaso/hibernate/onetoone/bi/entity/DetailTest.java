package com.isvaso.hibernate.onetoone.bi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetailTest {

    @Test
    void testEquals() {
        Detail employeeDetail1 = new Detail(
                "Moscow",
                "+7(495)456-12-14",
                "ivivan97@list.ru");

        Detail employeeDetail2 = new Detail(
                "Moscow",
                "+7(495)456-12-14",
                "ivivan97@list.ru");

        assertTrue(employeeDetail1.equals(employeeDetail2));
    }
}