package net.jcip.examples;

import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

@ThreadSafe
public class StatelessFactorizer extends GenericServlet implements Servlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		encodeIntoResponse(res, factors);
	}

	void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {

	}

	BigInteger extractFromRequest(ServletRequest req) {
		return new BigInteger("7");
	}

	BigInteger[] factor(BigInteger i) {
		return new BigInteger[]{i};
	}
}
