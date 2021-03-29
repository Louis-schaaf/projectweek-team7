package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CirkelTest {
        Punt geldigMiddelpunt = new Punt(50,60);
        int geldigeRadius = 10;
        int ongeldigeRadius = -10;

        @Before
        public void setup() throws Exception {
            Cirkel testCirkel = new Cirkel(geldigMiddelpunt,geldigeRadius);
        }


        @Test
        public void test_Constructor_Maakt_Geldig_Object() {
            Cirkel testCirkel = new Cirkel(geldigMiddelpunt, geldigeRadius);
            assertEquals(10,testCirkel.getRadius());
             assertEquals(50,testCirkel.getMiddelpunt().getX(), 0.1);
            assertEquals(60,testCirkel.getMiddelpunt().getY(), 0.1);
        }
        @Test (expected = DomainException.class)
        public void test_Constructor_Met_null_middelpunt_Gooit_Exception() {
            Cirkel testCirkel = new Cirkel(null, geldigeRadius);
        }

        @Test (expected = DomainException.class)
        public void test_Constructor_Met_Zero_Straal_Gooit_Exception() {
            Cirkel testCirkel = new Cirkel(geldigMiddelpunt, 0);
        }
        @Test (expected = DomainException.class)
        public void test_Constructor_Met_nul_middelpunt_Gooit_Exception() {
            Cirkel testCirkel = new Cirkel(geldigMiddelpunt,0);
        }

        @Test (expected = DomainException.class)
        public void test_Constructor_Met_Straal_Negatief_Gooit_Exception() {
            Cirkel testCirkel = new Cirkel(geldigMiddelpunt, ongeldigeRadius);
        }


}
