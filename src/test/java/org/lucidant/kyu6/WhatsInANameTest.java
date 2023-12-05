package org.lucidant.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WhatsInANameTest {

    @Test
    void testTooShort() {
        assertThat(WhatsInAName.nameInStr("chri", "Chris")).isFalse();
    }

    @Test
    void testMatchHandleCase() {
        assertThat(WhatsInAName.nameInStr("chris", "Chris")).isTrue();
    }

    @Test
    void testLongerBaseValue() {
        assertThat(WhatsInAName.nameInStr("christopher", "chris")).isTrue();
    }

    @Test
    void sampleTest() {
        assertThat(WhatsInAName.nameInStr("Across the rivers", "chris")).isTrue();
        assertThat(WhatsInAName.nameInStr("Next to a lake", "chris")).isFalse();
        assertThat(WhatsInAName.nameInStr("Under a sea", "chris")).isFalse();
        assertThat(WhatsInAName.nameInStr("A crew that boards the ship", "chris")).isFalse();
        assertThat(WhatsInAName.nameInStr("A live son", "Allison")).isFalse();
    }

}
