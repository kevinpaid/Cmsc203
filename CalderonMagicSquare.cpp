#include <iostream>
#include <iomanip>
#include <cmath>
#include <vector>
#include <string>
using namespace std;

// Global constants 
const int ROWS = 3;  // The number of rows in the array
const int COLS = 3;  // The number of columns in the array
const int MIN = 1;  // The value of the smallest number
const int MAX = 9;  // The value of the largest number
const string PROGRAMMER = "Kevin Calderon";
const string PROJECT_NUM = "Project 5";
const string DUE_DATE = "August 1st, 2023";



// Function prototypes
bool isMagicSquare(bool a, bool b, bool c, bool d, bool e);
bool checkRange(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size, int min, int max);
bool checkUnique(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
bool checkRowSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
bool checkColSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
bool checkDiagSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
void fillArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);
void showArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size);

int main()
{
	bool checkedRowSum = false;
    bool checkedColSum = false;
    bool checkedDiagSum = false;
    bool checkedUnique = false;
    bool checkedRange = false;
    bool checkedIfMagicSquare = false;
    char choice;
	/* Define a Lo Shu Magic Square using 3 parallel arrays corresponding for each row of the grid */
	int magicArrayRow1[COLS], magicArrayRow2[COLS], magicArrayRow3[COLS];

    do
    {
    fillArray (magicArrayRow1, magicArrayRow2, magicArrayRow3, ROWS);
    
    showArray (magicArrayRow1, magicArrayRow2, magicArrayRow3, ROWS);

    checkedRowSum = checkRowSum   (magicArrayRow1, magicArrayRow2, magicArrayRow3, ROWS);

    checkedColSum = checkRowSum   (magicArrayRow1, magicArrayRow2, magicArrayRow3, ROWS);

    checkedDiagSum = checkDiagSum (magicArrayRow1, magicArrayRow2, magicArrayRow3, ROWS);

    checkedUnique = checkUnique (magicArrayRow1, magicArrayRow2, magicArrayRow3, ROWS);

    checkedRange = checkRange (magicArrayRow1, magicArrayRow2, magicArrayRow3, ROWS, MIN, MAX);

    checkedIfMagicSquare = isMagicSquare (checkedRowSum, checkedColSum, checkedDiagSum, checkedUnique, checkedRange);

    if ( checkedIfMagicSquare)
        cout << "This is a Lo Shu magic square." << endl << endl;
    else
        cout << "This is not a Lo Shu magic square." << endl << endl;

    cout << "Do you want to try again? ";
    cin >> choice;
    


    

    }while ( choice == 'y' || choice == 'Y');

    cout << PROGRAMMER << endl;
    cout << PROJECT_NUM << endl;
    cout << DUE_DATE << endl;



    return 0;
}
// Function definitions go here
void fillArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) // 1st function/method
{
    for (int index = 0, row = 1; index < ROWS; index++)
    {
        cout << "Enter the number for row " << row  << " and colum " << index + 1 << " : ";
        cin >> arrayRow1[index];
    }

    for (int index = 0, row = 2; index < ROWS; index++)
    {
        cout << "Enter the number for row " << row  << " and colum " << index + 1 << " : ";
        cin >> arrayRow2[index];
    }

    for (int index = 0, row = 3; index < ROWS; index++)
    {
        cout << "Enter the number for row " << row  << " and colum " << index + 1 << " : ";
        cin >> arrayRow3[index];
    }

}




void showArray(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) // 2nd function/method
{
    for (int index = 0; index < ROWS; index++)
    {
        cout << arrayRow1[index] << " ";
    }
    cout << endl;
    for (int index = 0; index < ROWS; index++)
    {
        cout << arrayRow2[index] << " ";
    }
    cout << endl;
    for (int index = 0; index < ROWS; index++)
    {
        cout << arrayRow3[index] << " ";
    }
    cout << endl;
}




bool checkRowSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) // 3rd function/method
{
    bool checkRowSum = false;
    int total1 = 0;
    int total2 = 0;
    int total3 = 0;
    
    for (int index = 0; index < ROWS; index++)
    {
        total1 += arrayRow1[index];
    }
    for (int index = 0; index < ROWS; index++)
    {
        total2 += arrayRow2[index];
    }
    for (int index = 0; index < ROWS; index++)
    {
        total3 += arrayRow3[index];
    }

    if ( total1 == total2 && total2 == total3)
        checkRowSum = true;

    return checkRowSum;
}




