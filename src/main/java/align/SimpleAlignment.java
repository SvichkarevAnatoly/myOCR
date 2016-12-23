package align;

public class SimpleAlignment {
    // штрафы
    private int deletion;
    private int mismatch;

    private String str1;
    private String str2;

    private int s1Len;
    private int s2Len;

    private int score[][];
    private char backtrack[][];

    public SimpleAlignment(int deletion, int mismatch) {
        this.deletion = deletion;
        this.mismatch = mismatch;
    }

    public int align(String string1, String string2) {
        str1 = string1;
        str2 = string2;
        s1Len = string1.length();
        s2Len = string2.length();

        initMatrices();
        fillMatrices();

        return score[s2Len][s1Len];
    }

    public void initMatrices() {
        score = initIntMatrix();
        backtrack = initCharMatrix();

        initBoarders();
    }

    private int[][] initIntMatrix() {
        final int[][] matrix = new int[s2Len + 1][];
        for (int i = 0; i < s2Len + 1; i++) {
            matrix[i] = new int[s1Len + 1];
        }

        return matrix;
    }

    private char[][] initCharMatrix() {
        final char[][] matrix = new char[s2Len][];
        for (int i = 0; i < s2Len; i++) {
            matrix[i] = new char[s1Len];
        }

        return matrix;
    }

    private void initBoarders() {
        for (int i = 1; i <= s2Len; i++) {
            score[i][0] = -deletion * i;
        }
        for (int i = 1; i <= s1Len; i++) {
            score[0][i] = -deletion * i;
        }
    }

    private void fillMatrices() {
        fillScoreMatrix();
        fillBacktrack();
    }

    private void fillScoreMatrix() {
        for (int i = 1; i < s2Len + 1; i++) {
            for (int j = 1; j < s1Len + 1; j++) {
                final int up = score[i - 1][j] - deletion;
                final int left = score[i][j - 1] - deletion;

                final int adding = str2.charAt(i - 1) == str1.charAt(j - 1) ? 1 : -mismatch;
                final int diag = score[i - 1][j - 1] + adding;

                final int maxUpLeft = Math.max(up, left);
                score[i][j] = Math.max(maxUpLeft, diag);
            }
        }
    }

    private void fillBacktrack() {
        for (int i = 1; i < s2Len + 1; i++) {
            for (int j = 1; j < s1Len + 1; j++) {
                if (score[i][j] == score[i - 1][j] - deletion) {
                    // TODO: вынести в константы
                    backtrack[i - 1][j - 1] = '↓';
                } else if (score[i][j] == score[i][j-1]){
                    backtrack[i - 1][j - 1] = '→';
                } else {
                    backtrack[i - 1][j - 1] = '↘';
                }
            }
        }
    }
}
