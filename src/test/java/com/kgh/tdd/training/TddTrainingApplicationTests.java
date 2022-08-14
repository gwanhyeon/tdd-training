package com.kgh.tdd.training;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TddTrainingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void plus(){
		int result = Calculator.plus(1,2);
		assertEquals(3, result);
		assertEquals(5, Calculator.plus(4,1));

	}
}


