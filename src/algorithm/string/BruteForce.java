package algorithm.string;

/*
* # 브루트-포스법
* - 선형검색하며 패턴 문자열과 대상 문자열의 철자를 하나하나 비교
* - 단점 : 동일한 철자에 대해 중복 검사 발생 가능
*
* */
public class BruteForce implements StringAlgorithm {
    @Override
    public int searchString(String str, String pattern) {
        int strp = 0;
        int patp = 0;

        while (strp < str.length() && patp < pattern.length()) {
            if (str.charAt(strp) == pattern.charAt(patp)) {
                strp++;
                patp++;
            }
            else {
                strp = strp - patp + 1;
                patp = 0;
            }
        }
        if (patp == pattern.length()) return strp - patp;
        else return -1;
    }
}
