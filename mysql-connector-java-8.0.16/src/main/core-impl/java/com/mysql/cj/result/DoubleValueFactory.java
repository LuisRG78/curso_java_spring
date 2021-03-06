/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License, version 2.0, as published by the
 * Free Software Foundation.
 *
 * This program is also distributed with certain software (including but not
 * limited to OpenSSL) that is licensed under separate terms, as designated in a
 * particular file or component or in included license documentation. The
 * authors of MySQL hereby grant you an additional permission to link the
 * program and your derivative works with the separately licensed software that
 * they have included with MySQL.
 *
 * Without limiting anything contained in the foregoing, this file, which is
 * part of MySQL Connector/J, is also subject to the Universal FOSS Exception,
 * version 1.0, a copy of which can be found at
 * http://oss.oracle.com/licenses/universal-foss-exception.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License, version 2.0,
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301  USA
 */

package com.mysql.cj.result;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

import com.mysql.cj.Messages;
import com.mysql.cj.conf.PropertySet;
import com.mysql.cj.exceptions.NumberOutOfRange;

/**
 * A value factory for creating double values.
 */
public class DoubleValueFactory extends AbstractNumericValueFactory<Double> {

    public DoubleValueFactory(PropertySet pset) {
        super(pset);
    }

    @Override
    public Double createFromBigInteger(BigInteger i) {
        if (this.jdbcCompliantTruncationForReads && (new BigDecimal(i).compareTo(BigDecimal.valueOf(-Double.MAX_VALUE)) < 0
                || new BigDecimal(i).compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0)) {
            throw new NumberOutOfRange(Messages.getString("ResultSet.NumberOutOfRange", new Object[] { i, getTargetTypeName() }));
        }
        return i.doubleValue();
    }

    @Override
    public Double createFromLong(long l) {
        if (this.jdbcCompliantTruncationForReads && (l < -Double.MAX_VALUE || l > Double.MAX_VALUE)) {
            throw new NumberOutOfRange(Messages.getString("ResultSet.NumberOutOfRange", new Object[] { l, getTargetTypeName() }));
        }
        return (double) l;
    }

    @Override
    public Double createFromBigDecimal(BigDecimal d) {
        if (this.jdbcCompliantTruncationForReads
                && (d.compareTo(BigDecimal.valueOf(-Double.MAX_VALUE)) < 0 || d.compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) > 0)) {
            throw new NumberOutOfRange(Messages.getString("ResultSet.NumberOutOfRange", new Object[] { d, getTargetTypeName() }));
        }
        return d.doubleValue();
    }

    @Override
    public Double createFromDouble(double d) {
        if (this.jdbcCompliantTruncationForReads && (d < -Double.MAX_VALUE || d > Double.MAX_VALUE)) {
            throw new NumberOutOfRange(Messages.getString("ResultSet.NumberOutOfRange", new Object[] { d, getTargetTypeName() }));
        }
        return d;
    }

    @Override
    public Double createFromBit(byte[] bytes, int offset, int length) {
        return new BigInteger(ByteBuffer.allocate(length + 1).put((byte) 0).put(bytes, offset, length).array()).doubleValue();
    }

    @Override
    public Double createFromNull() {
        return 0.0;
    }

    public String getTargetTypeName() {
        return Double.class.getName();
    }
}
