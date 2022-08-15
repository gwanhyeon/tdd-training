package com.kgh.tdd.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    /*
    - 길이가 8글자 이상
    - 0부터 9사이의 숫자를 포함
    - 대문자 포함
    단, 3가지 충족 시 강함, 2가지 보통, 1가지 약함
     */
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }
    @Test
    @DisplayName("1.비밀번호 강함 테스트 - 모든 규칙을 충족하는 경우")
    void meetsAllCriteriaThanStrong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
        /*PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("abc1!Add");
        assertEquals(PasswordStrength.STRONG, result2);*/
    }
    @Test
    @DisplayName("2.비밀번호 보통 테스트 - 길이만 8글자 미만이고 나머지 조건은 충족하는경우")
    void meetsOtherCriteria_except_for_length_then_normal(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);

        /*PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);
        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL, result2);*/
    }

    @Test
    @DisplayName("3.비밀번호 보통 테스트 - 숫자를 포함하지 않고 나머지조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_number_then_normal(){
        assertStrength("ab!@Abqwer", PasswordStrength.NORMAL);
        /*PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);*/
    }

    @Test
    @DisplayName("4.비밀번호 값이 없는 경우")
    void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("5.비밀번호 보통 테스트 - 대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("6.비밀번호 약함 테스트 - 길이가 8글자 이상인 조건만 충족하는 경우")
    void meetOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("7.숫자 포함조건만 충족하는 경우")
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("8.대문자 포함 조건만 충족하는 경우")
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("9.아무조건도 충족하지 않은 경우")
    void meetNoCriteria_Then_Weak(){
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
