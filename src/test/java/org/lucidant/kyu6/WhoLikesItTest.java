package org.lucidant.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.lucidant.kyu6.WhoLikesIt.whoLikesIt;

class WhoLikesItTest {

    @Test
    void staticTests() {
        assertThat(whoLikesIt()).isEqualTo("no one likes this");
        assertThat(whoLikesIt("Peter")).isEqualTo("Peter likes this");
        assertThat(whoLikesIt("Jacob", "Alex")).isEqualTo("Jacob and Alex like this");
        assertThat(whoLikesIt("Max", "John", "Mark")).isEqualTo("Max, John and Mark like this");
        assertThat(whoLikesIt("Alex", "Jacob", "Mark", "Max")).isEqualTo("Alex, Jacob and 2 others like this");

        assertThat(whoLikesIt("Alex", "Jacob", "Mark", "Max", "Mark", "Max"))
            .isEqualTo("Alex, Jacob and 4 others like this");
    }

}
