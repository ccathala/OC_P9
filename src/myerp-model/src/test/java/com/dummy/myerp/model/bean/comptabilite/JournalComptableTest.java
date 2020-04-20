package com.dummy.myerp.model.bean.comptabilite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.dummy.myerp.model.bean.comptabilite.JournalComptable.getByCode;
import static org.assertj.core.api.Assertions.assertThat;

public class JournalComptableTest {

    JournalComptable classUnderTest;

    @Before
    public void init() {
        classUnderTest = new JournalComptable();
    }

    @After
    public void undef() {
        classUnderTest = null;
    }

    @Test
    public void Given_beanJournalComptable_When_toStringIsUsed_Then_shouldBeEqual() {
        // GIVEN
        classUnderTest.setCode("AC");
        classUnderTest.setLibelle("Achats");

        String expected = "JournalComptable{code='AC', libelle='Achats'}";
        // WHEN
        final String  result = classUnderTest.toString();
        // THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void Given_journalComptableList_When_getByCodeIsUsed_Then_shouldReturnTheSameBean() {
        // GIVEN
        List<JournalComptable> journalComptableList = new ArrayList<>();
        journalComptableList.add(new JournalComptable("AC","Achats"));
        journalComptableList.add(new JournalComptable("VE","Ventes"));
        // WHEN
        final JournalComptable result= getByCode(journalComptableList, "VE");
        // THEN
        assertThat(result).isEqualTo(journalComptableList.get(1));
    }

    @Test
    public void Given_journalComptableList_When_getByCodeIsUsedWithWrongCode_Then_shouldReturnNull() {
        // GIVEN
        List<JournalComptable> journalComptableList = new ArrayList<>();
        journalComptableList.add(new JournalComptable("AC","Achats"));
        journalComptableList.add(new JournalComptable("VE","Ventes"));
        // WHEN
        final JournalComptable result= getByCode(journalComptableList, "RE");
        // THEN
        assertThat(result).isNull();
    }
}
