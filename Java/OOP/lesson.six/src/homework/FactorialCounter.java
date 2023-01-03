package homework;

import java.math.BigInteger;

public class FactorialCounter implements Runnable {
  private int n;
  private BigInteger factorialSum = BigInteger.ZERO;

  public FactorialCounter(int n) {
    super();
    this.n = n;
  }

  public int getN() {
    return n;
  }

  public BigInteger getFactorialSum() {
    return factorialSum;
  }

  public BigInteger calculateFactorial(int number) {
    BigInteger fact = BigInteger.ONE;
    for (int i = 1; i <= number; i++) {
      fact = fact.multiply(BigInteger.valueOf(i));
    }
    return fact;
  }

  @Override
  public void run() {

    Thread thr = Thread.currentThread();

    for (int i = 0; i <= n; i++) {
      BigInteger fact = calculateFactorial(i);
      System.out.println(thr.getName() + " " + i + "!=" + fact);
      factorialSum = factorialSum.add(fact);
    }

  }

}