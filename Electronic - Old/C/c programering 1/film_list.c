#include <string.h>
#include <stdlib.h>
#include <stdio.h>


typedef enum
{
    HORROR, SCIFI, DRAMA, COMEDY, THRILLER, WESTERN
} category_t;


typedef struct film_t
{
    char title[50];
    int year;
    int length;
    category_t category;
    struct film_t * next;
} film_t;


void settitle(film_t * film, char title[])
{
    strncpy(film->title, title, 50);
}


void setyear(film_t * film, int year)
{
    film->year = year;
}


void setlength(film_t * film, int length)
{
    film->length = length;
}


void setcategory(film_t * film, category_t category)
{
    film->category = category;
}


void setnext(film_t * film, film_t * next)
{
    film->next = next;
}


char * gettitle(film_t * film)
{
    return film->title;
}


int getyear(film_t * film)
{
    return film->year;
}


int getlength(film_t * film)
{
    return film->length;
}


category_t getcategory(film_t * film)
{
    return film->category;
}


film_t * getnext(film_t * film)
{
    return film->next;
}


film_t * newfilm(char * name, int year, int length, category_t category)
{
    film_t * new = malloc(sizeof(film_t));

    settitle(new,name);
    setyear(new,year);
    setlength(new,length);
    setcategory(new,category);
    setnext(new,NULL);

    return new;
}


void insertfilm(film_t ** shelf, char * name, int year, int length,
                category_t category)
{
    film_t * new = newfilm(name,year,length,category);

    setnext(new,*shelf);
    *shelf = new;
}


char * categorytostring(category_t category)
{
    switch (category)
    {
        case HORROR   : return "Horror";
        case SCIFI    : return "SciFi";
        case DRAMA    : return "Drama";
        case COMEDY   : return "Comedy";
        case THRILLER : return "Thriller";
        case WESTERN  : return "Western";
        default : return "Unknown";
    }
}


void printfilm(film_t * film)
{
    printf("+---------------------\n");
    printf("| %s\n",gettitle(film));
    printf("| %d\n",getyear(film));
    printf("| Length: %d\n",getlength(film));
    printf("| Category: %s\n",categorytostring(getcategory(film)));
    printf("|\n");
}


void printshelf(film_t * shelf)
{
    while (shelf != NULL)
    {
        printfilm(shelf);
        shelf = getnext(shelf);
    }
}


void removefilm(film_t ** shelf, char * title)
{
    film_t * current = *shelf;
    film_t * previous = *shelf;

    while (current != NULL)
    {
        if (strcmp(title, gettitle(current)) == 0)
        {
            if (previous == current)
            {
                *shelf = getnext(current);
                current = *shelf;
                previous = *shelf;
                continue;
            }

            setnext(previous,getnext(current));
            free((void*)current);
            current = getnext(previous);
            continue;
        }
        previous = current;
        current = getnext(current);
    }
}


int main()
{
    film_t * shelf = NULL;

    insertfilm(&shelf, "Alien",    1979, 117, HORROR);
    insertfilm(&shelf, "Why me?",  1990,  87, COMEDY);
    insertfilm(&shelf, "Tron",     1982,  96, SCIFI);
    insertfilm(&shelf, "WarGames", 1983, 114, THRILLER);

    printshelf(shelf);

    removefilm(&shelf,"Why me?");

    printshelf(shelf);

    removefilm(&shelf,"Tron");
    removefilm(&shelf,"WarGames");
    removefilm(&shelf,"Alien");
    return 0;
}
