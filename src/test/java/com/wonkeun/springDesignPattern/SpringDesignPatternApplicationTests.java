package com.wonkeun.springDesignPattern;

import com.wonkeun.springDesignPattern.prototype.ProtoFalse;
import com.wonkeun.springDesignPattern.prototype.ProtoTrue;
import com.wonkeun.springDesignPattern.repository.PresidentRepository;
import com.wonkeun.springDesignPattern.singleton.SingletonA;
import com.wonkeun.springDesignPattern.singleton.SingletonB;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDesignPatternApplicationTests {
	@Autowired
	SingletonB singletonB1;
	@Autowired
	SingletonB singletonB2;
	@Autowired
	ProtoTrue true1;
	@Autowired
	ProtoTrue true2;
	@Autowired
	ProtoFalse false1;
	@Autowired
	ProtoFalse false2;

	@Autowired
	PresidentRepository presidentRepository;

	@Test
	public void testSingletons() {
		SingletonA singletonA1 = SingletonA.getInstance();
		SingletonA singletonA2 = SingletonA.getInstance();
		Assert.assertNotNull(singletonA1);
		Assert.assertSame(singletonA1, singletonA2);
		Assert.assertNotNull(singletonB1);
		Assert.assertSame(singletonB1, singletonB2);
	}

	@Test
	public void testPrototypes() {
		Assert.assertSame(false1, false2);
		Assert.assertNotSame(true1, true2);
	}

	@Test
	public void testRepository() {
		System.out.println(presidentRepository.findById(1L));
		System.out.println(presidentRepository.findById(2L));
	}

	@Test
	void contextLoads() {
	}

}
