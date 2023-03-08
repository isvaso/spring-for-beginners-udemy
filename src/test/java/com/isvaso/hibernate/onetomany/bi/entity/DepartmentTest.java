package com.isvaso.hibernate.onetomany.bi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testEquals() {
        Department d1 = new Department(
                "IT",
                2000,
                1000);

        Department d2 = new Department(
                "IT",
                2000,
                1000);

        Department d3= new Department(
                "ADS",
                1000,
                500);

        assertEquals(d1, d2);
        assertNotEquals(d1, d3);
    }
}