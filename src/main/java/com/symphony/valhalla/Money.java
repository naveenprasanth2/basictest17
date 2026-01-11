package com.symphony.valhalla;

public value class Money implements Comparable<Money> {
    private final long units;
    private final int nanos;
    private final String currencyCode;

    public Money(long units, int nanos, String currencyCode) {
        this.units = units;
        this.nanos = nanos;
        this.currencyCode = currencyCode;
    }

    public Money add(Money other) {
        if (!this.currencyCode.equals(other.currencyCode)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
        return new Money(this.units + other.units, this.nanos + other.nanos, this.currencyCode);
    }

    @Override
    public int compareTo(Money other) {
        int c = Long.compare(this.units, other.units);
        return (c != 0) ? c : Integer.compare(this.nanos, other.nanos);
    }
}