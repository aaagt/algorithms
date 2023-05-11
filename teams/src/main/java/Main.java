import java.util.Arrays;

public class Main {

    public static final int TEAM_SIZE = 10;

    public static void main(String[] args) {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        int[] mergedTeam = teams[0];

        for (int i = 1; i < teams.length; i++) {
            mergedTeam = merge(mergedTeam, teams[i]);
        }

        return mergedTeam;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int indexA = 0;
        int indexB = 0;

        int[] mergedTeam = new int[TEAM_SIZE];

        for (int i = 0; i < TEAM_SIZE; i++) {
            if (teamA[indexA] > teamB[indexB]) {
                mergedTeam[i] = teamA[indexA];
                indexA++;
            } else {
                mergedTeam[i] = teamB[indexB];
                indexB++;
            }
        }

        return mergedTeam;
    }
}