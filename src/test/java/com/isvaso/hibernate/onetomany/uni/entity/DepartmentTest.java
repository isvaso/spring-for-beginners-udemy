package com.isvaso.hibernate.onetomany.uni.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testEquals() {
        Department d1 = new Department(
                "HR",
                1200,
                200);

        Department d2 = new Department(
                "HR",
                1200,
                200);

        assertEquals(d1, d2);
    }
}