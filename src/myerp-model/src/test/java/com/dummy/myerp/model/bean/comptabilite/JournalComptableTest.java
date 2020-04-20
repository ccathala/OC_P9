package com.dummy.myerp.model.bean.comptabilite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

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
}
