package com.cdy.base.util.check.ruler.summary;


import com.cdy.base.util.check.ruler.Ruler;
import com.cdy.base.util.check.ruler.detail.string.*;

public class StrRuler {

    public static Ruler<String> notEmpty() {
        return new StrNotEmptyRuler();
    }

    public static Ruler<String> notEmpty(long failCode, String failDesc) {
        return new StrNotEmptyRuler(failCode, failDesc);
    }

    public static Ruler<String> lengthEq(int norm) {
        return new StrLengthEqRuler(norm);
    }

    public static Ruler<String> lengthEq(int norm, long failCode, String failDesc) {
        return new StrLengthEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> lengthGt(int norm) {
        return new StrLengthGtRuler(norm);
    }

    public static Ruler<String> lengthGt(int norm, long failCode, String failDesc) {
        return new StrLengthGtRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> lengthGte(int norm) {
        return new StrLengthGteRuler(norm);
    }

    public static Ruler<String> lengthGte(int norm, long failCode, String failDesc) {
        return new StrLengthGteRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> lengthLt(int norm) {
        return new StrLengthLtRuler(norm);
    }

    public static Ruler<String> lengthLt(int norm, long failCode, String failDesc) {
        return new StrLengthLtRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> lengthLte(int norm) {
        return new StrLengthLteRuler(norm);
    }

    public static Ruler<String> lengthLte(int norm, long failCode, String failDesc) {
        return new StrLengthLteRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> eq(String norm) {
        return new StrEqRuler(norm);
    }

    public static Ruler<String> eq(String norm, long failCode, String failDesc) {
        return new StrEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> idCard() {
        return new StrIdCardRuler();
    }

    public static Ruler<String> idCard(long failCode, String failDesc) {
        return new StrIdCardRuler(failCode, failDesc);
    }

    public static Ruler<String> chineseName() {
        return new StrChineseNameRuler();
    }

    public static Ruler<String> chineseName(long failCode, String failDesc) {
        return new StrChineseNameRuler(failCode, failDesc);
    }

    public static Ruler<String> englishName() {
        return new StrEnglishNameRuler();
    }

    public static Ruler<String> englishName(long failCode, String failDesc) {
        return new StrEnglishNameRuler(failCode, failDesc);
    }

    public static Ruler<String> email() {
        return new StrEmailRuler();
    }

    public static Ruler<String> email(long failCode, String failDesc) {
        return new StrEmailRuler(failCode, failDesc);
    }

    public static Ruler<String> phone() {
        return new StrPhoneRuler();
    }

    public static Ruler<String> phone(long failCode, String failDesc) {
        return new StrPhoneRuler(failCode, failDesc);
    }

    public static Ruler<String> standardDate() {
        return new StrStandardDateRuler();
    }

    public static Ruler<String> standardDate(long failCode, String failDesc) {
        return new StrStandardDateRuler(failCode, failDesc);
    }

    public static Ruler<String> standardDatetime() {
        return new StrStandardDatetimeRuler();
    }

    public static Ruler<String> standardDatetime(long failCode, String failDesc) {
        return new StrStandardDatetimeRuler(failCode, failDesc);
    }

    public static Ruler<String> num() {
        return new StrNumRuler();
    }

    public static Ruler<String> num(long failCode, String failDesc) {
        return new StrNumRuler(failCode, failDesc);
    }

    public static Ruler<String> notNull() {
        return new StrNotNullRuler();
    }

    public static Ruler<String> notNull(long failCode, String failDesc) {
        return new StrNotNullRuler(failCode, failDesc);
    }

    public static Ruler<String> url() {
        return new StrUrlRuler();
    }

    public static Ruler<String> url(long failCode, String failDesc) {
        return new StrUrlRuler(failCode, failDesc);
    }

    public static Ruler<String> allLetter() {
        return new StrAllLetterRuler();
    }

    public static Ruler<String> allLetter(long failCode, String failDesc) {
        return new StrAllLetterRuler(failCode, failDesc);
    }

    public static Ruler<String> empty() {
        return new StrEmptyRuler();
    }

    public static Ruler<String> empty(long failCode, String failDesc) {
        return new StrEmptyRuler(failCode, failDesc);
    }

    public static Ruler<String> notEq(String norm) {
        return new StrNotEqRuler(norm);
    }

    public static Ruler<String> notEq(String norm, long failCode, String failDesc) {
        return new StrNotEqRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> contains(String norm) {
        return new StrContainsRuler(norm);
    }

    public static Ruler<String> contains(String norm, long failCode, String failDesc) {
        return new StrContainsRuler(norm, failCode, failDesc);
    }

    public static Ruler<String> notContains(String norm) {
        return new StrNotContainsRuler(norm);
    }

    public static Ruler<String> notContains(String norm, long failCode, String failDesc) {
        return new StrNotContainsRuler(norm, failCode, failDesc);
    }

}
