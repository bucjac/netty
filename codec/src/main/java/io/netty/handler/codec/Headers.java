/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License, version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.netty.handler.codec;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public interface Headers<T> extends Iterable<Map.Entry<T, T>> {

    /**
     * Converts to/from a generic object to the type of the headers.
     */
    interface ValueConverter<T> {
        T convertObject(Object value);

        T convertBoolean(boolean value);

        boolean convertToBoolean(T value);

        T convertByte(byte value);

        byte convertToByte(T value);

        T convertChar(char value);

        char convertToChar(T value);

        T convertShort(short value);

        short convertToShort(T value);

        T convertInt(int value);

        int convertToInt(T value);

        T convertLong(long value);

        long convertToLong(T value);

        T convertTimeMillis(long value);

        long convertToTimeMillis(T value);

        T convertFloat(float value);

        float convertToFloat(T value);

        T convertDouble(double value);

        double convertToDouble(T value);
    }

    /**
     * Returns the value of a header with the specified name. If there are more than one values for the specified name,
     * the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found. {@code null} if there's no such header.
     */
    T get(T name);

    /**
     * Returns the value of a header with the specified name. If there are more than one values for the specified name,
     * the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found. {@code defaultValue} if there's no such header.
     */
    T get(T name, T defaultValue);

    /**
     * Returns and removes the value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value or {@code null} if there is no such header
     */
    T getAndRemove(T name);

    /**
     * Returns and removes the value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value or {@code defaultValue} if there is no such header
     */
    T getAndRemove(T name, T defaultValue);

    /**
     * Returns the values of the header with the specified name. The returned {@link List} can't be modified.
     *
     * @param name the name of the header to search
     * @return A {@link List} of header values which will be empty if no values are found
     */
    List<T> getAll(T name);

    /**
     * Returns and removes the values of the header with the specified name.
     *
     * @param name the name of the header to search
     * @return A {@link List} of header values which will be empty if no values are found
     */
    List<T> getAllAndRemove(T name);

    /**
     * Returns the boolean value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a boolean. {@code null} if there's no such
     *         header or its value is not a boolean.
     */
    Boolean getBoolean(T name);

    /**
     * Returns the boolean value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a boolean. {@code defaultValue} if there's
     *         no such header or its value is not a boolean.
     */
    boolean getBoolean(T name, boolean defaultValue);

    /**
     * Returns the byte value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a byte. {@code null} if there's no such
     *         header or its value is not a byte.
     */
    Byte getByte(T name);

    /**
     * Returns the byte value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a byte. {@code defaultValue} if there's no
     *         such header or its value is not a byte.
     */
    byte getByte(T name, byte defaultValue);

    /**
     * Returns the char value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a char. {@code null} if there's no such
     *         header or its value is not a char.
     */
    Character getChar(T name);

    /**
     * Returns the char value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a char. {@code defaultValue} if there's no
     *         such header or its value is not a char.
     */
    char getChar(T name, char defaultValue);

    /**
     * Returns the short value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a short. {@code null} if there's no such
     *         header or its value is not a short.
     */
    Short getShort(T name);

    /**
     * Returns the short value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a short. {@code defaultValue} if there's
     *         no such header or its value is not a short.
     */
    short getInt(T name, short defaultValue);

    /**
     * Returns the integer value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is an integer. {@code null} if there's no
     *         such header or its value is not an integer.
     */
    Integer getInt(T name);

    /**
     * Returns the integer value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is an integer. {@code defaultValue} if
     *         there's no such header or its value is not an integer.
     */
    int getInt(T name, int defaultValue);

    /**
     * Returns the long value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a long. {@code null} if there's no such
     *         header or its value is not a long.
     */
    Long getLong(T name);

    /**
     * Returns the long value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a long. {@code defaultValue} if there's no
     *         such header or its value is not a long.
     */
    long getLong(T name, long defaultValue);

    /**
     * Returns the float value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a float. {@code null} if there's no such
     *         header or its value is not a float.
     */
    Float getFloat(T name);

    /**
     * Returns the float value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a float. {@code defaultValue} if there's
     *         no such header or its value is not a float.
     */
    float getFloat(T name, float defaultValue);

    /**
     * Returns the double value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a double. {@code null} if there's no such
     *         header or its value is not a double.
     */
    Double getDouble(T name);

    /**
     * Returns the double value of a header with the specified name. If there are more than one values for the specified
     * name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a double. {@code defaultValue} if there's
     *         no such header or its value is not a double.
     */
    double getDouble(T name, double defaultValue);

    /**
     * Returns the date value of a header with the specified name as milliseconds. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name The name of the header to search
     * @return the first header value in milliseconds if the header is found and its value is a date. {@code null} if
     *         there's no such header or its value is not a date.
     */
    Long getTimeMillis(T name);

    /**
     * Returns the date value of a header with the specified name as milliseconds. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name The name of the header to search
     * @param defaultValue default value
     * @return the first header value in milliseconds if the header is found and its value is a date.
     *         {@code defaultValue} if there's no such header or its value is not a date.
     */
    long getTimeMillis(T name, long defaultValue);

    /**
     * Returns and removes the boolean value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a boolean. {@code null} if there's no such
     *         header or its value is not a boolean.
     */
    Boolean getBooleanAndRemove(T name);

    /**
     * Returns and removes the boolean value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a boolean. {@code defaultValue} if there
     *         is no such header or its value of header is not a boolean.
     */
    boolean getBooleanAndRemove(T name, boolean defaultValue);

    /**
     * Returns and removes the byte value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a byte. {@code null} if there's no such
     *         header or its value is not a byte.
     */
    Byte getByteAndRemove(T name);

    /**
     * Returns and removes the byte value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a byte. {@code defaultValue} if there is
     *         no such header or its value of header is not a byte.
     */
    byte getByteAndRemove(T name, byte defaultValue);

    /**
     * Returns and removes the char value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a char. {@code null} if there's no such
     *         header or its value is not a char.
     */
    Character getCharAndRemove(T name);

    /**
     * Returns and removes the char value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a char. {@code defaultValue} if there is
     *         no such header or its value of header is not a char.
     */
    char getCharAndRemove(T name, char defaultValue);

    /**
     * Returns and removes the short value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a short. {@code null} if there's no such
     *         header or its value is not a short.
     */
    Short getShortAndRemove(T name);

    /**
     * Returns and removes the short value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a short. {@code defaultValue} if there is
     *         no such header or its value of header is not a short.
     */
    short getShortAndRemove(T name, short defaultValue);

    /**
     * Returns and removes the integer value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is an integer. {@code null} if there's no
     *         such header or its value is not an integer.
     */
    Integer getIntAndRemove(T name);

    /**
     * Returns and removes the integer value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is an integer. {@code defaultValue} if there
     *         is no such header or its value of header is not an integer.
     */
    int getIntAndRemove(T name, int defaultValue);

    /**
     * Returns and removes the long value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a long. {@code null} if there's no such
     *         header or its value is not a long.
     */
    Long getLongAndRemove(T name);

    /**
     * Returns and removes the long value of a header with the specified name. If there are more than one values for the
     * specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a long. {@code defaultValue} if there's no
     *         such header or its value is not a long.
     */
    long getLongAndRemove(T name, long defaultValue);

    /**
     * Returns and removes the float value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a float. {@code null} if there's no such
     *         header or its value is not a float.
     */
    Float getFloatAndRemove(T name);

    /**
     * Returns and removes the float value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a float. {@code defaultValue} if there's
     *         no such header or its value is not a float.
     */
    float getFloatAndRemove(T name, float defaultValue);

    /**
     * Returns and removes the double value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @return the first header value if the header is found and its value is a double. {@code null} if there's no such
     *         header or its value is not a double.
     */
    Double getDoubleAndRemove(T name);

    /**
     * Returns and removes the double value of a header with the specified name. If there are more than one values for
     * the specified name, the first value is returned.
     *
     * @param name the name of the header to search
     * @param defaultValue the default value
     * @return the first header value if the header is found and its value is a double. {@code defaultValue} if there's
     *         no such header or its value is not a double.
     */
    double getDoubleAndRemove(T name, double defaultValue);

    /**
     * Returns and removes the date value of a header with the specified name as milliseconds. If there are more than
     * one values for the specified name, the first value is returned.
     *
     * @param name The name of the header to search
     * @return the first header value in milliseconds if the header is found and its value is a date. {@code null} if
     *         there's no such header or its value is not a date.
     */
    Long getTimeMillisAndRemove(T name);

    /**
     * Returns and removes the date value of a header with the specified name as milliseconds. If there are more than
     * one values for the specified name, the first value is returned.
     *
     * @param name The name of the header to search
     * @param defaultValue default value
     * @return the first header value in milliseconds if the header is found and its value is a date.
     *         {@code defaultValue} if there's no such header or its value is not a date.
     */
    long getTimeMillisAndRemove(T name, long defaultValue);

    /**
     * Returns {@code true} if a header with the name exists.
     *
     * @param name the header name
     * @return {@code true} if at least one header is found
     */
    boolean contains(T name);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean contains(T name, T value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsObject(T name, Object value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsBoolean(T name, boolean value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsByte(T name, byte value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsChar(T name, char value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsShort(T name, short value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsInt(T name, int value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsLong(T name, long value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsFloat(T name, float value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsDouble(T name, double value);

    /**
     * Returns {@code true} if a header with the name and value exists.
     *
     * @param name the header name
     * @param value the header value
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean containsTimeMillis(T name, long value);

    /**
     * Returns {@code true} if a header with the {@code name} and {@code value} exists.
     *
     * @param name the header name
     * @param value the header value
     * @param valueComparator The comparator to use when comparing {@code value} to entries in this map
     * @return {@code true} if it contains it {@code false} otherwise
     */
    boolean contains(T name, T value, Comparator<? super T> valueComparator);

    /**
     * Returns the number of headers in this object.
     */
    int size();

    /**
     * Returns {@code true} if {@link #size()} equals {@code 0}.
     */
    boolean isEmpty();

    /**
     * Returns a {@link Set} of all header names in this object. The returned {@link Set} cannot be modified.
     */
    Set<T> names();

    /**
     * Adds a new header with the specified name and value.
     *
     * @param name the name of the header
     * @param value the value of the header
     * @throws NullPointerException if either {@code name} or {@code value} is null.
     * @return {@code this}
     */
    Headers<T> add(T name, T value);

    /**
     * Adds a new header with the specified name and values. This method is equivalent to
     *
     * <pre>
     * for (T v : values) {
     *     headers.add(name, v);
     * }
     * </pre>
     *
     * @param name the header name
     * @param values the values of the header
     * @return {@code this}
     */
    Headers<T> add(T name, Iterable<? extends T> values);

    /**
     * Adds a new header with the specified name and values. This method is equivalent to
     *
     * <pre>
     * for (T v : values) {
     *     headers.add(name, v);
     * }
     * </pre>
     *
     * @param name the header name
     * @param values the values of the header
     * @return {@code this}
     */
    Headers<T> add(T name, T... values);

    /**
     * Adds a new header. Before the {@code value} is add, it's converted to type {@code T} by a call to
     * {@link ValueConverter#convertObject(java.lang.Object)}.
     *
     * @param name the header name
     * @param value the value of the header
     * @throws NullPointerException if either {@code name} or {@code value} before or after its conversion is
     *                              {@code null}.
     * @return {@code this}
     */
    Headers<T> addObject(T name, Object value);

    /**
     * Adds a new header with the specified name and values. This method is equivalent to
     *
     * <pre>
     * for (Object v : values) {
     *     headers.addObject(name, v);
     * }
     * </pre>
     *
     * @param name the header name
     * @param values the value of the header
     * @return {@code this}
     */
    Headers<T> addObject(T name, Iterable<?> values);

    /**
     * Adds a new header with the specified name and values. This method is equivalent to
     *
     * <pre>
     * for (Object v : values) {
     *     headers.addObject(name, v);
     * }
     * </pre>
     *
     * @param name the header name
     * @param values the value of the header
     * @return {@code this}
     */
    Headers<T> addObject(T name, Object... values);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addBoolean(T name, boolean value);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addByte(T name, byte value);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addChar(T name, char value);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addShort(T name, short value);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addInt(T name, int value);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addLong(T name, long value);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addFloat(T name, float value);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addDouble(T name, double value);

    /**
     * Adds a new header.
     *
     * @param name the header name
     * @param value the value of the header
     * @return {@code this}
     */
    Headers<T> addTimeMillis(T name, long value);

    /**
     * Adds all header names and values of {@code headers} to this object.
     *
     * @throws IllegalArgumentException if {@code headers == this}.
     * @return {@code this}
     */
    Headers<T> add(Headers<? extends T> headers);

    /**
     * Sets a header with the specified name and value. Any existing headers with the same name are overwritten.
     *
     * @param name the header name
     * @param value the value of the header
     * @throws NullPointerException if either {@code name} or {@code value} is {@code null}.
     * @return {@code this}
     */
    Headers<T> set(T name, T value);

    /**
     * Sets a new header with the specified name and values. This method is equivalent to
     *
     * <pre>
     * for (T v : values) {
     *     headers.addObject(name, v);
     * }
     * </pre>
     *
     * @param name the header name
     * @param values the value of the header
     * @return {@code this}
     */
    Headers<T> set(T name, Iterable<? extends T> values);

    /**
     * Sets a header with the specified name and values. Any existing headers with this name are removed. This method
     * is equivalent to:
     *
     * <pre>
     * headers.remove(name);
     * for (T v : values) {
     *     headers.add(name, v);
     * }
     * </pre>
     *
     * @param name the header name
     * @param values the value of the header
     * @return {@code this}
     */
    Headers<T> set(T name, T... values);

    /**
     * Sets a new header. Any existing headers with this name are removed. Before the {@code value} is add, it's
     * converted to type {@code T} by a call to {@link ValueConverter#convertObject(java.lang.Object)}.
     *
     * @param name the header name
     * @param value the value of the header
     * @throws NullPointerException if either {@code name} or {@code value} before or after its conversion is
     *                              {@code null}.
     * @return {@code this}
     */
    Headers<T> setObject(T name, Object value);

    /**
     * Sets a header with the specified name and values. Any existing headers with this name are removed. This method
     * is equivalent to:
     *
     * <pre>
     * headers.remove(name);
     * for (Object v : values) {
     *     headers.addObject(name, v);
     * }
     * </pre>
     *
     * @param name the header name
     * @param values the values of the header
     * @return {@code this}
     */
    Headers<T> setObject(T name, Iterable<?> values);

    /**
     * Sets a header with the specified name and values. Any existing headers with this name are removed. This method
     * is equivalent to:
     *
     * <pre>
     * headers.remove(name);
     * for (Object v : values) {
     *     headers.addObject(name, v);
     * }
     * </pre>
     *
     * @param name the header name
     * @param values the values of the header
     * @return {@code this}
     */
    Headers<T> setObject(T name, Object... values);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setBoolean(T name, boolean value);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setByte(T name, byte value);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setChar(T name, char value);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setShort(T name, short value);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setInt(T name, int value);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setLong(T name, long value);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setFloat(T name, float value);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setDouble(T name, double value);

    /**
     * Set the {@code name} to {@code value}. This will remove all previous values associated with {@code name}.
     * @param name The name to modify
     * @param value The value
     * @return {@code this}
     */
    Headers<T> setTimeMillis(T name, long value);

    /**
     * Clears the current header entries and copies all header entries of the specified {@code headers}.
     *
     * @return {@code this}
     */
    Headers<T> set(Headers<? extends T> headers);

    /**
     * Retains all current headers but calls {@link #set(T, T)} for each entry in {@code headers}.
     *
     * @param headers The headers used to {@link #set(T, T)} values in this instance
     * @return {@code this}
     */
    Headers<T> setAll(Headers<? extends T> headers);

    /**
     * Removes all headers with the specified {@code name}.
     *
     * @param name the header name
     * @return {@code true} if at least one entry has been removed.
     */
    boolean remove(T name);

    /**
     * Removes all headers. After a call to this method {@link #size()} equals {@code 0}.
     *
     * @return {@code this}
     */
    Headers<T> clear();

    @Override
    Iterator<Entry<T, T>> iterator();
}
