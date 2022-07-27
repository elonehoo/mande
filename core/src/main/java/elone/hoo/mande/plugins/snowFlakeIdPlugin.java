package elone.hoo.mande.plugins;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

public class snowFlakeIdPlugin implements IdentifierGenerator {
  /**
   * start timestamp
   */
  private final long startTimestamp = 1557825652094L;

  /**
   * The number of bits occupied by each part
   */
  private final long workerIdBits = 5L;
  private final long datacenterIdBits = 5L;
  private final long sequenceBits = 12L;

  /**
   * Maximum value for each part
   */
  private final long maxWorkerId = ~(-1L << workerIdBits);
  private final long maxDatacenterId = ~(-1L << datacenterIdBits);
  private final long maxSequence = ~(-1L << sequenceBits);

  /**
   * displacement of each part to the left
   */
  private final long workerIdShift = sequenceBits;
  private final long datacenterIdShift = sequenceBits + workerIdBits;
  private final long timestampShift = sequenceBits + workerIdBits + datacenterIdBits;

  private long datacenterId = 1;

  private long workerId = 0;

  private long sequence = 0L;
  private long lastTimestamp = -1L;

  @PostConstruct
  public void init() {
    String msg;
    if (workerId > maxWorkerId || workerId < 0) {
      msg = String.format("worker Id can't be greater than %d or less than 0", maxWorkerId);
    }
    if (datacenterId > maxDatacenterId || datacenterId < 0) {
      msg = String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId);
    }
  }

  @Transactional
  public synchronized long nextId() {
    long timestamp = timeGen();
    if (timestamp < lastTimestamp) {
      try {
        throw new Exception(String.format(
          "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
      } catch (Exception e) {
        e.printStackTrace();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      }
    }
    if (timestamp == lastTimestamp) {
      sequence = (sequence + 1) & maxSequence;
      if (sequence == 0L) {
        timestamp = tilNextMillis();
      }
    } else {
      sequence = 0L;
    }
    lastTimestamp = timestamp;

    return (timestamp - startTimestamp) << timestampShift
      | datacenterId << datacenterIdShift
      | workerId << workerIdShift
      | sequence;
  }

  private long tilNextMillis() {
    long timestamp = timeGen();
    while (timestamp <= lastTimestamp) {
      timestamp = timeGen();
    }
    return timestamp;
  }

  private long timeGen() {
    return System.currentTimeMillis();
  }

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
    return String.valueOf(nextId());
  }
}