bool checkColSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) // 4th function/method
{
    bool checkColSum = false;
    int total1 = 0;
    int total2 = 0;
    int total3 = 0;

    for ( int index = 0; index < COLS; index++ )
    {
        if ( index == 0 )
            total1 += arrayRow1[index] + arrayRow2[index] + arrayRow3[index];
        else if ( index == 1 )
            total2 += arrayRow1[index] + arrayRow2[index] + arrayRow3[index];
        else if ( index == 2) 
            total3 += arrayRow1[index] + arrayRow2[index] + arrayRow3[index];
    }

    if ( total1 == total2 && total2 == total3 )
        checkColSum = true;

    return checkColSum;
}




bool checkDiagSum(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) // 5th function/method
{
    bool checkDiagSum = false;
    int total1 = 0;
    int total2 = 0;

    for ( int index = 0; index < ROWS; index++ )
    {
        if ( index == 0 )
        {
            total1 += arrayRow1[index];
            total2 += arrayRow3[index];
        }
        else if ( index == 1 )
        {
            total1 += arrayRow2[index];
            total2 += arrayRow2[index];
        }
        else if ( index == 2 )
        {
            total1 += arrayRow1[index];
            total2 += arrayRow3[index];
        }
    }

    if ( total1 == total2 )
        checkDiagSum = true;
    
    return checkDiagSum;
}





bool checkUnique(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size) // 6th function/method
{
    bool checkUnique = false;

        int a;
        int b;
        int c;

        bool checkedA = false;
        bool checkedB = false;
        bool checkedC = false;

    for ( int index = 0; index < ROWS; index++ )
    {
        

        if ( index == 0 )
            a = arrayRow1[index];
        
        else if ( index == 1 )
            b = arrayRow1[index];

        else if ( index == 2 )
            c = arrayRow1[index];

            if ( a != b && b != c && a != c )
                checkedA = true;

    }

    int d;
    int e;
    int f;

    for ( int index = 0; index < ROWS; index++ )
    {
        

        if ( index == 0 )
            d = arrayRow2[index];
        
        else if ( index == 1 )
            e = arrayRow2[index];

        else if ( index == 2 )
            f = arrayRow2[index];

            if ( d != e && e != f && d != f )
                checkedB = true;

    }

    int g;
    int h;
    int i;

    for ( int index = 0; index < ROWS; index++ )
    {
        

        if ( index == 0 )
            g = arrayRow3[index];
        
        else if ( index == 1 )
            h = arrayRow3[index];

        else if ( index == 2 )
            i = arrayRow3[index];

            if ( g != h && h != i && g != i )
                checkedC = true;

    }

    if ( checkedA && checkedB && checkedC )
        checkUnique = true;

    return checkUnique;
}




bool checkRange(int arrayRow1[], int arrayRow2[], int arrayRow3[], int size, int min, int max) // 7th function/method
{
    bool checkRangee = false;

        bool a = false;
        bool b = false;
        bool c = false;

        bool checked1 = false;
        bool checked2 = false;
        bool checked3 = false;

    for ( int index = 0; index < ROWS; index++ )
    {
        

        if ( index == 0 && arrayRow1[index] >= min && arrayRow1[index] <= max  )
            a = true;
        
        else if ( index == 1 && arrayRow1[index] >= min && arrayRow1[index] <= max )
            b = true;

        else if ( index == 2 && arrayRow1[index] >= min && arrayRow1[index] <= max )
            c = true;

            if ( a && b && c )
                checked1 = true;

    }

    bool d = false;
    bool e = false;
    bool f = false;

    for ( int index = 0; index < ROWS; index++ )
    {
        
            if ( index == 0 && arrayRow2[index] >= min && arrayRow2[index] <= max  )
            d = true;
        
        else if ( index == 1 && arrayRow2[index] >= min && arrayRow2[index] <= max )
            e = true;

        else if ( index == 2 && arrayRow2[index] >= min && arrayRow2[index] <= max )
            f = true;

            if ( d && e && f )
                checked2 = true;

    }

    bool g = false;
    bool h = false;
    bool i = false;

    for ( int index = 0; index < ROWS; index++ )
    {
        

        if ( index == 0 && arrayRow3[index] >= min && arrayRow3[index] <= max  )
            g = true;
        
        else if ( index == 1 && arrayRow3[index] >= min && arrayRow3[index] <= max )
            h = true;

        else if ( index == 2 && arrayRow3[index] >= min && arrayRow3[index] <= max )
            i = true;

            if ( g && h && i )
                checked3 = true;

    }

    if ( checked1 && checked2 && checked3 )
        checkRangee = true;

        return checkRangee;

    }

    bool isMagicSquare(bool a, bool b, bool c, bool d, bool e) // 8th function/method
    {

        bool isMagicSquareX = false;

        if ( a && b && c && d && e )
            isMagicSquareX = true;

        return isMagicSquareX;


    }






