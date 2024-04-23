
public class gameBoard {

    int grids = 4;

    int border = 0;

    public int score = 0;
    
    public Tile[][] gameBoard;


    
    public gameBoard()
    {
        gameBoard = new Tile[4][4];
        for ( int i = 0; i < gameBoard.length; i++ )
        {
            for ( int j = 0; j < gameBoard[i].length; j++ )
            {
                gameBoard[i][j] = new Tile();
            }
        }
    }


   
    public gameBoard( int grids )
    {
        this.grids = grids;
        gameBoard = new Tile[grids][grids];
        for ( int i = 0; i < gameBoard.length; i++ )
        {
            for ( int j = 0; j < gameBoard[i].length; j++ )
            {
                gameBoard[i][j] = new Tile();
            }
        }
    }


  
    public gameBoard( int lose, int grids )
    {
        this.grids = grids;
        gameBoard = new Tile[grids][grids];
        for ( int i = 0; i < gameBoard.length; i++ )
        {
            for ( int j = 0; j < gameBoard[i].length; j++ )
            {
                gameBoard[i][j] = new Tile( ( lose + i + j ) * ( i + j ) );
            }
        }
    }


  
    public Tile[][] getgameBoard()
    {
        return gameBoard;
    }


    public int getScore()
    {
        return score;
    }


 
    public int getHighTile()
    {
        int high = gameBoard[0][0].getValue();
        for ( int i = 0; i < gameBoard.length; i++ )
        {
            for ( int j = 0; j < gameBoard[i].length; j++ )
            {
                if ( gameBoard[i][j].getValue() > high )
                {
                    high = gameBoard[i][j].getValue();
                }
            }
        }
        return high;
    }


    public void print()
    {
        for ( int i = 0; i < gameBoard.length; i++ )
        {
            for ( int j = 0; j < gameBoard[i].length; j++ )
            {
                String s = gameBoard[i][j].toString() + " ";
                System.out.print( s );
            }
            System.out.println( "" );
        }
        System.out.println( "Score: " + score );
    }


    public String toString()
    {
        String s = "";
        for ( int i = 0; i < gameBoard.length; i++ )
        {
            for ( int j = 0; j < gameBoard[i].length; j++ )
            {
                s += gameBoard[i][j].toString() + " ";
            }
            s += "\n";
        }
        return s;
    }


    public void spawn()
    {
        boolean empty = true;
        while ( empty )
        {
            int row = (int)( Math.random() * 4 );
            int col = (int)( Math.random() * 4 );
            double x = Math.random();
            if ( gameBoard[row][col].getValue() == 0 )
            {
                if ( x < 0.2 )
                {
                    gameBoard[row][col] = new Tile( 4 );
                    empty = false;
                }
                else
                {
                    gameBoard[row][col] = new Tile( 2 );
                    empty = false;
                }
            }

        }

    }


   
    public boolean blackOut()
    {
        int count = 0;
        for ( int i = 0; i < gameBoard.length; i++ )
        {
            for ( int j = 0; j < gameBoard[i].length; j++ )
            {
                if ( gameBoard[i][j].getValue() > 0 )
                {
                    count++;
                }
            }
        }
        if ( count == 16 )
        {
            return true;
        }
        return false;
    }


    public boolean gameOver()
    {
        int count = 0;
        for ( int i = 0; i < gameBoard.length; i++ )
        {
            for ( int j = 0; j < gameBoard[i].length; j++ )
            {
                if ( gameBoard[i][j].getValue() > 0 )
                {
                    if ( i == 0 && j == 0 )
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i + 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 3 )
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i + 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 3 )
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i - 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 0 )
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i - 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 ) )
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i + 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j + 1].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && ( j == 1 || j == 2 ) )
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i - 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j + 1].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 ) )
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i][j + 1].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i - 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 3 && ( i == 1 || i == 2 ) )
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i][j - 1].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i - 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else
                    {
                        if ( gameBoard[i][j].getValue() != gameBoard[i][j - 1].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i][j + 1].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i - 1][j].getValue()
                            && gameBoard[i][j].getValue() != gameBoard[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                }
            }
        }
        if ( count == 16 )
        {
            return true;
        }
        return false;
    }


    public void up()
    {
        for ( int i = 0; i < grids; i++ )
        {
            border = 0;
            for ( int j = 0; j < grids; j++ )
            {
                if ( gameBoard[j][i].getValue() != 0 )
                {
                    if ( border <= j )
                    {
                        verticalMove( j, i, "up" );
                    }
                }
            }
        }
    }



    public void down()
    {
        for ( int i = 0; i < grids; i++ )
        {
            border = ( grids - 1 );
            for ( int j = grids - 1; j >= 0; j-- )
            {
                if ( gameBoard[j][i].getValue() != 0 )
                {
                    if ( border >= j )
                    {
                        verticalMove( j, i, "down" );
                    }
                }
            }
        }
    }


    private void verticalMove( int row, int col, String direction )
    {
        Tile initial = gameBoard[border][col];
        Tile compare = gameBoard[row][col];
        if ( initial.getValue() == 0 || initial.getValue() == compare.getValue() )
        {
            if ( row > border || ( direction.equals( "down" ) && ( row < border ) ) )
            {
                int addScore = initial.getValue() + compare.getValue();
                if ( initial.getValue() != 0 )
                {
                    score += addScore;
                }
                initial.setValue( addScore );
                compare.setValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "down" ) )
            {
                border--;
            }
            else
            {
                border++;
            }
            verticalMove( row, col, direction );
        }
    }


 
    public void left()
    {
        for ( int i = 0; i < grids; i++ )
        {
            border = 0;
            for ( int j = 0; j < grids; j++ )
            {
                if ( gameBoard[i][j].getValue() != 0 )
                {
                    if ( border <= j )
                    {
                        horizontalMove( i, j, "left" );
                    }
                }
            }
        }
    }


    public void right()
    {
        for ( int i = 0; i < grids; i++ )
        {
            border = ( grids - 1 );
            for ( int j = ( grids - 1 ); j >= 0; j-- )
            {
                if ( gameBoard[i][j].getValue() != 0 )
                {
                    if ( border >= j )
                    {
                        horizontalMove( i, j, "right" );
                    }
                }
            }
        }
    }


  
    private void horizontalMove( int row, int col, String direction )
    {
        Tile initial = gameBoard[row][border];
        Tile compare = gameBoard[row][col];
        if ( initial.getValue() == 0 || initial.getValue() == compare.getValue() )
        {
            if ( col > border || ( direction.equals( "right" ) && ( col < border ) ) )
            {
                int addScore = initial.getValue() + compare.getValue();
                if ( initial.getValue() != 0 )
                {
                    score += addScore;
                }
                initial.setValue( addScore );
                compare.setValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "right" ) )
            {
                border--;
            }
            else
            {
                border++;
            }
            horizontalMove( row, col, direction );
        }
    }
}
