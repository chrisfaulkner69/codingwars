/**
 * 
 */
package org.lucidant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chrisfaulkner
 *
 */
class DnaStrandTest {

    @Test
    public void test01() {
       assertEquals("TTTT", DnaStrand.makeComplement("AAAA"));
    }
    @Test
    public void test02() {
       assertEquals("TAACG", DnaStrand.makeComplement("ATTGC"));
    }
    @Test
    public void test03() {
       assertEquals("CATA", DnaStrand.makeComplement("GTAT"));
    } 
    
    @Test
    public void test04() {
       assertEquals("CATA", DnaStrand.makeComplement("XGXTATX"));
    } 

}
