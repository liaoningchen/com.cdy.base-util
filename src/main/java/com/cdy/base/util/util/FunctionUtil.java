package com.cdy.base.util.util;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class FunctionUtil {

    public static <T, R> Function<T, R> tryOfF(UncheckedFunction<T, R> function) {
        Objects.requireNonNull(function);
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T> Consumer<T> tryOfC(UncheckedConsumer<T> consumer) {
        Objects.requireNonNull(consumer);
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T> Predicate<T> tryOfP(UncheckedPredicate<T> predicate) {
        Objects.requireNonNull(predicate);
        return t -> {
            try {
                return predicate.test(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T> Supplier<T> tryOfS(UncheckedSupplier<T> supplier) {
        Objects.requireNonNull(supplier);
        return () -> {
            try {
                return supplier.get();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    @FunctionalInterface
    public interface UncheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedConsumer<T> {
        void accept(T t) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedPredicate<T> {
        boolean test(T t) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedSupplier<T> {
        T get() throws Exception;
    }

}
