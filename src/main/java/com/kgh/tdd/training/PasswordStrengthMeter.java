package com.kgh.tdd.training;

import javax.swing.text.html.Option;
import java.util.Optional;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s){
        Optional<String> ss = Optional.ofNullable(s);
        if(ss.isEmpty()){
            return PasswordStrength.INVALID;
        }
        int metCounts = getMetCriteriaCounts(s);
        if(metCounts <= 1){
            return PasswordStrength.WEAK;
        }
        if(metCounts == 2){
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if(s.length() >= 8){
            metCounts++;
        }
        if(meetsContainingNumberCriteria(s)){
            metCounts++;
        }
        if(meetContainingUppercaseCriteria(s)){
            metCounts++;
        }
        return metCounts;
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
