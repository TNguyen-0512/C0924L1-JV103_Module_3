package com.example.do_an_ca_nhan.common;

import java.util.regex.Pattern;

public class Validator {

    // Mã khách hàng: KH-XXXX
    private static final Pattern MA_KH_PATTERN = Pattern.compile("^KH-\\d{4}$");

    // Mã dịch vụ: DV-XXXX
    private static final Pattern MA_DV_PATTERN = Pattern.compile("^DV-\\d{4}$");

    // Số điện thoại: 090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx | (84)+91xxxxxxx
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$");

    // Số CMND: 9 hoặc 12 chữ số
    private static final Pattern CMND_PATTERN = Pattern.compile("^\\d{9}|\\d{12}$");

    // Email
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Ngày: DD/MM/YYYY
    private static final Pattern DATE_PATTERN = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[-/](0[1-9]|1[012])[-/]\\d{4}$");

    public static boolean isValidMaKhachHang(String maKH) {
        return MA_KH_PATTERN.matcher(maKH).matches();
    }

    public static boolean isValidMaDichVu(String maDV) {
        return MA_DV_PATTERN.matcher(maDV).matches();
    }

    public static boolean isValidSoDienThoai(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidCMND(String cmnd) {
        return CMND_PATTERN.matcher(cmnd).matches();
    }

    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidDate(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }

    public static boolean isPositiveInteger(String number) {
        try {
            return Integer.parseInt(number) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositiveDouble(String number) {
        try {
            return Double.parseDouble(number) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
