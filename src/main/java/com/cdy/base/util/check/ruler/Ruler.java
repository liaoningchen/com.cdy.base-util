package com.cdy.base.util.check.ruler;


import com.cdy.base.util.exception.CheckException;

import java.util.Arrays;

/**
 *
 * @param <T>
 */
@FunctionalInterface
public interface Ruler<T> {

    /**
     * Ruler整合
     */
    @SafeVarargs
    static <T> Ruler<T> ofAll(Ruler<T>... rulers) {
        return (checkTarget -> Arrays.stream(rulers).forEach(ruler -> ruler.check(checkTarget)));
    }

    /**
     * 校验T
     */
    void check(T checkTarget);

    /**
     * 链式修改code, 需要继承BaseRuler的默认实现
     *
     * @param failCode
     * @return
     */
    default Ruler<T> failCode(long failCode) {
        throw new UnsupportedOperationException();
    }

    /**
     * 链式修改desc, 需要继承BaseRuler的默认实现
     *
     * @param failDesc
     * @return
     */
    default Ruler<T> failDesc(String failDesc) {
        throw new UnsupportedOperationException();
    }

    /**
     * 链式修改code,message, 需要继承BaseRuler的默认实现
     *
     * @param failCode
     * @param failDesc
     * @return
     */
    default Ruler<T> fail(long failCode, String failDesc) {
        throw new UnsupportedOperationException();
    }

    /**
     * 使用IFailMessage接口链式修改code,message, 需要继承BaseRuler的默认实现
     *
     * @param failMessage
     * @return
     */
    default Ruler<T> fail(IFailMessage failMessage) {
        throw new UnsupportedOperationException();
    }

    /**
     * 或操作
     */
    @SuppressWarnings("unchecked")
    default Ruler<T> or(Ruler<T>... rulers) {
        return checkTarget -> {
            try {
                check(checkTarget);
            } catch (CheckException e) {
                ofAll(rulers).check(checkTarget);
            }
        };
    }

}
