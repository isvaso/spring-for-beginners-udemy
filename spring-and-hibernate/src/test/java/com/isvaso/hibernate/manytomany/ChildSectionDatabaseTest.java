package com.isvaso.hibernate.manytomany;

import com.isvaso.hibernate.manytomany.entity.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChildSectionDatabaseTest {

    @Test
    void addChildListToSection() {
        List<Child> childList = new ArrayList<>();
        childList.add(new Child("Olya", 12));
        childList.add(new Child("Henry", 7));

        Section section = new Section("Dance");

        ChildSectionDatabase.addChildListToSection(childList, section);
    }

    @Test
    void getChildrenBySectionId() {
        System.out.println(ChildSectionDatabase.getChildrenBySectionId(7));
    }

    @Test
    void getSectionsByChildrenId() {
        System.out.println(ChildSectionDatabase.getSectionsByChildrenId(16));
    }

    @Test
    void deleteSectionById() {
        ChildSectionDatabase.deleteSectionById(6);
    }
}