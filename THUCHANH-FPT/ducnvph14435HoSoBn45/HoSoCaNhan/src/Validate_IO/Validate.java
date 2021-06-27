/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validate_IO;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Đức DEV
 */
public class Validate {

    public static boolean checkEmpty(JTextField field, StringBuilder sb, String mss) {
        if (field.getText().isEmpty()) {
            sb.append(mss).append("\n");
            field.setBackground(Color.red);
            return false;
        } else {
            field.setBackground(Color.white);
        }
        if (field.getText().length() > 27) {
            field.setBackground(Color.red);
            sb.append("Tên Không Quá 26 ký tự");
            return false;
        } else {
            field.setBackground(Color.white);

        }
        return true;
    }

    public static boolean checkNumber(JTextField field, StringBuilder sb) {
        boolean flag = true;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(field.getText());
        if (matcher.find()) {
            sb.append("Tên Không Có Số");
            field.setBackground(Color.red);
            flag = true;
        } else {
            field.setBackground(Color.white);
        }
        return flag;
    }
}
