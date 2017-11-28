//----------------------------------------------------------------------------
// File:	SinkTheFleetleet.cpp
// 
// Function:
//      main()
//----------------------------------------------------------------------------

#include <iostream>
#include <iomanip>
#include "fleet.h"
using namespace std;
extern const char* shipNames[7];
//---------------------------------------------------------------------------------
// Function:	main()
// Title:		Set ShipInfo
// Description:
//				Runs the Sink the Fleet Game
// Programmer:	Paul Bladek
// modified by: Wilson Gautama & Huy Nguyen
// 
// Date:		02/03/2015
//
// Version:		0.5
// 
// Environment: Hardware: i3 
//              Software: OS: Windows 7; 
//              Compiles under Microsoft Visual C++ 2012
//
// Input:		from console
//
// Output:		to screen
//
// Calls:		initializePlayer()
//				allocMem()
//				safeChoice()
//				getGrid()
//				printGrid()
//				resetGrid()
//				setships()
//				header()
//				getCoord()
//				deleteMem()
//				endBox()
//
// Called By:	n/a
//
// Parameters:	void
// 
// Returns:		int -- EXIT_SUCCESS upon successful completion
//
// History Log: 
//				12/9/2012 PB completed v 0.5
//				2/3/2015 WG & HN completed v 1.0
//   
//---------------------------------------------------------------------------------
int main(void)
{
	short numRows = SMALLROWS;		// total number of rows in the array
	short numCols = SMALLCOLS;		// total number of columns in the array
	char again = 'N';
	char gridSize = 'S';
	short whichPlayer = 0;
	bool gameOver = false;
	bool reshot = false;

	char loadFile;

	Cell coord = {0, 0};
	string message;
	string filename;
	Ship shipHit = NOSHIP;
	Player game[NUMPLAYERS] ;

	do
	{
		gameOver = false;
		system("cls");
		cout << endl;
		header(cout);
		gridSize = safeChoice("Which size grid to you want to use", 'S', 'L');
		
		if( gridSize == 'L')
		{
			numRows = LARGEROWS;
			numCols = LARGECOLS;
		}
		else
		{
			numRows = SMALLROWS;
			numCols = SMALLCOLS;
		}
		initializePlayer(game);		
		initializePlayer(game + 1);
		// dynamically create the rows of the array
		allocMem(game, gridSize);

		for(whichPlayer = 0; whichPlayer < NUMPLAYERS; whichPlayer++)
		{		
			bool moveOn = false;
			while(!moveOn)
			{
				cout << "Player " << whichPlayer + 1 << ", ";
				loadFile = safeChoice("Do you want to load file? ", 'Y', 'N');
				if(loadFile == 'Y')
				{
					try
					{
						string fileName;
						cout << "Please enter the file name " << endl;
						cin >> fileName;
						bool isGoodGrid = getGrid(game, whichPlayer, gridSize, 
							fileName);
						if(!isGoodGrid) //for bad file
						{
						
							cout << "Please press <enter> to continue. " << 
								endl;
							cin.get();
							system("cls");
						}
						else
						{
							printGrid(cout, game[whichPlayer].m_gameGrid[0], 
								gridSize);
							moveOn = isGoodGrid;
							cin.get();
						}
					}
					catch (int e) //for wrong size
					{
						cout << "Please press <enter> to continue. " << endl;
						cin.get();
						cin.get();
						system("cls");
					}
				}
				else
				{
					// enter grid files or let users enter ships
					setships(game, gridSize, whichPlayer);
					system("cls");
					printGrid(cout, game[whichPlayer].m_gameGrid[0], 
						gridSize);
				}
			}
			cout << "Press enter to continue" << endl;
			cin.get();
			system("cls");
		}
		
		whichPlayer = 0;

		cout << "Press <enter> to start the battle" ;
		cin.get();

		//battle begin
		while(!gameOver)
		{
			system("cls");
			printGrid(cout, game[whichPlayer].m_gameGrid[1], gridSize);
			
			cout << "Player " << whichPlayer + 1 << 
				" Enter fire coordinates for firing: " << endl;
			coord = getCoord(cin, gridSize);

			while (game[whichPlayer].m_gameGrid[1][coord.m_row]
			[coord.m_col] != NOSHIP)
			{
				
				char column = '\0';
				switch (coord.m_row)
				{
					case 1: column = 'B';
						break;
					case 2: column = 'C';
						break;
					case 3: column = 'D';
						break;
					case 4: column = 'E';
						break;
					case 5: column = 'F';
						break;
					case 6: column = 'G';
						break;
					case 7: column = 'H';
							break;
					case 8: column = 'I';
						break;
					case 9: column = 'J';
						break;
					default: column = 'A';
						break;
				}
				cout << "You already shot at " << column << coord.m_col + 1 
					<< endl;
				cout << "Player " << whichPlayer + 1 <<
					" Enter fire coordinates for firing: " << endl;
				coord = getCoord(cin, gridSize);
			}

			if(game[whichPlayer].m_gameGrid[1][coord.m_row][coord.m_col] !=
					game[!whichPlayer].m_gameGrid[0][coord.m_row][coord.m_col])
			{
				game[whichPlayer].m_gameGrid[1][coord.m_row][coord.m_col] = 
					HIT;
				game[!whichPlayer].m_piecesLeft -= 1;
				system("cls");
				printGrid(cout, game[whichPlayer].m_gameGrid[1], gridSize);
				cout << "HIT. GOOD JOB" << endl;

				//check ship sinking
				switch (game[!whichPlayer].m_gameGrid[0][coord.m_row]
					[coord.m_col])
				{
					case (MINESWEEPER):
						game[whichPlayer].m_ships[1].m_piecesLeft -= 1;
						if(game[whichPlayer].m_ships[1].m_piecesLeft == 0)		
							cout << enumReturn(MINESWEEPER) + " sunk" << endl;
						break;
					case (FRIGATE):
						game[whichPlayer].m_ships[2].m_piecesLeft -= 1;
						if(game[whichPlayer].m_ships[2].m_piecesLeft == 0)		
							cout << enumReturn(FRIGATE) + " sunk" << endl;
						break;
					case (SUB):
						game[whichPlayer].m_ships[3].m_piecesLeft -= 1;
						if(game[whichPlayer].m_ships[3].m_piecesLeft == 0)		
							cout << enumReturn(SUB) + " sunk" << endl;
						break;
					case (BATTLESHIP):
						game[whichPlayer].m_ships[4].m_piecesLeft -= 1;
						if(game[whichPlayer].m_ships[4].m_piecesLeft == 0)		
							cout << enumReturn(BATTLESHIP) + " sunk" << endl;
						break;
					case (CARRIER):
						game[whichPlayer].m_ships[5].m_piecesLeft -= 1;
						if(game[whichPlayer].m_ships[5].m_piecesLeft == 0)		 
							cout << enumReturn(CARRIER) + " sunk" << endl;
						break;
				}

				cout << "Press <enter>" ;
				cin.get();
				if(game[!whichPlayer].m_piecesLeft == 0)
					gameOver = true;
			}
			else
			{
				game[whichPlayer].m_gameGrid[1][coord.m_row][coord.m_col] = 
					MISSED;
				system("cls");
				printGrid(cout, game[whichPlayer].m_gameGrid[1], gridSize);
				cout << "MISSED. Better luck next time." << endl;
				cout << "Press <enter>" ;
				cin.get();
				//switch player
				whichPlayer = !whichPlayer;
			}
		}
		again = safeChoice("Would you like to play again?", 'Y', 'N');
	}while(again == 'Y');

	return EXIT_SUCCESS;
} 
