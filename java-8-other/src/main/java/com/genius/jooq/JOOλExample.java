package com.genius.jooq;

import org.jooq.lambda.Seq;

import java.util.List;

public class JOOλExample {

	public static void main(String[] args) {
		int max = 3;
		List<String> alphabet = Seq.rangeClosed('A', 'Z').map(Object::toString).toList();
		Seq.rangeClosed(1, max).flatMap(length -> Seq.rangeClosed(1, length - 1).foldLeft(Seq.seq(alphabet), (s, i) -> s.crossJoin(Seq.seq(alphabet)).map(t -> t.v1 + t.v2))).forEach(System.out::println);
	}
}