package com.amit.springboot.profiles;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"foo"})
class FooProfileTest {

	@Test
	void test() {
	}

}
