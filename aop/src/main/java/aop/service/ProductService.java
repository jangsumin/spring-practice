package aop.service;

import org.springframework.stereotype.Service;

import aop.domain.Product;

// 코어 관심을 가지는 클래스
@Service
public class ProductService {
	public Product find(String name) throws RuntimeException {
		if ("".equals(name)) {
			throw new RuntimeException("empty name");
		}
		System.out.println("finding...");
		return new Product(name);
	}
}
