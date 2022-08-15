package com.kgh.tdd.training;

import javax.swing.text.html.Option;
import java.util.Optional;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s){
        Optional<String> ss = Optional.ofNullable(s);
        if(ss.isEmpty()){
            return PasswordStrength.INVALID;
        }
        boolean lengthEnough = s.length() >= 8;
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUpper = meetContainingUppercaseCriteria(s);
/*        if(s.length() < 8){
            return PasswordStrength.NORMAL;
        }*/
        if(lengthEnough && !containsNum && !containsUpper){
            return PasswordStrength.WEAK;
        }
        if(!lengthEnough && containsNum && !containsUpper){
            return PasswordStrength.WEAK;
        }
        if(!lengthEnough && !containsNum && containsUpper){
            return PasswordStrength.WEAK;
        }

        if(!lengthEnough){
            return PasswordStrength.NORMAL;
        }
        if(!containsNum){
            return PasswordStrength.NORMAL;
        }
        if(!containsUpper){
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private boolean meetContainingUppercaseCriteria(String s) {
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String s){
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                return true;
            }
        }
        return false;
    }
}
