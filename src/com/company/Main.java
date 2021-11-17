package com.company;

public class Main {

    // сделал 20 методов только потому, что не получается зарандомить количество шагов,
    // в таком случае просто выполняю код либо до определенного метода, либо все 20 преобразований
    public static void main(String[] args) {
        int M = 10, N = 10;
        int[][] grid = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //здесь можно задать исходный рисунок, где 0 мертвые, а 1 - живые клетки
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        System.out.println("Изначальное положение");
        for (int i = 0; i < M; i++) // цикл для вывода рисунка в виде точек(мертвых клеток) и звездочек(живых клеток)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0){
                System.out.print(".");
            }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
        oneGeneration(grid, M, N);
    }
    static void oneGeneration(int[][] grid, int M, int N)
    {
        int[][] future = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                grid[l + i][m + j];
                aliveNeighbours -= grid[l][m];
                if ((grid[l][m] == 1) &&
                (aliveNeighbours < 2))
                future[l][m] = 0;

                else if ((grid[l][m] == 1) &&
                (aliveNeighbours > 3))
                future[l][m] = 0;

                else if ((grid[l][m] == 0) &&
                (aliveNeighbours == 3))
                future[l][m] = 1;

                else
                future[l][m] = grid[l][m];
            }
        }

        System.out.println("1 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future[i][j] == 0)
                System.out.print(".");
                else
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        twoGeneration(future, M, N);
    }
    static void twoGeneration(int[][] future, int M, int N)
    {
        int[][] future1 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future[l + i][m + j];
                aliveNeighbours -= future[l][m];
                if ((future[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future1[l][m] = 0;

                else if ((future[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future1[l][m] = 0;

                else if ((future[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future1[l][m] = 1;

                else
                    future1[l][m] = future[l][m];
            }
        }

        System.out.println("3 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future1[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        threeGeneration(future1, M, N);
    }
    static void threeGeneration(int[][] future1, int M, int N)
    {
        int[][] future2 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future1[l + i][m + j];
                aliveNeighbours -= future1[l][m];
                if ((future1[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future2[l][m] = 0;

                else if ((future1[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future2[l][m] = 0;

                else if ((future1[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future2[l][m] = 1;

                else
                    future2[l][m] = future1[l][m];
            }
        }

        System.out.println("4 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future2[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        fourGeneration(future2, M, N);
    }
    static void fourGeneration(int[][] future2, int M, int N)
    {
        int[][] future3 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future2[l + i][m + j];
                aliveNeighbours -= future2[l][m];
                if ((future2[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future3[l][m] = 0;

                else if ((future2[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future3[l][m] = 0;

                else if ((future2[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future3[l][m] = 1;

                else
                    future3[l][m] = future2[l][m];
            }
        }

        System.out.println("5 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future3[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        fiveGeneration(future3, M, N);
    }
    static void fiveGeneration(int[][] future3, int M, int N)
    {
        int[][] future4 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future3[l + i][m + j];
                aliveNeighbours -= future3[l][m];
                if ((future3[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future4[l][m] = 0;

                else if ((future3[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future4[l][m] = 0;

                else if ((future3[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future4[l][m] = 1;

                else
                    future4[l][m] = future3[l][m];
            }
        }

        System.out.println("6 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future4[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        sixGeneration(future4, M, N);
    }
    static void sixGeneration(int[][] future4, int M, int N)
    {
        int[][] future5 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future4[l + i][m + j];
                aliveNeighbours -= future4[l][m];
                if ((future4[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future5[l][m] = 0;

                else if ((future4[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future5[l][m] = 0;

                else if ((future4[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future5[l][m] = 1;

                else
                    future5[l][m] = future4[l][m];
            }
        }

        System.out.println("7 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future5[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        sevenGeneration(future5, M, N);
    }
    static void sevenGeneration(int[][] future5, int M, int N)
    {
        int[][] future6 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future5[l + i][m + j];
                aliveNeighbours -= future5[l][m];
                if ((future5[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future6[l][m] = 0;

                else if ((future5[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future6[l][m] = 0;

                else if ((future5[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future6[l][m] = 1;

                else
                    future6[l][m] = future5[l][m];
            }
        }

        System.out.println("8 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future6[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        eightGeneration(future6, M, N);
    }
    static void eightGeneration(int[][] future6, int M, int N)
    {
        int[][] future7 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future6[l + i][m + j];
                aliveNeighbours -= future6[l][m];
                if ((future6[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future7[l][m] = 0;

                else if ((future6[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future7[l][m] = 0;

                else if ((future6[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future7[l][m] = 1;

                else
                    future7[l][m] = future6[l][m];
            }
        }

        System.out.println("9 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future7[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nineGeneration(future7, M, N);
    }
    static void nineGeneration(int[][] future7, int M, int N)
    {
        int[][] future8 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future7[l + i][m + j];
                aliveNeighbours -= future7[l][m];
                if ((future7[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future8[l][m] = 0;

                else if ((future7[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future8[l][m] = 0;

                else if ((future7[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future8[l][m] = 1;

                else
                    future8[l][m] = future7[l][m];
            }
        }

        System.out.println("10 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future8[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        tenGeneration(future8, M, N);
    }
    static void tenGeneration(int[][] future8, int M, int N)
    {
        int[][] future9 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future8[l + i][m + j];
                aliveNeighbours -= future8[l][m];
                if ((future8[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future9[l][m] = 0;

                else if ((future8[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future9[l][m] = 0;

                else if ((future8[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future9[l][m] = 1;

                else
                    future9[l][m] = future8[l][m];
            }
        }

        System.out.println("11 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future9[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        elevenGeneration(future9, M, N);
    }
    static void elevenGeneration(int[][] future9, int M, int N)
    {
        int[][] future10 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future9[l + i][m + j];
                aliveNeighbours -= future9[l][m];
                if ((future9[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future10[l][m] = 0;

                else if ((future9[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future10[l][m] = 0;

                else if ((future9[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future10[l][m] = 1;

                else
                    future10[l][m] = future9[l][m];
            }
        }

        System.out.println("12 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future10[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        twelveGeneration(future10, M, N);
    }
    static void twelveGeneration(int[][] future10, int M, int N)
    {
        int[][] future11 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future10[l + i][m + j];
                aliveNeighbours -= future10[l][m];
                if ((future10[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future11[l][m] = 0;

                else if ((future10[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future11[l][m] = 0;

                else if ((future10[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future11[l][m] = 1;

                else
                    future11[l][m] = future10[l][m];
            }
        }

        System.out.println("13 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future11[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        thirteenGeneration(future11, M, N);
    }
    static void thirteenGeneration(int[][] future11, int M, int N)
    {
        int[][] future12 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future11[l + i][m + j];
                aliveNeighbours -= future11[l][m];
                if ((future11[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future12[l][m] = 0;

                else if ((future11[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future12[l][m] = 0;

                else if ((future11[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future12[l][m] = 1;

                else
                    future12[l][m] = future11[l][m];
            }
        }

        System.out.println("14 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future12[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        fourteenGeneration(future12, M, N);
    }
    static void fourteenGeneration(int[][] future12, int M, int N)
    {
        int[][] future13 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future12[l + i][m + j];
                aliveNeighbours -= future12[l][m];
                if ((future12[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future13[l][m] = 0;

                else if ((future12[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future13[l][m] = 0;

                else if ((future12[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future13[l][m] = 1;

                else
                    future13[l][m] = future12[l][m];
            }
        }

        System.out.println("15 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future13[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        fifteenGeneration(future13, M, N);
    }
    static void fifteenGeneration(int[][] future13, int M, int N)
    {
        int[][] future14 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future13[l + i][m + j];
                aliveNeighbours -= future13[l][m];
                if ((future13[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future14[l][m] = 0;

                else if ((future13[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future14[l][m] = 0;

                else if ((future13[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future14[l][m] = 1;

                else
                    future14[l][m] = future13[l][m];
            }
        }

        System.out.println("16 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future14[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        sixteenGeneration(future14, M, N);
    }
    static void sixteenGeneration(int[][] future14, int M, int N)
    {
        int[][] future15 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future14[l + i][m + j];
                aliveNeighbours -= future14[l][m];
                if ((future14[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future15[l][m] = 0;

                else if ((future14[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future15[l][m] = 0;

                else if ((future14[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future15[l][m] = 1;

                else
                    future15[l][m] = future14[l][m];
            }
        }

        System.out.println("16 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future15[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        seventeenGeneration(future15, M, N);
    }
    static void seventeenGeneration(int[][] future15, int M, int N)
    {
        int[][] future16 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future15[l + i][m + j];
                aliveNeighbours -= future15[l][m];
                if ((future15[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future16[l][m] = 0;

                else if ((future15[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future16[l][m] = 0;

                else if ((future15[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future16[l][m] = 1;

                else
                    future16[l][m] = future15[l][m];
            }
        }

        System.out.println("17 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future16[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        eighteenGeneration(future16, M, N);
    }
    static void eighteenGeneration(int[][] future16, int M, int N)
    {
        int[][] future17 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future16[l + i][m + j];
                aliveNeighbours -= future16[l][m];
                if ((future16[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future17[l][m] = 0;

                else if ((future16[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future17[l][m] = 0;

                else if ((future16[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future17[l][m] = 1;

                else
                    future17[l][m] = future16[l][m];
            }
        }

        System.out.println("18 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future17[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nineteenGeneration(future17, M, N);
    }
    static void nineteenGeneration(int[][] future17, int M, int N)
    {
        int[][] future18 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours +=
                                future17[l + i][m + j];
                aliveNeighbours -= future17[l][m];
                if ((future17[l][m] == 1) &&
                        (aliveNeighbours < 2))
                    future18[l][m] = 0;

                else if ((future17[l][m] == 1) &&
                        (aliveNeighbours > 3))
                    future18[l][m] = 0;

                else if ((future17[l][m] == 0) &&
                        (aliveNeighbours == 3))
                    future18[l][m] = 1;

                else
                    future18[l][m] = future17[l][m];
            }
        }

        System.out.println("19 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future18[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        twentyGeneration(future18, M, N);
    }
    static void twentyGeneration(int[][] future18, int M, int N)
    {
        int[][] future19 = new int[M][N];
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                int aliveNeighbours19 = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours19 +=
                                future18[l + i][m + j];
                aliveNeighbours19 -= future18[l][m];
                if ((future18[l][m] == 1) &&
                        (aliveNeighbours19 < 2))
                    future19[l][m] = 0;

                else if ((future18[l][m] == 1) &&
                        (aliveNeighbours19 > 3))
                    future19[l][m] = 0;

                else if ((future18[l][m] == 0) &&
                        (aliveNeighbours19 == 3))
                    future19[l][m] = 1;

                else
                    future19[l][m] = future18[l][m];
            }
        }

        System.out.println("20 преобразование");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future19[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

}
