package algorithm.string;

public class BoyerMoore implements StringAlgorithm {
    @Override
    public int searchString(String str, String pattern) {
        final int STR_LENGTH = str.length();
        final int PAT_LENGTH = pattern.length();
        int strp;
        int patp;
        int[] skip = new int[Character.MAX_VALUE + 1];

        for (strp = 0; strp <= Character.MAX_VALUE; strp++) {
            skip[strp] = PAT_LENGTH;
        }

        for (strp = 0; strp < PAT_LENGTH - 1; strp++) {
            skip[pattern.charAt(strp)] = PAT_LENGTH - strp - 1;
        }

        while (strp < STR_LENGTH) {
            patp = PAT_LENGTH - 1;

            while (str.charAt(strp) == pattern.charAt(patp)) {
                if (patp == 0) return strp;
                patp--;
                strp--;
            }
            strp += (skip[str.charAt(strp)] > PAT_LENGTH - patp) ? skip[str.charAt(strp)] : PAT_LENGTH - patp;
        }

        return -1;
    }
}
